package mailing;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class New extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField subject,Address;
	private JLabel lblSubject,lblAddress;
	protected JButton bClear,bSend,bReturn;
	protected JTextArea message;
	protected JLabel action_stat,address_stat;

	/**
	 * Create the panel.
	 */
	public New() {
		//setBounds(100, 100, 900, 500);
		setBackground(new Color(153, 51, 204));
		setLayout(null);
		
		subject = new JTextField();
		subject.setBounds(101, 85, 249, 23);
		subject.setBackground(new Color(240, 248, 255));
		add(subject);
		subject.setColumns(10);
		
		bSend = new JButton("Send");
		bSend.setBounds(679, 447, 89, 23);
		bSend.setBackground(new Color(240, 248, 255));
		add(bSend);
		
		Address = new JTextField();
		Address.setBounds(101, 51, 249, 23);
		Address.setBackground(new Color(240, 248, 255));
		add(Address);
		Address.setColumns(10);
		
		bClear=new JButton("clear");
		bClear.setBounds(121, 447, 89, 23);
		bClear.setForeground(new Color(0, 0, 0));
		bClear.setBackground(new Color(240, 248, 255));
		add(bClear);
		
		bReturn = new JButton("return");
		bReturn.setBounds(221, 447, 89, 23);
		bReturn.setBackground(new Color(240, 248, 255));
		add(bReturn);
		
		lblSubject = new JLabel("Subject");
		lblSubject.setBounds(35, 89, 56, 14);
		add(lblSubject);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(35, 55, 56, 14);
		add(lblAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 134, 688, 295);
		add(scrollPane);
		
		message = new JTextArea();
		scrollPane.setViewportView(message);
		
		action_stat = new JLabel("");
		action_stat.setForeground(new Color(255, 0, 0));
		action_stat.setHorizontalAlignment(SwingConstants.LEFT);
		action_stat.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		action_stat.setBounds(355, 447, 274, 23);
		add(action_stat);
		
		address_stat = new JLabel("");
		address_stat.setForeground(new Color(255, 0, 0));
		address_stat.setFont(new Font("Roboto Medium", Font.BOLD, 14));
		address_stat.setBounds(360, 55, 162, 14);
		add(address_stat);

	}
}
