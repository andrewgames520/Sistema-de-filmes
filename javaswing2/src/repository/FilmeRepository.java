package repository;

import java.util.ArrayList;
import java.util.List;

import model.Filme;

public class FilmeRepository {
	private final List<Filme> filmes = new ArrayList<>();
	private Integer proximoId = 1;
	
	public void adicionar(Filme filme) {
		filme.setId(proximoId);
		proximoId++;
		
		filmes.add(filme);
	}
	
	public List<Filme> listarTodos(){
		return filmes;
	}
}
