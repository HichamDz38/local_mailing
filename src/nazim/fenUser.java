package nazim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class fenUser extends JFrame {

	private JPanel contentPane;
	private JTextField activation;
	private JLabel lblEchec;
	String cle,username,email,pwd,info,elec,sport,religion;
	
	Integer id_user=4,actif;
	
	private JPanel panel_center;
	private JTextField field_email;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenUser frame = new fenUser();
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
	public fenUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		activation = new JTextField();
		activation.setEditable(false);
		panel.add(activation);
		activation.setColumns(23);
		panel.setVisible(false);
		
		//Récupération de la clé et du username
		Connection connection;
		
		Statement statement ;
	      connection = null;
	      try
	      {
			  // create a database connection
			  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/poo","root","");
			   statement = connection.createStatement();
			  statement.setQueryTimeout(30);  // set timeout to 30 sec.
		
			  String req="SELECT * FROM user WHERE id=4";
			  System.out.println(req);
			  ResultSet rs = statement.executeQuery(req);
			  
			  while (rs.next()) {
				  actif = rs.getInt("actif");
				  username = rs.getString("username");
				  pwd = rs.getString("pwd");
				  email = rs.getString("email");
				  info = rs.getString("info");
				  elec = rs.getString("elec");
				  sport = rs.getString("sport");
				  religion = rs.getString("rel");
				  //System.out.println(info + "\n");
				  if (actif == 0){
					  cle = rs.getString("cle");					  
					  activation.setText(cle);
					  panel.setVisible(true);
					  //System.out.println(cle + "\n");					  
				  }

				}
			  
			}
			catch(SQLException e1)
			{
			  // if the error message is "out of memory", 
			  // it probably means no database file is found
			  System.err.println(e1.getMessage());
			}
		
		JButton btnValiderLinscription = new JButton("Valider l'inscription");
		btnValiderLinscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				
				Statement statement ;
			      try
			      {
					  // create a database connection
					  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/poo","root","");
					   statement = connection.createStatement();
					  statement.setQueryTimeout(30);  // set timeout to 30 sec.
		
					  String req="UPDATE user set actif=1 WHERE cle ='"+cle+"'";
					  //System.out.println(req);
					  int nbre = statement.executeUpdate(req);
					  if (nbre==1){
						  panel.setVisible(false);
						  panel_center.setVisible(true);
					  }
						  else
						  lblEchec.setVisible(true);
					  
			      }
			catch(SQLException e1)
			{
			  // if the error message is "out of memory", 
			  // it probably means no database file is found
				lblEchec.setVisible(true);
			  System.err.println(e1.getMessage());
			}
			  connection =null;
			}
		});
		
		panel.add(btnValiderLinscription);
		
		
		lblEchec = new JLabel("Echec");
		lblEchec.setForeground(Color.RED);
		lblEchec.setVisible(false);
		panel.add(lblEchec);
		
		panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(null);
		
		JPanel panel_info = new JPanel();
		panel_info.setBounds(218, 11, 506, 185);
		panel_center.add(panel_info);
		panel_info.setLayout(null);
		
		
		JLabel lblBienvenue = new JLabel("Bienvenue "+username);
		lblBienvenue.setBounds(137, 0, 232, 14);
		panel_info.add(lblBienvenue);
		lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenue.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label = new JLabel("Centres d'int\u00E9r\u00EAts :");
		label.setBounds(31, 82, 133, 14);
		panel_info.add(label);
		
		JCheckBox cbI = new JCheckBox("Informatique");
		cbI.setBounds(35, 103, 115, 23);
		panel_info.add(cbI);
		
		cbI.setSelected(Boolean.valueOf(info));
		
		JCheckBox cbE = new JCheckBox("Electronique");
		cbE.setBounds(188, 103, 115, 23);
		panel_info.add(cbE);
		cbE.setSelected(Boolean.valueOf(elec));
		
		JCheckBox cbS = new JCheckBox("Sport");
		cbS.setBounds(35, 142, 89, 23);
		panel_info.add(cbS);
		cbS.setSelected(Boolean.valueOf(sport));
		
		JCheckBox cbR = new JCheckBox("Religion");
		cbR.setBounds(188, 142, 111, 23);
		panel_info.add(cbR);
		cbR.setSelected(Boolean.valueOf(religion));
		
		JLabel label_1 = new JLabel("Email");
		label_1.setBounds(35, 44, 65, 14);
		panel_info.add(label_1);
		
		field_email = new JTextField();
		field_email.setBounds(103, 41, 151, 20);
		panel_info.add(field_email);
		field_email.setColumns(30);
		
		//REmplissage des champs
		field_email.setText(email);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(363, 142, 89, 23);
		panel_info.add(btnModifier);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(0, 25, 506, 160);
		panel_info.add(horizontalBox);
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		horizontalBox.setBackground(Color.WHITE);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection;				
				Statement statement ;
				
				try
			      {
					  // create a database connection
					  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo","root","");
					   statement = connection.createStatement();
					  statement.setQueryTimeout(30);  // set timeout to 30 sec.
		
					  String req="UPDATE user set email='"+field_email.getText()+"' , info='"+cbI.isSelected()+"' "
					  		+ " , elec='"+cbE.isSelected()+"' , sport='"+cbS.isSelected()+"' "
					  				+ " , rel='"+cbR.isSelected()+"' WHERE id=4";
					  System.out.println(req);
					  statement.executeUpdate(req);					  
			      }
				catch(SQLException e1)
					{
					  // if the error message is "out of memory", 
					  // it probably means no database file is found
						lblEchec.setVisible(true);
					  System.err.println(e1.getMessage());
					}			
				
			}
		});
		if (actif==1)
			panel_center.setVisible(true);
		else
			panel_center.setVisible(false);		
		
		JPanel panel_mes = new JPanel();
		panel_mes.setBorder(new TitledBorder(null, "Messages", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_mes.setBounds(37, 207, 895, 210);
		panel_mes.setVisible(false);
		panel_center.add(panel_mes);
		
		GridBagLayout gbl_panel_mes = new GridBagLayout();
		gbl_panel_mes.columnWidths = new int[]{542, 84, 262, 0};
		gbl_panel_mes.rowHeights = new int[]{23, 165, 0};
		gbl_panel_mes.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_mes.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		
		panel_mes.setLayout(gbl_panel_mes);
		JTextArea corps = new JTextArea();
		GridBagConstraints gbc_corps = new GridBagConstraints();
		gbc_corps.fill = GridBagConstraints.BOTH;
		gbc_corps.gridx = 2;
		gbc_corps.gridy = 1;
		panel_mes.add(corps, gbc_corps);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = table.getSelectedRow();//la ligne selectionnée
				//int colonne = table.getSelectedColumn();// la colonne selectionnée
				Object cellule = table.getValueAt(ligne,5);//Par défaut la colonne 5 du corps message
				corps.setVisible(true);				
				corps.setText(cellule.toString()) ;
				
			}
		});
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		panel_mes.add(table, gbc_table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[]  {
				"Number", "From", "Date", "Objet", "Lecture", "corps"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);

		
		JPanel panel_new = new JPanel();
		panel_new.setBorder(new TitledBorder(null, "Nouveau message", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_new.setBounds(54, 413, 720, 111);
		panel_center.add(panel_new);
		panel_new.setLayout(null);
		panel_new.setVisible(false);
		
		JTextArea txtrIyuiyutiyityityityityi = new JTextArea();
		txtrIyuiyutiyityityityityi.setBounds(191, 49, 519, 75);
		panel_new.add(txtrIyuiyutiyityityityityi);
		
		JButton btnAjouterDestinataire = new JButton("Ajouter destinataire");
		btnAjouterDestinataire.setBounds(10, 21, 129, 23);
		panel_new.add(btnAjouterDestinataire);
		
		JButton btnNew = new JButton("Nouveau message");
		btnNew.setBounds(751, 118, 128, 23);
		panel_center.add(btnNew);
		
		JButton btnLire = new JButton("Lire messages");
		btnLire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//recuperation des messages
				Connection connection;
				Statement statement;
				try
			      {
					  // create a database connection
					  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/poo","root","");
					   statement = connection.createStatement();
					  statement.setQueryTimeout(30);  // set timeout to 30 sec.
					  //les messages de id
					  String req="SELECT * FROM messages,user WHERE (id_to="+id_user+" AND id_from=user.id)";
					  System.out.println(req);
				
					  ResultSet rs = statement.executeQuery(req);
					  int i=0;
					  while (rs.next()) {
						  table.setValueAt(i+1, i, 0);
						  table.setValueAt(rs.getString("user.username"), i, 1);
						  table.setValueAt(rs.getString("date_sent"), i, 2);
						  table.setValueAt(rs.getString("object"), i, 3);
						  table.setValueAt(rs.getInt("read"), i, 4);
						  table.setValueAt(rs.getString("corps"), i, 5);
						  i++;
						}
				  
					}
					catch(SQLException e1)
					{
					  // if the error message is "out of memory", 
					  // it probably means no database file is found
					  System.err.println(e1.getMessage());
					}
				//rendre visible le panel_mes
				panel_mes.setVisible(true);
				
			}
		});
		btnLire.setBounds(751, 79, 128, 23);
		panel_center.add(btnLire);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Recuperation des destinataires disponible
				
				//invisible panel_mes
				panel_mes.setVisible(false);
				//changer position du panel_new
				panel_new.setBounds(40, 207, 888, 210);
				panel_new.setVisible(true);
				
			}
		});
		corps.setVisible(false);
		/*
		try
	      {
			  // create a database connection
			  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo","root","");
			   statement = connection.createStatement();
			  statement.setQueryTimeout(30);  // set timeout to 30 sec.

			  String req="SELECT * FROM messages WHERE id_to=4";
			  System.out.println(req);
			  ResultSet rs = statement.executeQuery(req);
			  int mes=1;
			  while (rs.next()) {
				  String username = rs.getString("username");
				  System.out.println(username + "\n");
				  panel.setVisible(false);
				}				  
	      }
		catch(SQLException e1)
			{
			  // if the error message is "out of memory", 
			  // it probably means no database file is found
				lblEchec.setVisible(true);
			  System.err.println(e1.getMessage());
			}
		
*/
		//cdS.

				
	}
}
