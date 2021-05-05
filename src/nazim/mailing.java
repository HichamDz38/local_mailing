package nazim;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.sql.*;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class mailing extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8699257795447762404L;
	private JPanel contentPane;
	private JTextField user;
	private JTextField email;
	private JTextField e_user;
	private JTextField e_mail;
	private JPasswordField e_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mailing frame = new mailing();
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
	public mailing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		user = new JTextField();
		user.setBounds(114, 67, 103, 20);
		user.setColumns(10);
		panel.add(user);
		
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(114, 98, 103, 20);
		panel.add(email);
		
		JButton inscrire = new JButton("S'inscrire");
		inscrire.setForeground(new Color(255, 255, 255));
		inscrire.setBackground(new Color(102, 51, 153));
		inscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection;
				Statement statement;
				
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailing.db","root","");
					statement = connection.createStatement();
					//statement.executeUpdate("CREATE TABLE oui")
					statement.setQueryTimeout(10);
					statement.executeUpdate("INSERT INTO users(email,pass)"+"VALUES("+e_user.getText()+",'"+e_mail.getText()+"')");
					statement.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		inscrire.setBounds(339, 134, 110, 23);
		panel.add(inscrire);
		
		JLabel lblNewLabelser = new JLabel("email/user");
		lblNewLabelser.setBounds(23, 67, 106, 14);
		panel.add(lblNewLabelser);
		
		JLabel lblEmail = new JLabel("pass");
		lblEmail.setBounds(23, 98, 106, 14);
		panel.add(lblEmail);
		
		JButton enter = new JButton("entrer");
		enter.setForeground(new Color(255, 255, 255));
		enter.setBackground(new Color(0, 0, 139));
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		enter.setBounds(23, 134, 86, 23);
		panel.add(enter);
		
		e_user = new JTextField();
		e_user.setBounds(339, 42, 110, 20);
		e_user.setColumns(10);
		panel.add(e_user);
		
		e_mail = new JTextField();
		e_mail.setBounds(339, 73, 110, 20);
		e_mail.setColumns(10);
		panel.add(e_mail);
		
		e_pass = new JPasswordField();
		e_pass.setBounds(339, 104, 110, 20);
		e_pass.setColumns(10);
		panel.add(e_pass);
		
		
		
		JLabel lblE_user = new JLabel("user name");
		lblE_user.setBounds(265, 48, 64, 14);
		panel.add(lblE_user);
		
		JLabel lblNE_email = new JLabel("email");
		lblNE_email.setBounds(265, 79, 64, 14);
		panel.add(lblNE_email);
		
		JLabel lblE_pass= new JLabel("pass");
		lblE_pass.setBounds(265, 107, 64, 14);
		panel.add(lblE_pass);
		
		JButton btnPasswordOublier = new JButton("pass oublier");
		btnPasswordOublier.setForeground(new Color(255, 255, 255));
		btnPasswordOublier.setBackground(new Color(0, 0, 255));
		btnPasswordOublier.setBounds(114, 134, 103, 23);
		panel.add(btnPasswordOublier);
	}
}
