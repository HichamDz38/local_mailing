package nazim;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class message extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public message() {
		setBackground(new Color(0, 153, 255));
		setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(240, 248, 255));
		textArea.setBounds(91, 129, 564, 308);
		add(textArea);
		
		textField = new JTextField();
		textField.setBackground(new Color(240, 248, 255));
		textField.setBounds(91, 97, 249, 23);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBackground(new Color(0, 153, 255));
		btnSend.setBounds(555, 448, 89, 23);
		add(btnSend);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(240, 248, 255));
		textField_1.setBounds(91, 66, 249, 23);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnClear = new JButton("clear");
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.setBackground(new Color(0, 153, 255));
		btnClear.setBounds(101, 448, 89, 23);
		add(btnClear);
		
		JButton btnReturn = new JButton("return");
		btnReturn.setBackground(new Color(0, 153, 255));
		btnReturn.setBounds(200, 448, 89, 23);
		add(btnReturn);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(25, 106, 56, 14);
		add(lblSubject);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(25, 75, 56, 14);
		add(lblAddress);

	}
}
