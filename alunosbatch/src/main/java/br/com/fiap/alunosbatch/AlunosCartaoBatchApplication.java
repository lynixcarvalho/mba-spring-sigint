package br.com.fiap.alunosbatch;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

@SpringBootApplication
@EnableBatchProcessing
public class AlunosCartaoBatchApplication {

    Logger logger = Logger.getLogger(AlunosCartaoBatchApplication.class.getSimpleName());

	public static void main(String[] args) {
		SpringApplication.run(AlunosCartaoBatchApplication.class, args);
	}

	@Bean
	public ItemReader<Aluno> itemReader (@Value ("${file.resource}") Resource resource){
		return new FlatFileItemReaderBuilder<Aluno>()
					.name("clientes file reader")
					.resource(resource)
					.linesToSkip(1)
					.lineMapper(lineMapper())
					.build();
	}

	private LineMapper<Aluno> lineMapper() {
		return new LineMapper<Aluno>() {
			@Override
			public Aluno mapLine(String line, int lineNumber) throws Exception {
				Aluno aluno = new Aluno();
			  	String nome = line.substring(0, 40); 
			  	String matricula = line.substring(41, 48);
				String turma = line.substring(49, 55);
			  	aluno.setNome(nome);
			  	aluno.setMatricula(Integer.parseInt(matricula)); 
				aluno.setTurma(turma);
			  	return aluno;
			}
		 };
	}

	@Bean
	public ItemProcessor<Aluno, Aluno> itemProcessor(){
		logger.info("Processando arquivo");
		return aluno -> {
			aluno.setNome(aluno.getNome().toLowerCase());
			aluno.setCartao(new Cartao(getCardNumber(), getValidateDate(), aluno.getMatricula()));
			return aluno;
		};
	}

	private Long getCardNumber(){
		Random rand = new Random();
        int prefix = 99;
        long x = (long)(rand.nextDouble()*100000000000000L);
        String s = String.valueOf(prefix) + String.format("%014d", x);
        Long cartao = Long.valueOf(s);
        return cartao;
	}

	private Date getValidateDate(){
		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 3);             
        return new Timestamp(calendar.getTimeInMillis());
	}	

	@Bean
	public CompositeItemWriter<Aluno> compositeItemWriter(DataSource dataSource, ItemPreparedStatementSetter<Aluno> itemPreparedStatementSetter){
		CompositeItemWriter<Aluno> writer = new CompositeItemWriter<Aluno>();
		writer.setDelegates(Arrays.asList( itemWriterAluno(dataSource), itemWriterCartao(dataSource, itemPreparedStatementSetter)));
		return writer;
	}


	@Bean
	public ItemWriter<Aluno> itemWriterAluno(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Aluno>()
				.sql("insert into alunos(matricula, nome, turma, created_date, modified_date) values (:matricula, :nome, :turma, current_timestamp, current_timestamp)")
				.dataSource(dataSource)
				.beanMapped()
				.build();
	}

	@Bean
	public ItemWriter<Aluno> itemWriterCartao(DataSource dataSource, ItemPreparedStatementSetter<Aluno> itemPreparedStatementSetter) {
		return new JdbcBatchItemWriterBuilder<Aluno>()
				.itemPreparedStatementSetter(itemPreparedStatementSetter)
				.sql("insert into cartao(cartao, limite, senha, created_date, expired_date, cancel_date, alunos_id)"+
				                         " values (?, ?, ?, ?, ?, ?, ?)")
				.dataSource(dataSource)
				.beanMapped()
				.build();
	}

	@Bean
    public Step step(StepBuilderFactory stepBuilderFactory,
                     ItemReader<Aluno> itemReader,
                     ItemProcessor<Aluno, Aluno> itemProcessor,
					 CompositeItemWriter<Aluno> compositeItemWriter,
                     @Value("${file.chunk}") int chunkSize){
        return stepBuilderFactory.get("step chunk processando txt")
                .<Aluno, Aluno>chunk(chunkSize)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(compositeItemWriter)
                .allowStartIfComplete(true)
                .build();
    }

	@Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   Step step){
        return jobBuilderFactory.get("job process file")
                .start(step)
                .build();
    }
}