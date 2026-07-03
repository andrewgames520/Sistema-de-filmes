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
		if (linhaSelecionada == -1) {
		    return;
		}
		
		view.getExcluirButton().setEnabled(true);

		int linhaModelo = view.getFilmesTable().convertRowIndexToModel(linhaSelecionada);
		Integer id = (Integer) view.getFilmesTableModel().getValueAt(linhaModelo, 0) ;
		
		this.repository.buscarId(id)
		.ifPresent(this::preencherCampos);
		
		System.out.println(id);
	}
	
	public void preencherCampos(Filme filme) {
		view.getTituloField().setText(filme.getTitulo());
		
		view.getGeneroField().setText(filme.getGenero());
		
		view.getDuracaoSpinner().setValue(filme.getDuracao());
		
		view.getIdField().setText(filme.getId().toString());
	}
	
	public void salvarFilme() {
		
		String titulo = view.getTituloField().getText();
		String genero = view.getGeneroField().getText();
		Integer duracao = (Integer)view.getDuracaoSpinner().getValue();
		String id = view.getIdField().getText();
		
		
		
		
		if(titulo.isBlank()) {
			System.out.println("Titulo invalido");
			System.out.println(titulo);
			return;
		}
		if(genero.isBlank()) {
			System.out.println("Genero invalido");
			return;
		}
		Filme filme = new Filme();
		filme.setTitulo(titulo);
		filme.setGenero(genero);
		filme.setDuracao(duracao);
		
		if(id.isBlank()) {
			
			repository.adicionar(filme);
		}else {
			filme.setId(Integer.parseInt(id));
			repository.atualizar(filme);
			
		}
		
		limparCampos();
		montarTabela();
		
		for(Filme f : repository.listarTodos()) {
			System.out.println(f.getTitulo());
			System.out.println(f.getGenero());
			System.out.println(f.getDuracao());
		}
	}
	public void excluirFilme() {
		String id = view.getIdField().getText();
		
		repository.excluir(Integer.parseInt(id));
		limparCampos();
		montarTabela();
		
	}
	public void novoFilme() {
		limparCampos();
	}
	
	public void limparCampos() {
		this.view.getTituloField().setText("");
		this.view.getGeneroField().setText("");
		this.view.getDuracaoSpinner().setValue(1);
		this.view.getIdField().setText("");
		this.view.getExcluirButton().setEnabled(false);
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
