package br.com.singra.config;

import java.net.URI;
import java.util.List;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import br.com.singra.model.Categoria;

public class RestWriter extends JdbcBatchItemWriter<Categoria> {

	private static final String URIPOST = "http://localhost:8443/categorias/batch";
	
	private static HttpEntity<Categoria> request;
	
	@Override
	public void write(List<? extends Categoria> items) throws Exception {
		super.write(items);
		RestTemplate restEnvio = new RestTemplate();
		
		
		for (Categoria categoria : items) {
			request = new HttpEntity<Categoria>(categoria);
			System.out.println(restEnvio.postForObject(new URI(URIPOST), request, Categoria.class).getMomento());
			
		}
	}
	
	

}
