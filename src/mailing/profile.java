package mailing;

import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public class profile extends JPanel {
	protected JButton delete,reteur;
	protected JLabel lblNewLabel;
	protected signin_panel s1;

	/**
	 * Create the panel.
	 */
	public profile() {
		setBackground(new Color(102, 51, 102));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 54);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Are you sur for that!!!");
		lblNewLabel.setBounds(22, 11, 221, 34);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Roboto Condensed Light", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(new Color(255, 0, 51));
		
		delete = new JButton("Delete Acount");
		delete.setBounds(266, 10, 157, 35);
		panel.add(delete);
		delete.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 14));
		delete.setForeground(new Color(204, 0, 51));
		delete.setBackground(UIManager.getColor("Button.background"));
		
		

	}
}
