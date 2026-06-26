package model;

public class Filme {
	private Integer Id;
	private String titulo;
	private String genero;
	private Integer duracao;
	
	public Integer getId() {
		return Id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
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
	
	
}
