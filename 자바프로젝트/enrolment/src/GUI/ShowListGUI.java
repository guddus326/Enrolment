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

public class ShowListGUI{
	public ShowListGUI() {
		  Toolkit toolkit = Toolkit.getDefaultToolkit();
    	  Image img = toolkit.getImage("C:\\\\Users\\\\s2019\\\\OneDrive\\\\���� ȭ��\\\\�̸��ΰ�.png");
    	  Font fontbutton=new Font("12�Ե���Ʈ�帲Medium",Font.BOLD,15);
		  String title[]= {"�����ڵ�","������","������"};
		  JFrame frame = new JFrame("���� ���");  
		  DefaultTableModel model = new DefaultTableModel(title, 0); 
		  JTable table = new JTable(model);
		  String arr[]={"�ڵ�", "������","������"};
		  model.addRow(arr); //���̺� �� �߰�
		  String str=null;
		  int a,i;
		  try {
			   Class.forName("com.mysql.jdbc.Driver");
			   String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
			   Connection con = DriverManager.getConnection(url, "root", "1111");
			   String sql = "SELECT ClassCode, ClassName, Teacher FROM `1-2`.classlist";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					String ClassCode = rs.getString("ClassCode");
					String ClassName = rs.getString("ClassName");
					String Teacher = rs.getString("Teacher");
					
					model.addRow(new String[] {(String) ClassCode,ClassName,Teacher});
				}
		   //���ҽ� ��ȯ
		   rs.close();
		} catch (Exception e1) {
		   e1.printStackTrace();
		  }
		  table.setFont(fontbutton);
		  //������ ������â�� �����Ͱ� ���Ե� ���̺��� ���
		  frame.add(table);
		  frame.setBounds(0,0,600,180); //(x��ǥ,y��ǥ, â�ʺ�, â����)
		  frame.setVisible(true);
		  frame.setIconImage(img);
		  
	}
     public static void main(String[] ar){
    	 ShowListGUI j=new ShowListGUI();
     }

 }



