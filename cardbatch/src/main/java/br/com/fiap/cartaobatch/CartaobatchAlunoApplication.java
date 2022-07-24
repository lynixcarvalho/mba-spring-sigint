package br.com.fiap.cartaobatch;

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
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

@SpringBootApplication
@EnableBatchProcessing
public class CartaobatchAlunoApplication {

    Logger logger = Logger.getLogger(CartaobatchAlunoApplication.class.getSimpleName());

	public static void main(String[] args) {
		SpringApplication.run(CartaobatchAlunoApplication.class, args);
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
			return aluno;
		};
	}

	@Bean
	public ItemWriter<Aluno> itemWriter(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Aluno>()
				.sql("insert into alunos(matricula, nome, turma, created_date , modified_date) values (:matricula, :nome, :turma, current_timestamp, current_timestamp)")
				.dataSource(dataSource)
				.beanMapped()
				.build();
	}

	@Bean
    public Step step(StepBuilderFactory stepBuilderFactory,
                     ItemReader<Aluno> itemReader,
                     ItemProcessor<Aluno, Aluno> itemProcessor,
                     ItemWriter<Aluno> itemWriter,
                     @Value("${file.chunk}") int chunkSize){
        return stepBuilderFactory.get("step chunk processando txt")
                .<Aluno, Aluno>chunk(chunkSize)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
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
