package model;

import java.util.List;

public class Filme {
	private Integer Id;
	private String titulo;
	private Integer duracao;
	private Genero genero;
	private List <Ator> atores;
	
	public Integer getId() {
		return Id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	
	public void setId(Integer Id) {
		this.Id = Id;
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	
}
