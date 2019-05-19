package br.com.singra.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import br.com.singra.model.Categoria;

public class CategoriaRowMapper implements RowMapper<Categoria> {

	@Override
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {

		Categoria categoria = new Categoria();
		categoria.setCodigo(rs.getLong("codigo"));
		categoria.setNome(rs.getString("nome"));
		categoria.setMomento(rs.getString("momento"));
		
		
		return categoria;
	}

}
