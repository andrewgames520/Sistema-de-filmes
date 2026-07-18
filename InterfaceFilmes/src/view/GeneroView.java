package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeneroView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField generoField;
	private JTextField idField;
	private JTable generoTable;
	private DefaultTableModel generoTableModel;
	private JButton novoButton, salvarButton, excluirButton;

	/**
	 * Launch the application.
	public void Genero() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneroView frame = new GeneroView();
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
	public GeneroView() {
		setTitle("Generos");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel generoLabel = new JLabel("Gênero");
		generoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		generoLabel.setBounds(80, 11, 92, 14);
		generoLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(generoLabel);
		
		generoField = new JTextField();
		generoField.setHorizontalAlignment(SwingConstants.CENTER);
		generoField.setBounds(94, 36, 63, 20);
		contentPane.add(generoField);
		generoField.setColumns(10);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(268, 11, 42, 14);
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(idLabel);
		
		idField = new JTextField();
		idField.setHorizontalAlignment(SwingConstants.CENTER);
		idField.setBounds(250, 36, 86, 20);
		idField.setEditable(false);
		contentPane.add(idField);
		idField.setColumns(10);
		
		salvarButton = new JButton("Salvar");
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		salvarButton.setBounds(94, 66, 78, 23);
		contentPane.add(salvarButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(94, 101, 242, 102);
		contentPane.add(scrollPane);
		
		generoTableModel = new DefaultTableModel(new Object[]{"ID","Gênero"},0) {
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};
		
		generoTable = new JTable(generoTableModel);
		scrollPane.setViewportView(generoTable);
		
		generoTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		generoTable.getTableHeader().setReorderingAllowed(false);
		
		excluirButton = new JButton("Excluir");
		excluirButton.setBounds(252, 66, 84, 23);
		contentPane.add(excluirButton);
		
		novoButton = new JButton("Novo");
		novoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		novoButton.setBounds(177, 66, 65, 23);
		contentPane.add(novoButton);

	}

	public JTextField getGeneroField() {
		return generoField;
	}

	public void setGeneroField(JTextField generoField) {
		this.generoField = generoField;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JTable getGeneroTable() {
		return generoTable;
	}

	public void setGeneroTable(JTable generoTable) {
		this.generoTable = generoTable;
	}

	public DefaultTableModel getGeneroTableModel() {
		return generoTableModel;
	}

	public void setGeneroTableModel(DefaultTableModel generoTableModel) {
		this.generoTableModel = generoTableModel;
	}

	public JButton getNovoButton() {
		return novoButton;
	}

	public void setNovoButton(JButton novoButton) {
		this.novoButton = novoButton;
	}

	public JButton getSalvarButton() {
		return salvarButton;
	}

	public void setSalvarButton(JButton salvarButton) {
		this.salvarButton = salvarButton;
	}

	public JButton getExcluirButton() {
		return excluirButton;
	}

	public void setExcluirButton(JButton excluirButton) {
		this.excluirButton = excluirButton;
	}

	

	
}
