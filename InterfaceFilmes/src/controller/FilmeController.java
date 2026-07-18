package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import core.Erros;
import model.Ator;
import model.Filme;
import model.Genero;
import repository.AtorRepository;
import repository.FilmeRepository;
import repository.GeneroRepository;
import view.FilmeView;

public class FilmeController {
	private FilmeView view;
	private FilmeRepository repository;
	private GeneroRepository generoRepository;
	private AtorRepository atorRepository;

	public FilmeController(FilmeView view, FilmeRepository repository, GeneroRepository generoRepository, AtorRepository atorRepository) {
		this.view = view;
		this.repository = repository;
		this.generoRepository = generoRepository;
		this.atorRepository = atorRepository;
		atorRepository.addChangeListener(this::criarAtorList);
		configurarEventos();
		
	}
	
	public void configurarEventos() {
		this.view.getSalvarButton().addActionListener(e -> salvarFilme());
		this.view.getExcluirButton().addActionListener(e -> excluirFilme());
		this.view.getNovoButton().addActionListener(e -> novoFilme());
		this.view.getFilmesTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					carregarFilmeSelecionodado();					
				}
				
			}
		});
		criarGeneroBox();
		this.view.getGeneroBox().addPopupMenuListener(new PopupMenuListener() {
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				criarGeneroBox();
				
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		
				
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
		
			}
		});
		criarAtorList();
		montarTabela();
	}
	
	public void criarGeneroBox() {
		this.view.getGeneroBox().removeAllItems();
		for (Genero genero : this.generoRepository.listarTodos()) {
			this.view.getGeneroBox().addItem(genero.getNome());
		}
	}
	public void criarAtorList() {
		this.view.getAtorListModel().removeAllElements();
		for (Ator ator : atorRepository.listarTodos()) {
			this.view.getAtorListModel().addElement(ator.getNome());
		}
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
		
	}
	
	public void preencherCampos(Filme filme) {
		view.getTituloField().setText(filme.getTitulo());
		
		view.getGeneroBox().setSelectedItem(filme.getGenero());
		
		view.getDuracaoSpinner().setValue(filme.getDuracao());
		
		view.getIdField().setText(filme.getId().toString());
		view.getAtorList().clearSelection();
		selecionarAtores(filme);
	}
	public void selecionarAtores(Filme filme) {
		List<String> nomesAtoresFilme = filme.getAtores().stream()
			    .map(Ator::getNome)
			    .collect(Collectors.toList());

			List<Integer> indices = new ArrayList<>();

			for (int i = 0; i < view.getAtorListModel().getSize(); i++) {
			    String nomeNaLista = (String) view.getAtorListModel().getElementAt(i);
			    if (nomesAtoresFilme.contains(nomeNaLista)) {
			        indices.add(i);
			    }
			}

			int[] indicesArray = indices.stream().mapToInt(Integer::intValue).toArray();
			view.getAtorList().setSelectedIndices(indicesArray);
	}
	public void salvarFilme() {
		
		String titulo = view.getTituloField().getText();
		String nome = view.getGeneroBox().getSelectedItem()+"";
		Integer duracao = (Integer)view.getDuracaoSpinner().getValue();
		String id = view.getIdField().getText();
		List<String> atores = view.getAtorList().getSelectedValuesList();
		
		
		
		
		if(titulo.isBlank()) {
			Erros.MostrarErro("Titulo inválido", view);
			return;
		}
		/*
		if(genero.isBlank()) {
			Erros.MostrarErro("Genero inválido", view);
			return;
		}
		*/
		if(atores.isEmpty()) {
			Erros.MostrarErro("Selecione pelo menos um ator", view);
			return;
		}
		Filme filme = new Filme();
		filme.setTitulo(titulo);
		filme.setGenero(generoRepository.buscarGenero(nome));
		filme.setDuracao(duracao);
		filme.setAtores(this.atorRepository.buscarAtor(atores));
		
		if(id.isBlank()) {
			
			repository.adicionar(filme);
		}else {
			filme.setId(Integer.parseInt(id));
			repository.atualizar(filme);
			
		}
		
		limparCampos();
		montarTabela();
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
		//this.view.getGeneroField().setText("");
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
			f.getGenero().getNome(),
			f.getDuracao(),
			f.getAtores().size()});
		}
		
	}
	
}
