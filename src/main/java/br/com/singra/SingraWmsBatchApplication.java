package br.com.singra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class SingraWmsBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingraWmsBatchApplication.class, args);
	}

}
