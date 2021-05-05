package mailing;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class login_panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField user;
	protected JPasswordField pass;
	protected JLabel status;
	private JLabel luser,lpass;
	protected JButton login;

	/**
	 * Create the panel.
	 */
	public login_panel() {
		setBackground(new Color(153, 0, 204));
		setForeground(UIManager.getColor("Table.selectionBackground"));
		setLayout(null);
		
		login = new JButton("Log In");
		login.setBackground(new Color(102, 0, 204));
		login.setBounds(203, 21, 89, 23);
		add(login);
		
		user = new JTextField();
		user.setBounds(20, 21, 86, 23);
		add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(113, 21, 86, 23);
		add(pass);
		pass.setColumns(10);
		
		status = new JLabel("");
		status.setForeground(new Color(204, 51, 51));
		status.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		status.setBounds(302, 25, 136, 14);
		add(status);
		
		luser = new JLabel("user");
		luser.setBounds(30, 48, 76, 14);
		add(luser);
		
		lpass = new JLabel("password");
		lpass.setBounds(123, 48, 76, 14);
		add(lpass);

	}
}
