package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AtorView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField atorField;
	private JTextField idField;
	private JTable atorTable;
	private DefaultTableModel atorTableModel;
	private JButton salvarButton, excluirButton, novoButton;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtorView frame = new AtorView();
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
	public AtorView() {
		setTitle("Atores");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel AtorLabel = new JLabel("Ator");
		AtorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AtorLabel.setBounds(61, 25, 46, 14);
		contentPane.add(AtorLabel);
		
		JLabel IdLabel = new JLabel("Id");
		IdLabel.setBounds(275, 25, 46, 14);
		IdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(IdLabel);
		
		atorField = new JTextField();
		atorField.setBounds(46, 50, 86, 20);
		atorField.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(atorField);
		atorField.setColumns(10);
		
		idField = new JTextField();
		idField.setBounds(253, 50, 86, 20);
		idField.setHorizontalAlignment(SwingConstants.CENTER);
		idField.setEditable(false);
		idField.setFocusable(false);
		contentPane.add(idField);
		idField.setColumns(10);
		
		salvarButton = new JButton("Salvar");
		salvarButton.setBounds(46, 81, 89, 23);
		//salvarButton.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(salvarButton);
		
		excluirButton = new JButton("Excluir");
		excluirButton.setBounds(250, 81, 89, 23);
		//excluirButton.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(excluirButton);
		
		novoButton = new JButton("Novo");
		novoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		novoButton.setBounds(145, 81, 89, 23);
		//novoButton.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(novoButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 115, 293, 135);
		contentPane.add(scrollPane);
		
		atorTableModel = new DefaultTableModel(new Object[] {"ID","Ator"},0) {
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};
		
		atorTable = new JTable(atorTableModel);
		scrollPane.setViewportView(atorTable);
		
		atorTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		atorTable.getTableHeader().setReorderingAllowed(false);

	}

	public JTextField getAtorField() {
		return atorField;
	}

	public void setAtorField(JTextField atorField) {
		this.atorField = atorField;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JTable getAtorTable() {
		return atorTable;
	}

	public void setAtorTable(JTable atorTable) {
		this.atorTable = atorTable;
	}

	public DefaultTableModel getAtorTableModel() {
		return atorTableModel;
	}

	public void setAtorTableModel(DefaultTableModel atorTableModel) {
		this.atorTableModel = atorTableModel;
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

	public JButton getNovoButton() {
		return novoButton;
	}

	public void setNovoButton(JButton novoButton) {
		this.novoButton = novoButton;
	}
	
	}

