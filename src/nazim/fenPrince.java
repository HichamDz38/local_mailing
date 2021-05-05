package nazim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class fenPrince extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField user;
	private JTextField email;
	private JPasswordField pwd;
	private JPasswordField passw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenPrince frame = new fenPrince();
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
	public fenPrince() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnInscription = new JButton("Inscription");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuBar.add(btnInscription);
		
		JButton btnUser = new JButton("user");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(btnUser);
		
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuBar.add(btnAdmin);
		btnAdmin.setVisible(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 33);
		contentPane.add(panel);
		panel.setVisible(false);
		
		JLabel lblUser = new JLabel("Login");
		panel.add(lblUser);
		
		login = new JTextField();
		panel.add(login);
		login.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		panel.add(lblPassword);
		
		passw = new JPasswordField();
		passw.setColumns(10);
		panel.add(passw);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection;				
				Statement statement ;
			      connection = null;
			      try
			      {
			  // create a database connection
			  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/poo","root","");
			   statement = connection.createStatement();
			  statement.setQueryTimeout(30);  // set timeout to 30 sec.

			  String req="SELECT * FROM user WHERE username ='"+login.getText()+"' AND '"+passw.getText()+"'";
			  System.out.println(req);

			  ResultSet rs = statement.executeQuery(req);
			  
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
			  System.err.println(e1.getMessage());
			}
			}
		});
		panel.add(btnSignIn);
		
		JPanel panel_register = new JPanel();
		panel_register.setBounds(5, 44, 424, 185);
		contentPane.add(panel_register);
		panel_register.setLayout(null);
		
		user = new JTextField();
		user.setToolTipText("");
		user.setBounds(78, 8, 86, 20);
		panel_register.add(user);
		user.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 8, 65, 14);
		panel_register.add(lblUsername);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(204, 8, 74, 14);
		panel_register.add(lblPassword_1);
		
		JLabel lblCentresDintrts = new JLabel("Centres d'int\u00E9r\u00EAts :");
		lblCentresDintrts.setBounds(6, 77, 133, 14);
		panel_register.add(lblCentresDintrts);
		
		JCheckBox chckbxInfo = new JCheckBox("Informatique");
		chckbxInfo.setBounds(10, 98, 115, 23);
		panel_register.add(chckbxInfo);
		
		JCheckBox chckbxElec = new JCheckBox("Electronique");
		chckbxElec.setBounds(163, 98, 115, 23);
		panel_register.add(chckbxElec);
		
		JCheckBox chckbxsport = new JCheckBox("Sport");
		chckbxsport.setBounds(10, 137, 89, 23);
		panel_register.add(chckbxsport);
		
		JCheckBox chckbxRel = new JCheckBox("Religion");
		chckbxRel.setBounds(163, 137, 111, 23);
		panel_register.add(chckbxRel);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection;
				
				Statement statement ;
			      connection = null;
			      try
			      {
			  // create a database connection
			  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/poo","root","");
			   statement = connection.createStatement();
			  statement.setQueryTimeout(30);  // set timeout to 30 sec.

			  String req="insert into user(username,pwd,email,info,elec,sport,rel,cle,actif) "
					  + "values ('"+user.getText()+"', '"+pwd.getText()+"','"+email.getText()+"',"
			  		+ "'"+chckbxInfo.isSelected()+"','"+chckbxElec.isSelected()+"','"+chckbxsport.isSelected()+"','"+chckbxRel.isSelected()+"',"
			  		+ "'"+UUID.randomUUID().toString()+"',0);";
			  System.out.println(req);
			  statement.executeUpdate(req);
			  panel.setVisible(true);
			}
			catch(SQLException e)
			{
			  // if the error message is "out of memory", 
			  // it probably means no database file is found
				panel_register.setVisible(true);
				System.out.println("ECHEC");
			  System.err.println(e.getMessage());
			}
			      
			      
			      panel_register.setVisible(false);
			}
		});
		btnValider.setBounds(317, 151, 86, 23);
		panel_register.add(btnValider);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 39, 65, 14);
		panel_register.add(lblEmail);
		
		email = new JTextField();
		email.setBounds(78, 36, 86, 20);
		panel_register.add(email);
		email.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setColumns(10);
		pwd.setBounds(295, 8, 86, 20);
		panel_register.add(pwd);
		


	}
}
