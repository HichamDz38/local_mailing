package mailing;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class signin_panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField tname,tfname,tuser;
	protected JPasswordField pass;
	protected JLabel message,lname,lfname,luser,lpass;
	protected JButton sign;

	/**
	 * Create the panel.
	 */
	public signin_panel() {
		setBorder(new LineBorder(new Color(0, 153, 255), 1, true));
		setBackground(new Color(153, 0, 204));
		setLayout(null);
		
		tname = new JTextField();
		tname.setBounds(127, 23, 86, 20);
		add(tname);
		tname.setColumns(10);
		
		tfname = new JTextField();
		tfname.setBounds(127, 52, 86, 20);
		add(tfname);
		tfname.setColumns(10);
		
		tuser = new JTextField();
		tuser.setBounds(318, 23, 86, 20);
		add(tuser);
		tuser.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(318, 54, 86, 20);
		add(pass);
		
		lname = new JLabel("name");
		lname.setBounds(51, 23, 70, 22);
		add(lname);
		
		lfname = new JLabel("family name");
		lfname.setBounds(51, 50, 70, 22);
		add(lfname);
		
		luser = new JLabel("user");
		luser.setBounds(247, 21, 62, 22);
		add(luser);
		
		lpass = new JLabel("password");
		lpass.setBounds(247, 54, 62, 22);
		add(lpass);
		
		sign = new JButton("Sign In");
		sign.setBackground(new Color(102, 0, 204));
		sign.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Connection connection;
				
				Statement statement ;
			      connection = null;
			      try
			      {
			    	  // 	create a database connection
			    	  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mail","root","");
			    	  statement = connection.createStatement();
			    	  statement.setQueryTimeout(30);  // 	set timeout to 30 sec.

			    	  String req2="Select * from user where user='"+tuser.getText()+"';";
			    	  ResultSet re=statement.executeQuery(req2);
			    	  if (re.next()){ 
						  	message.setText("use deffrent user");}
			    	  else {
			    		  if ((tname.getText().length()==0) | (tfname.getText().length()==0) | (tuser.getText().length()==0) | (pass.getText().length()==0)){
			    			  message.setText("complete all field, pleas");
			    		  }
			    	  
			    		  else{
			    			  String req="insert into user(name,fname,user,pass) "+ "values ('"+tname.getText()+"', '"+tfname.getText()+"','"+tuser.getText()+"','"+pass.getText().hashCode()+"');";
			    			  System.out.println(req);
			    			  statement.executeUpdate(req);
			    			  tname.setText("");
			    			  tfname.setText("");
			    			  tuser.setText("");
			    			  pass.setText("");
			    			  message.setText("congratulation,Now log in");}}}
			      catch(SQLException e)
			      {
			    	  // 	if the error message is "out of memory", 
			    	  // 	it probably means no database file is found
			    	  System.out.println("ECHEC");
			    	  System.err.println(e.getMessage());
			      }
		}});
		sign.setBounds(318, 103, 86, 22);
		add(sign);
		
		message = new JLabel("");
		message.setForeground(new Color(255, 0, 0));
		message.setFont(new Font("Roboto Medium", Font.BOLD, 16));
		message.setBounds(46, 103, 263, 22);
		add(message);

	}
}
