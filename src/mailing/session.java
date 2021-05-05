package mailing;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class session extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel user;
	protected JButton logout;
	protected int id_user;

	/**
	 * Create the panel.
	 */
	public session(String usr,int id) {
		setBackground(new Color(102, 0, 153));
		setForeground(new Color(153, 51, 204));
		setLayout(null);
		
		logout = new JButton("LogOut");
		logout.setForeground(new Color(0, 0, 0));
		logout.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		logout.setBackground(new Color(102, 102, 204));
		logout.setBounds(203, 21, 89, 23);
		add(logout);
		
		user = new JLabel(usr);
		user.setIcon(new ImageIcon(session.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		user.setForeground(new Color(255, 204, 0));
		user.setFont(new Font("Roboto Medium", Font.BOLD, 16));
		user.setBackground(new Color(0, 102, 153));
		user.setBounds(76, 21, 122, 23);
		add(user);
		
		id_user=id;
	}
}
