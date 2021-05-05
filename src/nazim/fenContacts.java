package nazim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class fenContacts extends JFrame {

	private JPanel contentPane;
	private JTextField FRechercher;
	private JTable table;
	private JTable table_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenContacts frame = new fenContacts();
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
	public fenContacts() {
		int thisID =1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblContacts = new JLabel("Contacts");
		lblContacts.setBounds(356, 7, 58, 16);
		lblContacts.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblContacts);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(131, 50, 509, 174);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUser = new JLabel("Rechercher nouveau contact");
		lblUser.setBounds(32, 9, 195, 14);
		panel_1.add(lblUser);
		
		FRechercher = new JTextField();
		FRechercher.setBounds(237, 6, 122, 20);
		panel_1.add(FRechercher);
		FRechercher.setColumns(10);
		
		JButton BRechercher = new JButton("Rechercher");
		BRechercher.setBounds(397, 5, 87, 23);
		panel_1.add(BRechercher);
		
		JLabel LConf = new JLabel("");
		LConf.setHorizontalAlignment(SwingConstants.CENTER);
		LConf.setForeground(Color.RED);
		LConf.setBounds(272, 25, 226, 14);
		panel.add(LConf);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 34, 489, 129);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setVisible(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int ligne = table.getSelectedRow();//la ligne selectionnée
				//int colonne = table.getSelectedColumn();// la colonne selectionnée
				Object cellule = table.getValueAt(ligne,0);//Par défaut la colonne 5 du corps message
				
				Connection connection;
				
				Statement statement ;
			      try
			      {
					  // create a database connection
					  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/poo","root","");
					   statement = connection.createStatement();
					  statement.setQueryTimeout(30);  // set timeout to 30 sec.
		
					  String req="INSERT INTO contacts(id1,id2,nom_contact,prenom_contact) VALUES("+thisID+","+table.getValueAt(ligne, 1)+",'"+table.getValueAt(ligne, 2)+"','"+table.getValueAt(ligne, 3)+"')";
					  System.out.println(req);
					  int nbre=0;
					  nbre=statement.executeUpdate(req);
					  
					  if (nbre==1){
						  table.setVisible(false);
					  }
					  
					  LConf.setText("Contact insérer avec succès");
					  LConf.setForeground(Color.green);


					  
			      }
			catch(SQLException e1)
			{
			  // if the error message is "out of memory", 
			  // it probably means no database file is found
				LConf.setText("ECHEC INSERTION");
				System.out.println("ERREUR");
			 System.err.println(e1.getMessage());
			 
			}				

			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"id", "username", "Nom", "Pr\u00E9nom", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(34);
		
		JButton btnAfficherContacts = new JButton("Afficher mes contacts");
		btnAfficherContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_1.setVisible(true);
				Connection connection;
				
				Statement statement ;
			      try
			      {
					  // create a database connection
					  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/poo","root","");
					   statement = connection.createStatement();
					  statement.setQueryTimeout(30);  // set timeout to 30 sec.
		
					  String req="SELECT * FROM contacts WHERE id1="+thisID;
					  System.out.println(req);
					 
					  ResultSet rs = statement.executeQuery(req);
					  int i=0;
					  while (rs.next()) {
						  table_1.setValueAt(i+1, i, 0);
						  table_1.setValueAt(rs.getInt("id2"), i, 1);
						  table_1.setValueAt(rs.getString("nom_contact"), i, 2);
						  table_1.setValueAt(rs.getString("prenom_contact"), i, 3);
						  table_1.setValueAt(rs.getString("email"), i, 4);
						  //table.setValueAt(rs.getString("corps"), i, 5);
						  i++;
						}
					  
			      }
			catch(SQLException e1)
			{
			  // if the error message is "out of memory", 
			  // it probably means no database file is found
				LConf.setText("ECHEC INSERTION");
				System.out.println("ERREUR");
			 System.err.println(e1.getMessage());
			 
			}
				
			}
		});
		btnAfficherContacts.setBounds(295, 235, 181, 23);
		panel.add(btnAfficherContacts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 269, 509, 124);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "id", "username", "Nom", "Pr\u00E9nom"
			}
		));
		scrollPane.setViewportView(table_1);
		BRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setVisible(true);
				Connection connection;				
				Statement statement ;
			      try
			      {
			    	  
					  // create a database connection
					  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/poo","root","");
					   statement = connection.createStatement();
					  statement.setQueryTimeout(30);  // set timeout to 30 sec.
		
					  //String req="SELECT * FROM produits WHERE code_barre='"+code_barre.getText()+"' OR designation LIKE '%"+code_barre.getText()+"%'";
					  String req="SELECT * FROM user WHERE nom_user LIKE '%"+FRechercher.getText()+"%'";
					  System.out.println(req);
					 
					  ResultSet rs = statement.executeQuery(req);
					  int i=0;
					  while (rs.next()) {
						  table.setValueAt(i+1, i, 0);
						  table.setValueAt(rs.getInt("id"), i, 1);
						  table.setValueAt(rs.getString("username"), i, 2);
						  table.setValueAt(rs.getString("nom_user"), i, 3);
						  table.setValueAt(rs.getString("prenom_user"), i, 4);
						  //table.setValueAt(rs.getString("corps"), i, 5);
						  i++;
						}
			      }
			catch(SQLException e1)
			{
			  // if the error message is "out of memory", 
			  // it probably means no database file is found
				
			  System.err.println(e1.getMessage());
			}
			  connection =null;
			}
		});
	}
}
