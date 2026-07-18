package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Genero;

public class GeneroRepository {
	private final List<Genero> Generos = new ArrayList<>();
	private Integer proximoId =1;
	
	public void adicionar(Genero genero) {
		genero.setId(proximoId);
		proximoId++;
		
		Generos.add(genero);
	}
	
	public List<Genero> listarTodos(){
		return Generos;
	}
	public Optional<Genero> BuscarId(Integer id){
		return this.Generos.stream()
				.filter(genero -> genero.getId() == id)
				.findFirst();
	}
	public Boolean buscarNome(String nome){
		for(Genero g: this.listarTodos()) {
			if(g.getNome().equalsIgnoreCase(nome))
				return true;
		}
		return false;
	}
	
	public Genero buscarGenero(String nome) {
		for (Genero genero : Generos) {
			if (genero.getNome().equals(nome)){
				return genero;	
				
			}
		}
		return null;
	}
	public void atualizar(Genero genero) {
		for(int i =0; i<Generos.size();i++) {
			if(genero.getId() == Generos.get(i).getId()) {
				Generos.set(i, genero);
				break;
			}
		}
	}
	public void excluir(Integer id) {
		this.Generos.removeIf(genero -> genero.getId() == id);
	}
}

