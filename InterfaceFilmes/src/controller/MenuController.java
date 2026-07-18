package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import core.Erros;
import repository.AtorRepository;
import repository.FilmeRepository;
import repository.GeneroRepository;
import view.AtorView;
import view.FilmeView;
import view.GeneroView;
import view.MenuView;

public class MenuController {
	private MenuView view;
	private final FilmeRepository filmeRepository;
	private final GeneroRepository generoRepository;
	private final AtorRepository atorRepository;

	public MenuController(MenuView view, FilmeRepository filmeRepository, GeneroRepository generoRepository, AtorRepository atorRepository) {
		this.view = view;
		this.filmeRepository = filmeRepository;
		this.generoRepository = generoRepository;
		this.atorRepository = atorRepository;
		configurarEventos();
	}
	
	public void configurarEventos() {
		this.view.getFilmeFrameButton().addActionListener(e -> AbrirFilmes());
		this.view.getGeneroFrameButton().addActionListener(e -> AbrirGeneros());
		this.view.getAtoresFrameButton().addActionListener(e -> AbrirAtores());
	}
	
	public void AbrirFilmes() {
		if(generoRepository.listarTodos().isEmpty() || atorRepository.listarTodos().isEmpty()) {
			Erros.MostrarErro("Adicione pelo menos um gênero e ator antes de tentar cadastras um filme", view);
			return;
		}
		FilmeView filmeView = new FilmeView();
		FilmeController filmeController = new FilmeController(filmeView, filmeRepository, generoRepository,atorRepository);
		filmeView.setVisible(true);
		this.view.getFilmeFrameButton().setEnabled(false);
		
		filmeView.addWindowListener(new  WindowAdapter(){
			@Override
			public void windowClosed (WindowEvent e) {
				view.getFilmeFrameButton().setEnabled(true);
			}
		});
	}
	
	public void AbrirGeneros() {
		GeneroView generoView = new GeneroView();
		GeneroController generoController = new GeneroController(generoView, generoRepository, filmeRepository);
		generoView.setVisible(true);
		this.view.getGeneroFrameButton().setEnabled(false);
		generoView.addWindowListener(new WindowAdapter() {
		
		@Override
		public void windowClosed (WindowEvent e) {
			view.getGeneroFrameButton().setEnabled(true);
		}
		});
	}
	
	public void AbrirAtores() {
		AtorView atorView = new AtorView();
		AtorController atorController = new AtorController(atorView, atorRepository, filmeRepository);
		atorView.setVisible(true);
		this.view.getAtoresFrameButton().setEnabled(false);
		atorView.addWindowListener(new WindowAdapter() {
		
			@Override
			public void windowClosed (WindowEvent e) {
				view.getAtoresFrameButton().setEnabled(true);
			}
		});
	}
	
}
