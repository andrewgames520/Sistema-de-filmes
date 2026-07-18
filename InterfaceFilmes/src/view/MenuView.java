package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton FilmeFrameButton, GeneroFrameButton, AtoresFrameButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuView() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FilmeFrameButton = new JButton("Filmes");
		FilmeFrameButton.setBounds(170, 157, 89, 23);
		contentPane.add(FilmeFrameButton);
		
		GeneroFrameButton = new JButton("Gênero");
		GeneroFrameButton.setBounds(170, 89, 89, 23);
		contentPane.add(GeneroFrameButton);
		
		AtoresFrameButton = new JButton("Atores");
		AtoresFrameButton.setBounds(170, 123, 89, 23);
		contentPane.add(AtoresFrameButton);
		
		
	}

	public JButton getFilmeFrameButton() {
		return FilmeFrameButton;
	}

	public void setFilmeFrameButton(JButton filmeFrameButton) {
		FilmeFrameButton = filmeFrameButton;
	}

	public JButton getGeneroFrameButton() {
		return GeneroFrameButton;
	}

	public void setGeneroFrameButton(JButton generoFrameButton) {
		GeneroFrameButton = generoFrameButton;
	}

	public JButton getAtoresFrameButton() {
		return AtoresFrameButton;
	}

	public void setAtoresFrameButton(JButton atoresFrameButton) {
		AtoresFrameButton = atoresFrameButton;
	}
	
	

}
