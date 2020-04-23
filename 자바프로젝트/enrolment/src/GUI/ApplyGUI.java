package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import enrolment.Member;



public class ApplyGUI extends JFrame {
	public ApplyGUI(){
		JPanel p=new JPanel();
		Font fonttitle=new Font("12롯데마트드림Bold",Font.BOLD,20);
		Font fontbutton=new Font("12롯데마트드림Medium",Font.BOLD,15);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
    	Image img = toolkit.getImage("C:\\\\Users\\\\s2019\\\\OneDrive\\\\바탕 화면\\\\미림로고.png");
		JLabel title= new JLabel("수강신청은 3과목까지 가능합니다.");
		JLabel list_1=new JLabel("list_1");
		JLabel list_2=new JLabel("list_2");
		JLabel list_3=new JLabel("list_3");
		JButton save = new JButton("저장");
		JComboBox classlist_1=new JComboBox();
		JComboBox classlist_2=new JComboBox();
		JComboBox classlist_3=new JComboBox();
		title.setFont(fonttitle);
		add(title);
		list_1.setFont(fontbutton);
		add(list_1);
		list_2.setFont(fontbutton);
		add(list_2);
		list_3.setFont(fontbutton);
		add(list_3);
		save.setBackground(new Color(62,157,55));
		save.setForeground(Color.white);
		save.setBorderPainted(false);
		save.setFocusPainted(false);
		save.setFont(fontbutton);
		add(save);
		add(classlist_1);
		add(classlist_2);
		add(classlist_3);
		title.setBounds(45, 50, 300, 20);
		list_1.setBounds(90,100, 40,20);
		list_2.setBounds(90,140, 40,20);
		list_3.setBounds(90,180, 40,20);
		save.setBounds(150,240, 80, 30);
		classlist_1.setBounds(140,100,150,20);
		classlist_2.setBounds(140,140,150,20);
		classlist_3.setBounds(140,180,150,20);
		add(p);
		setIconImage(img);
		setSize(400, 400);
	    setTitle("수강신청");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    
	    try {
			   Class.forName("com.mysql.jdbc.Driver");
			   String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
			   Connection con = DriverManager.getConnection(url, "root", "1111");
			   String sql = "SELECT * FROM `1-2`.classlist";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					classlist_1.addItem(rs.getString(2));
					classlist_2.addItem(rs.getString(2));
					classlist_3.addItem(rs.getString(2));
				}
		   //리소스 반환
		   rs.close();
		} catch (Exception e1) {
		   e1.printStackTrace();
		  }
	    
	    
	     save.addActionListener(new ActionListener() {
	 		@Override
	 		public void actionPerformed(ActionEvent T) {
	 			try {
	 				Class.forName("com.mysql.jdbc.Driver");
	 				String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
	 				Connection con = DriverManager.getConnection(url, "root", "1111");
	 				
	 				
	 				String sql_L1 = "SELECT Count(*) FROM `1-2`.stuclasslist where StuNum = " + "\'"+ Member.getStuNum()
	 				+ "\' and list_1 <> " + "\'" + "\'";
	 				Statement stE1 = con.createStatement();
	 				ResultSet rsE1 = stE1.executeQuery(sql_L1);
	 				rsE1.last();
	 				int empty = rsE1.getInt(1);
	 				if(empty == 1) {//첫번째 수업이 비어있으면 empty=0
	 					JOptionPane.showMessageDialog(null, "수강목록이 꽉 찼습니다.");
	 				}else {
	 				String list_1 = "UPDATE `1-2`.stuclasslist SET list_1 =" + "\'" + classlist_1.getSelectedItem().toString()
	 						+ "\'" + " WHERE StuNum =" + "\'" + Member.getStuNum() + "\'";
	 					Statement stL_1 = con.createStatement();
	 					stL_1.executeUpdate(list_1);
	 					
	 				String list_2 = "UPDATE `1-2`.stuclasslist SET list_2 =" + "\'" + classlist_2.getSelectedItem().toString()
		 					+ "\'" + " WHERE StuNum =" + "\'" + Member.getStuNum() + "\'";
		 				Statement stL_2 = con.createStatement();
		 				stL_2.executeUpdate(list_2);
	 					
		 			String list_3 = "UPDATE `1-2`.stuclasslist SET list_3 =" + "\'" + classlist_3.getSelectedItem().toString()
		 					+ "\'" + " WHERE StuNum =" + "\'" + Member.getStuNum() + "\'";
		 				Statement stL_3 = con.createStatement();
							stL_3.executeUpdate(list_3);
						stE1.close();	
						JOptionPane.showMessageDialog(null, "수강신청이 완료되었습니다");	
	 				}
	 				EnrolmentGUI e=new EnrolmentGUI();
	 			}catch(Exception e) {
	 				System.out.println("Got an exception!");
	 				System.out.println(e.getMessage());
	 				JOptionPane.showMessageDialog(null, "수강신청을 할 수 없습니다. 관리자에게 문의하세요,");
	 			}	
	 		}
	 	});
	}
	public static void main(String[] args) {
		ApplyGUI a=new ApplyGUI();
	} 
}
