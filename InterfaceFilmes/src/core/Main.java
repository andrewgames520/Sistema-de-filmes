package core;

import controller.MenuController;
import repository.AtorRepository;
import repository.FilmeRepository;
import repository.GeneroRepository;
import view.MenuView;

public class Main {

	public static void main(String[] args) {
		
		FilmeRepository filmerepository = new FilmeRepository();
		GeneroRepository generoRepository = new GeneroRepository();
		AtorRepository atorRepository = new AtorRepository();
		 
		MenuView menu = new MenuView();
		MenuController controller = new MenuController(menu, filmerepository, generoRepository, atorRepository);
		menu.setVisible(true);
	}

}
