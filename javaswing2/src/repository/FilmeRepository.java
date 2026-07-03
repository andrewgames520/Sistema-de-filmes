package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public Optional<Filme> buscarId(Integer id) {
		return this.filmes.stream()
				.filter(filme-> filme.getId() == id)
				.findFirst();
		}
	public void atualizar(Filme filme) {
		for (int i = 0; i < filmes.size(); i++) {
			if(filme.getId() == filmes.get(i).getId()){
				filmes.set(i, filme);
				break;
			}
		}
	}

	public void excluir(Integer id) {
		this.filmes.removeIf(filme -> filme.getId() == id);
		
	}
}

