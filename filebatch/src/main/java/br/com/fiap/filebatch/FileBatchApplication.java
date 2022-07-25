package br.com.fiap.filebatch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBatchProcessing
public class FileBatchApplication {
    
    Logger logger = Logger.getLogger(FileBatchApplication.class.getSimpleName());
    public static void main(String[] args) {
        SpringApplication.run(FileBatchApplication.class, args);
    }

    @Bean
	public Tasklet tasklet(@Value("${inputfile.path}") String fileIPath ,
	                       @Value("${outputfile.path}") String fileOPath) {
		return (stepContribution, chunkContext) -> {

			File fileOld = Paths.get(fileOPath).toFile();
			if (fileOld.delete()) {
				logger.info("deletado arquivo anterior: " + fileOPath );
			} 

			File inputFile = Paths.get(fileIPath).toFile();
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));

			File outputFile = new File(fileOPath);
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			String line;

			while ((line = reader.readLine()) != null){
				if(!line.trim().equals("")){
					if(!line.contains("---")){
						line += System.lineSeparator();
						writer.write(line);
					}
				}
			}
			logger.info("arquivo copiado");
			reader.close();
			writer.close();
			return RepeatStatus.FINISHED;
		};
	}
 
	@Bean
	public Step step(StepBuilderFactory stepBuilderFactory,
					 Tasklet tasklet){
		return stepBuilderFactory.get("delete step")
				.tasklet(tasklet)
				.allowStartIfComplete(true)
				.build();
	}
 
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
				   Step step){
		return jobBuilderFactory.get("delete job")
				.start(step)
				.build();
	}


}
