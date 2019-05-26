package br.com.singra.schenduler;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Agendador {
	
	@Autowired
	public JobLauncher jobLauncher;
	
	@Autowired
	public Job job;
	
	/* Nota: cron = "A B C D E F" 
	 * A - segundos (0-59)
	 * B - minutos (0-59)
	 * C - horas (0-23)
	 * D - dias  (1-31)
	 * E - mês (1-12)
	 * F - Dias da semana (0-6)
	 * "\*" - siguinifica qualquer valor */
//	  "*\numero - numero = quantide de incremento"
	 
	//executará a cada 10 segundos
	@Scheduled(cron="${appbatch.interval}")
	public void Agendador() {
		JobParameters jobParameters = new JobParameters();
		try {
			JobExecution exec = jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
