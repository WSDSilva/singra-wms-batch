package br.com.singra.model;

public class Categoria{

	private Long codigo;
	
	private String nome;
	
	private String momento;	


	public Categoria(Long codigo, String nome, String momento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.momento = momento;
	}


	public Categoria() {}


	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMomento() {
		return momento;
	}


	public void setMomento(String momento) {
		this.momento = momento;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
