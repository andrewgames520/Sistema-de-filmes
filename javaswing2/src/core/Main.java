package core;

import controller.FilmeController;
import repository.FilmeRepository;
import view.FilmeView;

public class Main {

	public static void main(String[] args) {
		FilmeView view = new FilmeView();
		FilmeRepository repository = new FilmeRepository();
		FilmeController controller = new FilmeController(view, repository);
		
		view.setVisible(true);
	}

}
