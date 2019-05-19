package br.com.singra.config;

import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestClientException;

import br.com.singra.model.Categoria;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public DataSource getDataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("WANDERSON_DBA");
		dataSource.setPassword("wsds");
		
		return dataSource;
	}
	
	
	@Bean(destroyMethod="")
	public JdbcCursorItemReader<Categoria> reader(){
		JdbcCursorItemReader<Categoria> reader = new JdbcCursorItemReader<Categoria>();
		reader.setDataSource(dataSource);
		reader.setSql("SELECT CODIGO, NOME, MOMENTO FROM CATEGORIA");
		reader.setRowMapper(new CategoriaRowMapper());
		
		return reader;
	}
	
	public CategoriaItemProcessor processor() {
		return new CategoriaItemProcessor();
	}
	
	
	@Bean
	public JdbcBatchItemWriter<Categoria> writer() throws RestClientException, URISyntaxException{
//		JdbcBatchItemWriter<Categoria> writer = new JdbcBatchItemWriter<Categoria>();
		RestWriter writer = new RestWriter();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Categoria>());
		writer.setDataSource(dataSource);
		writer.setSql("UPDATE CATEGORIA SET MOMENTO = :momento");

		
		return writer;
	}
	
	@Bean
	public Step stepWms() throws RestClientException, URISyntaxException {
		return stepBuilderFactory.get("stepWms")
				.<Categoria,Categoria>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	@Bean
	public Job jobWms() throws RestClientException, URISyntaxException {
		return jobBuilderFactory.get("jobWms")
				.incrementer(new RunIdIncrementer())
				.flow(stepWms())
				.end()
				.build();
	}
	
	
	
}
