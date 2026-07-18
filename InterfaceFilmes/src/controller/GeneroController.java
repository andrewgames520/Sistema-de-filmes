package controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import core.Erros;
import model.Genero;
import repository.FilmeRepository;
import repository.GeneroRepository;
import view.GeneroView;

public class GeneroController {
	private GeneroView generoView;
	private GeneroRepository generoRepository;
	private FilmeRepository filmeRepository;
	
	public GeneroController(GeneroView generoView, GeneroRepository generoRepository, FilmeRepository filmeRepository) {
		super();
		this.filmeRepository = filmeRepository;
		this.generoView = generoView;
		this.generoRepository = generoRepository;
		configurarEventos();
	}
	
	public void configurarEventos(){
		this.generoView.getSalvarButton().addActionListener(e -> salvarGenero());
		this.generoView.getNovoButton().addActionListener(e -> novoGenero());
		this.generoView.getExcluirButton().addActionListener(e -> excluirGenero());
		this.generoView.getGeneroTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					carregarGeneroSelecionado();
				}
				
			}
		});
		montarTabela();
	}
	
	public void carregarGeneroSelecionado() {
		int linhaSelecionada = generoView.getGeneroTable().getSelectedRow();
		if(linhaSelecionada == -1) {
			return;
		}
		
		generoView.getExcluirButton().setEnabled(true);
		int linhaModelo = generoView.getGeneroTable().convertRowIndexToModel(linhaSelecionada);
		Integer id = (Integer) generoView.getGeneroTableModel().getValueAt(linhaModelo,0);
		this.generoRepository.BuscarId(id).ifPresent(this::preencherCampos);;
	}
	
	public void preencherCampos(Genero genero) {
		generoView.getGeneroField().setText(genero.getNome());
		generoView.getIdField().setText(genero.getId().toString());
	}
	public void salvarGenero() {
		String nome = generoView.getGeneroField().getText();
		String id = generoView.getIdField().getText();
		if(nome.isBlank()) {
			Erros.MostrarErro("Genero inválido", generoView);
			return;
		}
		
		Genero genero = new Genero();
		genero.setNome(nome);
		if(id.isBlank()) {
			if(generoRepository.buscarNome(nome)){
				Erros.MostrarErro("Genêro já existente", generoView);
				return;
			}
			generoRepository.adicionar(genero);
		}else {
			genero.setId(Integer.parseInt(id));
			generoRepository.atualizar(genero);
		}
		
		limparCampos();
		montarTabela();
	}
	
	public void novoGenero() {
		limparCampos();
	}
	
	public void excluirGenero() {
		String id = generoView.getIdField().getText();
		String genero = generoView.getGeneroField().getText();
		if(filmeRepository.isGeneroPresent(genero)) {
			Erros.MostrarErro(genero + " está sendo utilizado em um filme", generoView);
			return;
		}
		generoRepository.excluir(Integer.parseInt(id));
		limparCampos();
		montarTabela();
	}
	public void montarTabela() {
		generoView.getGeneroTableModel().setRowCount(0);
		for(Genero g : generoRepository.listarTodos()) {
			generoView.getGeneroTableModel().addRow(new Object[] {
					g.getId(),
					g.getNome()});
		}
	}
	public void limparCampos() {
		generoView.getIdField().setText("");
		generoView.getGeneroField().setText("");
		generoView.getExcluirButton().setEnabled(false);
	}
}
