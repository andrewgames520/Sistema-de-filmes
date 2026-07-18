package controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import core.Erros;
import model.Ator;
import model.Genero;
import repository.AtorRepository;
import repository.FilmeRepository;
import view.AtorView;

public class AtorController {
	private AtorView atorView;
	private AtorRepository atorRepository;
	private FilmeRepository filmeRepository;
	
	public AtorController(AtorView atorView, AtorRepository atorRepository,FilmeRepository filmeRepository) {
		this.filmeRepository = filmeRepository;
		this.atorView = atorView;
		this.atorRepository = atorRepository;
		configurarEventos();
	}
	
	public void configurarEventos(){
		this.atorView.getSalvarButton().addActionListener(e -> salvarGenero());
		this.atorView.getNovoButton().addActionListener(e -> novoGenero());
		this.atorView.getExcluirButton().addActionListener(e -> excluirGenero());
		this.atorView.getAtorTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
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
		int linhaSelecionada = atorView.getAtorTable().getSelectedRow();
		if(linhaSelecionada == -1) {
			return;
		}
		
		atorView.getExcluirButton().setEnabled(true);
		int linhaModelo = atorView.getAtorTable().convertRowIndexToModel(linhaSelecionada);
		Integer id = (Integer) atorView.getAtorTableModel().getValueAt(linhaModelo,0);
		this.atorRepository.BuscarId(id).ifPresent(this::preencherCampos);;
	}
	
	public void preencherCampos(Ator ator) {
		atorView.getAtorField().setText(ator.getNome());
		atorView.getIdField().setText(ator.getId().toString());
	}
	public void salvarGenero() {
		String nome = atorView.getAtorField().getText();
		String id = atorView.getIdField().getText();
		if(nome.isBlank()) {
			Erros.MostrarErro("Ator inválido", atorView.getContentPane());
			return;
		}
		
		Ator ator = new Ator();
		ator.setNome(nome);
		if(id.isBlank()) {
			if(atorRepository.BuscarNome(nome)) {
				Erros.MostrarErro("Ator já existente", atorView);
				return;
				
			}				
			atorRepository.adicionar(ator);
		}else {
			ator.setId(Integer.parseInt(id));
			atorRepository.atualizar(ator);
		}
		
		limparCampos();
		montarTabela();
	}
	
	public void novoGenero() {
		limparCampos();
	}
	
	public void excluirGenero() {
		String id = atorView.getIdField().getText();
		String ator = atorView.getAtorField().getText();
		if(filmeRepository.isAtorPresent(ator)) {
			Erros.MostrarErro(ator + " está sendo utilizado em um filme", atorView);
			return;
		}
		atorRepository.excluir(Integer.parseInt(id));
		limparCampos();
		montarTabela();
	}
	public void montarTabela() {
		atorView.getAtorTableModel().setRowCount(0);
		for(Ator a : atorRepository.listarTodos()) {
			atorView.getAtorTableModel().addRow(new Object[] {
					a.getId(),
					a.getNome()});
		}
	}
	public void limparCampos() {
		atorView.getIdField().setText("");
		atorView.getAtorField().setText("");
		atorView.getExcluirButton().setEnabled(false);
	}
}
