package repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Ator;
import model.Genero;



public class AtorRepository {
	private final List<Ator> atores = new ArrayList<>();
	private final List<Runnable>Listeners = new ArrayList<>();
	private Integer proximoId =1;
	
	public void adicionar(Ator ator) {
		ator.setId(proximoId);
		proximoId++;
		atores.add(ator);
		notificarListeners();
	}
	
	public List<Ator> listarTodos(){
		return atores;
	}
	public Optional<Ator> BuscarId(Integer id){
		return this.atores.stream()
				.filter(ator -> ator.getId() == id)
				.findFirst();
	}
	public Boolean BuscarNome(String nome){
		for(Ator g: this.listarTodos()) {
			if(g.getNome().equalsIgnoreCase(nome))
				return true;
		}
		return false;
	}
	public void atualizar(Ator ator) {
		for(int i =0; i<atores.size();i++) {
			if(ator.getId() == atores.get(i).getId()) {
				atores.set(i, ator);
				break;
			}
		}
		notificarListeners();
	}
	
	public void notificarListeners() {
		for(Runnable listener: Listeners) {
			listener.run();
		}
	}
	public List<Ator> buscarAtor(List<String> alvos) {
		List<Ator> lista = new ArrayList<Ator>();
		for (Ator ator : atores) {
			if (alvos.contains(ator.getNome())){
				lista.add(ator);
			}
		}
		return lista;
	}
	public void addChangeListener(Runnable listener) {
		Listeners.add(listener);
	}
	public void excluir(Integer id) {
		this.atores.removeIf(ator -> ator.getId() == id);
		notificarListeners();
	}
}

