package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;

public class FilmeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel tituloPgLabel;
	private JLabel tituloLabel;
	private JLabel generoLabel;
	private JLabel duracaoLabel;
	private JTextField tituloField;
	private JSpinner duracaoSpinner;
	private JTable filmesTable;
	private JButton novoButton;
	private JButton excluirButton;
	private JButton salvarButton;
	private DefaultTableModel filmesTableModel;
	private JLabel idLabel;
	private JTextField idField;
	private JComboBox generoBox;
	private JList atorList;
	private DefaultListModel atorListModel;

	

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilmeView frame = new FilmeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 */
	/**
	 * Create the frame.
	 */
	public FilmeView() {
		setTitle("Filmes");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 426);
		contentPane = new JPanel();
		contentPane.setBounds(8, 31, 66, 261);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tituloPgLabel = new JLabel("Cadastro de Filme");
		tituloPgLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		tituloPgLabel.setBounds(172, 22, 101, 14);
		contentPane.add(tituloPgLabel);
		
		tituloLabel = new JLabel("Titulo:");
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		tituloLabel.setBounds(10, 135, 64, 14);
		contentPane.add(tituloLabel);
		
		generoLabel = new JLabel("Genêro:");
		generoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		generoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		generoLabel.setBounds(10, 166, 64, 14);
		contentPane.add(generoLabel);
		
		duracaoLabel = new JLabel("Duração:");
		duracaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		duracaoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		duracaoLabel.setBounds(10, 197, 64, 14);
		contentPane.add(duracaoLabel);
		
		tituloField = new JTextField();
		tituloField.setBounds(84, 133, 86, 20);
		contentPane.add(tituloField);
		tituloField.setColumns(10);
		
		duracaoSpinner = new JSpinner();
		duracaoSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		duracaoSpinner.setBounds(84, 195, 53, 20);
		contentPane.add(duracaoSpinner);
		
		novoButton = new JButton("Novo");
		novoButton.setBounds(10, 222, 89, 23);
		contentPane.add(novoButton);
		
		salvarButton = new JButton("Salvar");
		salvarButton.setBounds(109, 222, 89, 23);
		contentPane.add(salvarButton);
		
		excluirButton = new JButton("Excluir");
		excluirButton.setBounds(208, 222, 89, 23);
		excluirButton.setEnabled(false);
		contentPane.add(excluirButton);
		
		filmesTableModel = new DefaultTableModel(new Object[] {"ID","Titulo","Genêro","Duração","Quantidade de atores"},0){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		idLabel.setBounds(32, 110, 23, 14);
		contentPane.add(idLabel);
		
		idField = new JTextField();
		idField.setEnabled(false);
		idField.setEditable(false);
		idField.setBounds(84, 102, 86, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 256, 414, 120);
		contentPane.add(scrollPane);
		
		filmesTable = new JTable(filmesTableModel);
		scrollPane.setViewportView(filmesTable);
		
		filmesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		JLabel atorLabel = new JLabel("Atores:");
		atorLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		atorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atorLabel.setBounds(357, 68, 50, 14);
		contentPane.add(atorLabel);
		
		generoBox = new JComboBox();
		generoBox.setBounds(84, 163, 86, 22);
		contentPane.add(generoBox);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(338, 93, 86, 118);
		contentPane.add(scrollPane_1);
		
		atorListModel = new DefaultListModel();
		atorList = new JList(atorListModel);
		scrollPane_1.setViewportView(atorList);
		atorList.setSelectionMode(
				ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
				);
		filmesTable.getTableHeader().setReorderingAllowed(false);
		
		
	}
	
	public DefaultListModel getAtorListModel() {
		return atorListModel;
	}

	public void setAtorListModel(DefaultListModel atorListModel) {
		this.atorListModel = atorListModel;
	}

	public DefaultTableModel getFilmesTableModel() {
		return filmesTableModel;
	}

	public void setFilmesTableModel(DefaultTableModel filmesTableModel) {
		this.filmesTableModel = filmesTableModel;
	}

	public JLabel getTituloPgLabel() {
		return tituloPgLabel;
	}

	public void setTituloPgLabel(JLabel tituloPgLabel) {
		this.tituloPgLabel = tituloPgLabel;
	}

	public JLabel getTituloLabel() {
		return tituloLabel;
	}

	public void setTituloLabel(JLabel tituloLabel) {
		this.tituloLabel = tituloLabel;
	}

	public JLabel getGeneroLabel() {
		return generoLabel;
	}

	public void setGeneroLabel(JLabel generoLabel) {
		this.generoLabel = generoLabel;
	}
	
	
	public JComboBox getGeneroBox() {
		return generoBox;
	}

	public void setGeneroBox(JComboBox generoBox) {
		this.generoBox = generoBox;
	}

	public JLabel getDuracaoLabel() {
		return duracaoLabel;
	}

	public void setDuracaoLabel(JLabel duracaoLabel) {
		this.duracaoLabel = duracaoLabel;
	}

	public JTextField getTituloField() {
		return tituloField;
	}

	public void setTituloField(JTextField tituloField) {
		this.tituloField = tituloField;
	}

	

	public JList getAtorList() {
		return atorList;
	}

	public void setAtorList(JList atorList) {
		this.atorList = atorList;
	}

	public JSpinner getDuracaoSpinner() {
		return duracaoSpinner;
	}

	public void setDuracaoSpinner(JSpinner duracaoSpinner) {
		this.duracaoSpinner = duracaoSpinner;
	}

	public JTable getFilmesTable() {
		return filmesTable;
	}

	public void setFilmesTable(JTable filmesTable) {
		this.filmesTable = filmesTable;
	}

	public JButton getNovoButton() {
		return novoButton;
	}

	public void setNovoButton(JButton novoButton) {
		this.novoButton = novoButton;
	}

	public JButton getExcluirButton() {
		return excluirButton;
	}

	public void setExcluirButton(JButton excluirButton) {
		this.excluirButton = excluirButton;
	}

	public JButton getSalvarButton() {
		return salvarButton;
	}

	public void setSalvarButton(JButton salvarButton) {
		this.salvarButton = salvarButton;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}
}
