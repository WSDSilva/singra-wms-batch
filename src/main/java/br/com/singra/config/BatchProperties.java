package br.com.singra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource(value= {"classpath:application.properties","file:./appbatch.properties"})
public class BatchProperties {
	
	AppBatch appBatch;
	
	public AppBatch getAppBatch() {
		return appBatch;
	}

	public void setAppBatch(AppBatch appBatch) {
		this.appBatch = appBatch;
	}

	public static class AppBatch{
		String interval;
		
		String segundos;
		
		String minutos;
				
		String horas;
		
		String dias;
		
		String mes;
		
		String diasemana;

		public String getInterval() {
			return interval;
		}

		public void setInterval(String interval) {
			this.interval = interval;
		}

		public String getSegundos() {
			return setCronValue(segundos);
		}

		public void setSegundos(String segundos) {
			this.segundos = segundos;
		}

		public String getMinutos() {
			return setCronValue(minutos);
		}

		public void setMinutos(String minutos) {
			this.minutos = minutos;
		}

		public String getHoras() {
			return setCronValue(horas);
		}

		public void setHoras(String horas) {
			this.horas =  horas;
		}

		public String getDias() {
			return setCronValue(dias);
		}

		public void setDias(String dias) {
			this.dias = dias;
		}

		public String getMes() {
			return setCronValue(mes);
		}

		public void setMes(String mes) {
			this.mes = mes;
		}

		public String getDiasemana() {
			return setCronValue(diasemana);
		}

		public void setDiasemana(String diasemana) {
			this.diasemana = diasemana;
		}

		
		public String setCronValue(String valor) {
			/*
			 * ESTE MÉTODO NÃO ESTA FUNCIONADO. UMA POSSÍVEL SOLUÇÃO SERÁ UTILIZAR A
			 * NOTATION PATTERN
			 */
			String teste = valor == "*"? valor : "*/"+valor;
			return  teste;
		}
		
		
	}

}
