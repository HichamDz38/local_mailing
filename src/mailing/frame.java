package mailing;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public Home h1;
	public session s1;
	public login_panel lp1;
	public signin_panel sp1;
	public New n1;
	public String [] R,C;
	public int r=-1,index=-1;
	public ResultSet Rgt;
	
	public void reload(){
		this.invalidate();
		this.validate();
	}
	
	public void ToHome(String x,int id){
		h1= new Home();
		h1.setBounds(0,50,900,600);
		
		s1= new session(x,id);
		s1.setBounds(0, 0, 900, 50);
		
		contentPane=new JPanel();
		contentPane.setLayout(null);
		contentPane.add(s1);
		contentPane.add(h1);
		contentPane.setBackground(new Color(102, 0, 153));
		setBounds(100, 100, 900, 620);
		setContentPane(contentPane);
		reload();
		
		h1.olist.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int z=h1.olist.getSelectedIndex();
				h1.textarea.setText("");
				System.out.print(z);
				Connection connection;				
				Statement statement ;
			      connection = null;
			      try
			      {
			    	  // create a database connection
			    	  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mail","root","");
			    	  statement = connection.createStatement();
			    	  statement.setQueryTimeout(30);  // set timeout to 30 sec.
			    	  String req="";
			    	  if (z==1){
			    	  if (index==1)	req="update message SET delet1=1 where id_from='"+id+"' ";
			    	  if (index==0)	req="update message SET delet2=1 where id_to='"+id+"' ";
			    	  if (index==2)	req="update message SET favor1=0 where id_from='"+id+"' ";}
			    	  
			    	  if((r>=0) & (index>=0)){
			    	  if ((z==0) & (index==1)) 	req="update message SET delet1=1 where id='"+C[r]+"' and id_from='"+id+"' ";
			    	  if ((z==0) & (index==0))	req="update message SET delet2=1 where id='"+C[r]+"' and id_to='"+id+"' ";
			    	  if ((z==0) & (index==2))	req="update message SET favor1=0 where id='"+C[r]+"' and id_from='"+id+"' ";
			    	  if ((z==2) & (index==1))	req="update message SET favor1=1 where id='"+C[r]+"' and id_from='"+id+"' ";
			    	  if ((z==2) & (index==0))	req="update message SET favor2=1 where id='"+C[r]+"' and id_to='"+id+"' ";}
			    	  
			    	  if (req.length()>0)statement.executeUpdate(req);
			    	  
			    	  if ((z==0) & (index==2))	req="update message SET favor2=0 where id='"+C[r]+"' and id_to='"+id+"' ";
			    	  if ((z==1) & (index==2))	req="update message SET favor2=0 where id_to='"+id+"' ";
			    	  if (req.length()>0)statement.executeUpdate(req);
			    	  System.out.println(req);
			    	  gentable(x,index,id);
			      }
			      catch(SQLException e1)
			      {
			    	  // 	if the error message is "out of memory", 
			    	  // 	it probably means no database file is found
			    	  System.err.println(e1.getMessage());
			      }
			      
				
			}
				
		});
		
		h1.list.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				index=h1.list.getSelectedIndex();
				h1.textarea.setText("");
				if (index==3) ToNew(x,id);
				else{
					if(index==4) ToProfile(x,id);
					else gentable(x,index,id);}
				}
				
				
		});
		s1.logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gframe();
				
				
			}
		});
	
	
	
	}
	public void ToNew(String x,int id){
		n1=new New();
		n1.setLayout(null);
		n1.setVisible(true);
		h1.setVisible(false);
		n1.bSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Connection connection;				
				Statement statement ;
			      connection = null;
			      try
			      {
			    	  // create a database connection
			    	  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mail","root","");
			    	  statement = connection.createStatement();
			    	  statement.setQueryTimeout(30);  // set timeout to 30 sec.
			    	  String req="select id from user where user='"+n1.Address.getText()+"';";
			    	  System.out.println(req);
			    	  ResultSet rs = statement.executeQuery(req);
			    	  int id2=1;
			    	  if (rs.next()){
			    		  id2=rs.getInt("id");
			    		  n1.address_stat.setText("");
			    		  java. util. Date javaDate = new java. util. Date();
			    		  long javaTime = javaDate. getTime();
			    		  java. sql. Date sqlDate = new java. sql. Date(javaTime);
			    		  java. sql. Time sqlTime = new java. sql. Time(javaTime);
			    		  String M=n1.message.getText();
			    		  if (M.length()==0){
			    			  n1.action_stat.setText("write a message first");
			    			  n1.address_stat.setText("");
			    		  }
			    		  else{
			    			  String req2="insert into message(Date,Time,id_to,id_from,Subject,Corp)"+ "values ('"+sqlDate+"','"+sqlTime+"','"+id2+"', '"+id+"','"+n1.subject.getText()+"','"+M+"')";
			    			  System.out.print(req2);
			    			  statement.executeUpdate(req2);
			    			  n1.Address.setText("");
			    			  n1.message.setText("");
			    			  n1.subject.setText("");
			    			  n1.action_stat.setText("Message succefull Send");
			    			  n1.address_stat.setText("");}
			    		  }
			    	  else{ n1.address_stat.setText("check address");
			    	  		n1.action_stat.setText("");
			    	  }
			      }
			  
			      catch(SQLException e1)
			      {
			    	  // 	if the error message is "out of memory", 
			    	  // 	it probably means no database file is found
			    	  System.err.println(e1.getMessage());
			      }
			}
				
				
		});
		n1.bClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				n1.Address.setText("");
				n1.message.setText("");
				n1.subject.setText("");
				n1.action_stat.setText("");
  			  	n1.address_stat.setText("");
				
			}
		});
		n1.bReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					String M=n1.message.getText();
	    		  if (M.length()>0){n1.action_stat.setText("Send the Message or clear it!!");
    			  		n1.address_stat.setText("");}
	    		  else{
	    			  ToHome(x, id);}
				
			}
		});
		contentPane=new JPanel();
		contentPane.removeAll();
		contentPane.remove(h1);
		contentPane.remove(s1);
		contentPane.setLayout(null);
		n1.setBounds(0,50,900,600);
		s1= new session(x,id);
  		s1.logout.addActionListener(new ActionListener() {
  			
  			@Override
  			public void actionPerformed(ActionEvent arg0) {
  				gframe();
  				
  				
  			}
  		});
		s1.setBounds(0, 0, 900, 50);
		contentPane.add(n1);
		contentPane.add(s1);
		contentPane.setBackground(new Color(102, 0, 153));
		setContentPane(contentPane);
		reload();
			}
	public void gentable(String x,int y,int id){
		  Connection connection;				
		  Statement statement ;
	      connection = null;
	      try
	      {	
	    	  // create a database connection
	    	  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mail","root","");
	    	  statement = connection.createStatement();
	    	  statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    	  
	    	  String req="0";
	    	  if (y==0) {req="Select * From message,user where id_to='"+id+"' and user.id=id_from and delet2='"+0+"'";}
	    	  if (y==1) {req="Select * From message,user where id_from='"+id+"' and user.id=id_to and delet1='"+0+"'";}
	    	  if (y==2) {req="Select * From message,user where (id_from='"+id+"' and favor1='"+1+"' and user.id=id_to) or (id_to='"+id+"' and favor2='"+1+"' and user.id=id_from)";}
	    	  	  System.out.println(req);
	    		  Rgt = statement.executeQuery(req);
	    		  int i=0;
	    		  h1.Table();
	    		  R= new String[100];
	    		  C= new String[100];
	    		  while (Rgt.next() & (i<100)) {
	    			  h1.table.setValueAt(Rgt.getString("user.user").toString(), i, 0);
	    			  h1.table.setValueAt(Rgt.getString("Subject").toString(), i, 1);
	    			  h1.table.setValueAt(Rgt.getString("Time").toString(), i, 2);
	    			  h1.table.setValueAt(Rgt.getString("Date").toString(), i, 3);
	    			  R[i]=Rgt.getString("Corp").toString();
	    			  C[i]=Rgt.getString("id").toString();
	    			  i++;
	    		  }
	    		 if (i>0){
	    			 h1.table.addMouseListener(new MouseListener() {
	    					
	    					@Override
	    					public void mouseReleased(MouseEvent arg0) {
	    						// TODO Auto-generated method stub
	    						
	    					}
	    					
	    					@Override
	    					public void mousePressed(MouseEvent arg0) {
	    						// TODO Auto-generated method stub
	    						
	    					}
	    					
	    					@Override
	    					public void mouseExited(MouseEvent arg0) {
	    						// TODO Auto-generated method stub
	    						
	    					}
	    					
	    					@Override
	    					public void mouseEntered(MouseEvent arg0) {
	    						// TODO Auto-generated method stub
	    						
	    					}
	    					
	    					@Override
	    					public void mouseClicked(MouseEvent arg0) {
	    						r=h1.table.getSelectedRow();
	    						h1.textarea.setText(R[r]);
	    					}});
	  		contentPane.remove(s1);
	  		contentPane.remove(h1);
	  		s1.setBounds(0, 0, 900, 50);
	  		h1.setBounds(0,50,900,600);
	  		contentPane.add(s1);
	  		contentPane.add(h1);
	  		contentPane.setBackground(new Color(102, 0, 153));
	  		setContentPane(contentPane);
	  		reload();
	    }}
	      catch(SQLException e1)
	      {
	    	  // if the error message is "out of memory", 
	    	  // it probably means no database file is found
	    	  System.err.println(e1.getMessage());
	      }
	}
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
					frame.setVisible(true);
					} 
				catch (Exception e) {
					e.printStackTrace();
					}
			}
		});
		
			
	}			
	public void gframe(){
		lp1= new login_panel();
		lp1.status.setBounds(302, 25, 122, 14);
		lp1.login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Connection connection;				
				Statement statement ;
			      connection = null;
			      try
			      {
			    	  // create a database connection
			    	  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mail","root","");
			    	  statement = connection.createStatement();
			    	  statement.setQueryTimeout(30);  // set timeout to 30 sec.
			    	  @SuppressWarnings("deprecation")
			    	  String req="Select id From user where user='"+lp1.user.getText()+"' AND pass='"+lp1.pass.getText().hashCode()+"'";
			    	  System.out.println(req);
			    	  ResultSet rs = statement.executeQuery(req);
			    	  if (rs.next()){ 
			    		  int id=rs.getInt("id");
			    		  System.out.println(id);
			    		  ToHome(lp1.user.getText(),id);}
			    	  else{
			    		  lp1.status.setText("erreur user or pass");}
			  
			      }
			      catch(SQLException e1)
			      {
			    	  // 	if the error message is "out of memory", 
			    	  // 	it probably means no database file is found
			    	  lp1.status.setText("pas de connexion");
			    	  System.err.println(e1.getMessage());
			      }
			}
				
				
		});
		setBounds(100, 100, 450, 300);
		lp1.setBounds(0,0, 434, 65);
		sp1= new signin_panel();
		sp1.setBounds(0, 105, 434, 146);
		
		
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(lp1);
		contentPane.add(sp1);
		contentPane.setBackground(new Color(102, 0, 153));
		setContentPane(contentPane);
		reload();
	}
	
	public void ToProfile(String x,int id){
		setBounds(100, 100, 450, 300);
		profile p=new profile();
		p.setBounds(0, 0, 450, 65);
		signin_panel sp=new signin_panel();
		
		
		Connection connection;				
		Statement statement ;
	      connection = null;
	      try
	      {
	    	  // create a database connection
	    	  connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mail","root","");
	    	  statement = connection.createStatement();
	    	  statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    	  String req="Select * From user where id='"+id+"'";
	    	  System.out.println(req);
	    	  ResultSet rs = statement.executeQuery(req);
	    	  if (rs.next()){
	    		  sp.tfname.setText(rs.getString("fname"));
	    		  sp.tname.setText(rs.getString("name").toString());
	    		  sp.tuser.setText(rs.getString("user").toString());
	    	  }
	    	  
	  
	      }
	      catch(SQLException e1)
	      {
	    	  // 	if the error message is "out of memory", 
	    	  // 	it probably means no database file is found
	    	  System.err.println(e1.getMessage());
	      }
		
		
		
		sp.remove(sp.sign);
		JButton sign=new JButton("Save");
		JButton retur=new JButton("Return");
		retur.setBounds(200, 103, 86, 22);
		sign.setBounds(318, 103, 86, 22);
		sp.add(sign);
		sp.add(retur);
		retur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ToHome(x, id);
				
			}
		});
		
		p.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Connection connection;				
				Statement statement ;
				connection = null;
				try
				{	
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mail","root","");
					statement = connection.createStatement();
					statement.setQueryTimeout(30);  // set timeout to 30 sec.
					String seq="delete from user where id='"+id+"'";
					System.out.println(seq);
					statement.executeUpdate(seq);
					gframe();
					lp1.status.setText("the profile deleted");
				}
				catch(SQLException e1)
			    {
			    	  // 	if the error message is "out of memory", 
			    	  // 	it probably means no database file is found
			    	  System.err.println(e1.getMessage());
			    }
			}
		});
		sign.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					Connection connection;				
					Statement statement ;
					connection = null;
					try
					{	
						connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mail","root","");
						statement = connection.createStatement();
						statement.setQueryTimeout(30);  // set timeout to 30 sec.
						
						String req2="Select * from user where id!='"+id+"' and user='"+sp.tuser.getText()+"';";
						System.out.print(req2);
				    	  ResultSet re=statement.executeQuery(req2);
				    	  if (re.next()){ 
							  	sp.message.setText("use deffrent user!");}
				    	  else {
				    		  if ((sp.tname.getText().length()==0) | (sp.tfname.getText().length()==0) | (sp.tuser.getText().length()==0) | (sp.pass.getText().length()==0)){
				    			  sp.message.setText("complete all field, pleas");
				    		  }
				    	  
				    		  else{
						
				    			  String req="update user set name='"+sp.tname.getText()+"' ,fname='"+sp.tfname.getText()+"',user='"+sp.tuser.getText()+"' ,pass='"+sp.pass.getText().hashCode()+"' where id='"+id+"'";
				    			  System.out.println(req);
				    			  statement.execute(req);
				    			  sp.message.setText("change effected");
				    		  }}}
					catch(SQLException e1)
				    {
				    	  // 	if the error message is "out of memory", 
				    	  // 	it probably means no database file is found
				    	  System.err.println(e1.getMessage());
				    }
					
			}
		});
		sp.setBounds(0,80,450,220);
		contentPane= new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(p);
		contentPane.add(sp);
		contentPane.setBackground(new Color(102, 0, 153));
		setContentPane(contentPane);
		reload();
	}
	
	
	public frame() {
		setBackground(new Color(102, 0, 204));
		getContentPane().setBackground(new Color(0, 153, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gframe();
		
		}
}
