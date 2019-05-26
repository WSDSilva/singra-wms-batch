package br.com.singra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.singra.config.BatchProperties;

@SpringBootApplication
public class SingraWmsBatchApplication implements CommandLineRunner{

	@Autowired
	BatchProperties batchProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(SingraWmsBatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(batchProperties.getAppBatch().getInterval());
	}

}
