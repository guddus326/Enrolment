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
    	  Image img = toolkit.getImage("C:\\\\Users\\\\s2019\\\\OneDrive\\\\바탕 화면\\\\미림로고.png");
    	  Font fontbutton=new Font("12롯데마트드림Medium",Font.BOLD,15);
		  String title[]= {"수업코드","선생님","수업명"};
		  JFrame frame = new JFrame("수업 목록");  
		  DefaultTableModel model = new DefaultTableModel(title, 0); 
		  JTable table = new JTable(model);
		  String arr[]={"코드", "선생님","수업명"};
		  model.addRow(arr); //테이블에 행 추가
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
		   //리소스 반환
		   rs.close();
		} catch (Exception e1) {
		   e1.printStackTrace();
		  }
		  table.setFont(fontbutton);
		  //생성된 프레임창에 데이터가 삽입된 테이블을 출력
		  frame.add(table);
		  frame.setBounds(0,0,600,180); //(x좌표,y좌표, 창너비, 창높이)
		  frame.setVisible(true);
		  frame.setIconImage(img);
		  
	}
     public static void main(String[] ar){
    	 ShowListGUI j=new ShowListGUI();
     }

 }



