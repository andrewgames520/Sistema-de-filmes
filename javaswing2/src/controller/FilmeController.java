package controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Filme;
import repository.FilmeRepository;
import view.FilmeView;

public class FilmeController {
	private FilmeView view;
	private FilmeRepository repository;

	public FilmeController(FilmeView view, FilmeRepository repository) {
		this.view = view;
		this.repository = repository;
		configurarEventos();
		
		configurarEventos();
	}
	
	public void configurarEventos() {
		this.view.getSalvarButton().addActionListener(e -> salvarFilme());
		this.view.getExcluirButton().addActionListener(e -> excluirFilme());
		this.view.getNovoButton().addActionListener(e -> novoFilme());
		
		this.view.getFilmesTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				carregarFilmeSelecionodado();
				
			}
		});
			
		
	}
	
	
	public void carregarFilmeSelecionodado() {
		int linhaSelecionada = view.getFilmesTable().getSelectedRow();
		
		int linhaModelo = view.getFilmesTable().convertRowIndexToModel(linhaSelecionada);
		Integer id = (Integer) view.getFilmesTableModel().getValueAt(linhaModelo, 0) ;
		
		System.out.println(id);
	}
	public void salvarFilme() {
		Filme filme = new Filme();
		
		String titulo = view.getTituloField().getText();
		String genero = view.getGeneroField().getText();
		Integer duracao = (Integer)view.getDuracaoSpinner().getValue();
		if(titulo.isBlank()) {
			System.out.println("Titulo invalido");
			return;
		}
		if(genero.isBlank()) {
			System.out.println("Genero invalido");
			return;
		}
		
		
		filme.setTitulo(titulo);
		filme.setGenero(genero);
		filme.setDuracao(duracao);
		
		repository.adicionar(filme);
		limparCampos();
		montarTabela();
		
		for(Filme f : repository.listarTodos()) {
			System.err.println(f.getTitulo());
			System.err.println(f.getGenero());
			System.err.println(f.getDuracao());
		}
	}
	public void excluirFilme() {
		System.out.println("excluido");
	}
	public void novoFilme() {
		System.out.println("novo criado");
	}
	
	public void limparCampos() {
		this.view.getTituloField().setText("");
		this.view.getGeneroField().setText("");
		this.view.getDuracaoSpinner().setValue(1);
	}
	
	public void montarTabela() {
		view.getFilmesTableModel().setRowCount(0);
		
		for(Filme f : repository.listarTodos()) {
			view.getFilmesTableModel().addRow(
					new Object[]{
					
			f.getId(),
			f.getTitulo(),
			f.getGenero(),
			f.getDuracao()});
		}
		
	}
	
}
