package br.com.singra.config;

import java.time.LocalDateTime;

import org.springframework.batch.item.ItemProcessor;

import br.com.singra.model.Categoria;

public class CategoriaItemProcessor implements ItemProcessor<Categoria, Categoria> {

	@Override
	public Categoria process(Categoria categoria) throws Exception {
		LocalDateTime agora =  LocalDateTime.now();
		String strAgora = agora.toString(); 
		categoria.setMomento(strAgora);
			
		return categoria;
	}

}
