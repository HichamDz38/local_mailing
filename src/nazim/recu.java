package nazim;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Label;

public class recu extends JPanel {

	/**
	 * Create the panel.
	 */
	public recu() {
		setBackground(new Color(0, 153, 255));
		setLayout(null);
		
		JButton mSend = new JButton("Rsend");
		mSend.setBackground(new Color(0, 153, 255));
		mSend.setBounds(555, 448, 89, 23);
		add(mSend);
		
		JButton mClear = new JButton("remove");
		mClear.setForeground(new Color(0, 0, 0));
		mClear.setBackground(new Color(0, 153, 255));
		mClear.setBounds(101, 448, 89, 23);
		add(mClear);
		
		JButton mReturn = new JButton("return");
		mReturn.setBackground(new Color(0, 153, 255));
		mReturn.setBounds(200, 448, 89, 23);
		add(mReturn);
		
		JLabel lSubject = new JLabel("Subject");
		lSubject.setBounds(25, 106, 56, 14);
		add(lSubject);
		
		JLabel lAddress = new JLabel("Address");
		lAddress.setBounds(25, 75, 56, 14);
		add(lAddress);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(91, 129, 564, 308);
		add(textPane);
		
		Label laddr = new Label("");
		laddr.setBackground(new Color(240, 248, 255));
		laddr.setBounds(91, 69, 249, 22);
		add(laddr);
		
		Label lsubject = new Label("");
		lsubject.setBackground(new Color(240, 248, 255));
		lsubject.setBounds(91, 98, 249, 22);
		add(lsubject);

	}
}
