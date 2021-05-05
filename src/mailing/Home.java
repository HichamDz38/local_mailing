package mailing;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.List;

import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.TextArea;

public class Home extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List list,olist; 
	protected JTable table;
	protected JScrollPane scrollPane,scrollPane2;
	protected java.awt.TextArea textarea;
	

	/**
	 * Create the panel.
	 */
	public void Table(){
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Adress", "Subject", "Time", "Date"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(187);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(173);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(118);
		}
	
	public Home() {
		setBackground(new Color(153, 51, 204));
		setBounds(0, 0, 900, 500);
		table = new JTable();
		table.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowHorizontalLines(false);
		Table();
		setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 41, 742, 195);
		add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		list = new List();
		list.setForeground(new Color(0, 0, 204));
		list.setBounds(10, 62, 114, 174);
		list.setFont(new Font("Roboto Medium", Font.BOLD, 16));
		add(list);
		
		olist = new List();
		olist.setForeground(new Color(0, 0, 204));
		olist.setBounds(10, 242, 114, 248);
		olist.setFont(new Font("Roboto Medium", Font.BOLD, 16));
		add(olist);
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(130, 242, 742, 248);
		add(scrollPane2);
		
		textarea = new TextArea();
		textarea.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		scrollPane2.setViewportView(textarea);
		list.add("IN_Box");
		list.add("Send");
		list.add("favor");
		list.add("New");
		list.add("profile");
		olist.add("Romove");
		olist.add("Romove_All");
		olist.add("Save_Favore");
	}
}