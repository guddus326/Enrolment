package GUI;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import enrolment.ClassAdd;
import enrolment.Member;

public class ShowmyGUI {
	public ShowmyGUI() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
    	Image img = toolkit.getImage("C:\\\\Users\\\\s2019\\\\OneDrive\\\\���� ȭ��\\\\�̸��ΰ�.png");
    	Font fontbutton=new Font("12�Ե���Ʈ�帲Medium",Font.BOLD,15);
		String title[]= {"�й�","����1","����2","����3"};
		JFrame frame=new JFrame("�� �������");
		DefaultTableModel model = new DefaultTableModel(title, 0); 
		JTable table = new JTable(model);
		String arr[]= {"�й�","����1","����2","����3"};
		model.addRow(arr);
		String str=null;
		int a,i;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
			Connection con = DriverManager.getConnection(url, "root", "1111");

			//�й��� ���� ���ο� �ִ� ���� ���
			String sql = "SELECT * FROM `1-2`.stuclasslist WHERE StuNum =" + "\'" + Member.getStuNum() + "\'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String StuNum=rs.getString("StuNum");
				String list_1=rs.getString("list_1");
				String list_2=rs.getString("list_2");
				String list_3=rs.getString("list_3");
				
				model.addRow(new String[] {(String) StuNum,list_1,list_2,list_3});
				}
			rs.close();
		} catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}
		
		  table.setFont(fontbutton);
		  frame.add(table);
		  frame.setBounds(0,0,600,100); //(x��ǥ,y��ǥ, â�ʺ�, â����)
		  frame.setVisible(true);
		  frame.setIconImage(img);
	}
	public static void main(String args[]) {
		ShowmyGUI smg=new ShowmyGUI();
	}
}
