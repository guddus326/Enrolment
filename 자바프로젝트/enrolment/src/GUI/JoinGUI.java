package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;
public class JoinGUI extends JFrame {//회원가입화면
	public JoinGUI(){
			
		  	JPanel p = new JPanel();
			Font fontbutton=new Font("12롯데마트드림Medium",Font.BOLD,14);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
	    	Image img = toolkit.getImage("C:\\\\Users\\\\s2019\\\\OneDrive\\\\바탕 화면\\\\미림로고.png");
		  	JLabel stunum= new JLabel("학번");
		  	JLabel name= new JLabel("이름");	
		  	JLabel department= new JLabel("학과");	
		  	String Department[]= {"뉴미디어소프트웨어과","뉴미디어웹솔루션과","뉴미디어디자인과"};
	        JComboBox departmentcmb = new JComboBox(Department);
	        JLabel ID= new JLabel("아이디");
	        JLabel PW = new JLabel("비밀번호");
	       
	        stunum.setFont(fontbutton);
	        add(stunum);
	        name.setFont(fontbutton);
	        add(name);
	        department.setFont(fontbutton);
	        add(department);
	        ID.setFont(fontbutton);
	        add(ID);
	        PW.setFont(fontbutton);
	        add(PW);
	      
	        TextField stunumtf = new TextField();
	        TextField nametf = new TextField();
	        TextField IDtf = new TextField();
	        JPasswordField PWtf=new JPasswordField();
	    
	        add(stunumtf);
	        add(departmentcmb);
	        add(nametf);
	        add(IDtf);
	        add(PWtf);
	      
	        JButton save = new JButton("저장");
	        JButton cancle = new JButton("취소");
	        JButton IDC = new JButton("ID 중복");
	        save.setBackground(new Color(62,157,55));
	        save.setForeground(Color.white);
	        save.setBorderPainted(false);
	        save.setFocusPainted(false);
	        save.setFont(fontbutton);
	        add(save);
	        cancle.setBackground(new Color(62,157,55));
	        cancle.setForeground(Color.white);
	        cancle.setBorderPainted(false);
	        cancle.setFocusPainted(false);
	        cancle.setFont(fontbutton);
	        add(cancle);
	        IDC.setBackground(new Color(62,157,55));
	        IDC.setForeground(Color.white);
	        IDC.setBorderPainted(false);
	        IDC.setFocusPainted(false);
	        IDC.setFont(fontbutton);
	        add(IDC);
	        name.setBounds(40, 10, 40, 40);
	        stunum.setBounds(40, 50, 40, 40);
	        department.setBounds(40,90,60,40);
	        ID.setBounds(40, 130, 50, 40);
	        PW.setBounds(40, 170, 80, 40);
	
	        nametf.setBounds(130, 10, 200, 30);
	        stunumtf.setBounds(130, 50, 200, 30);
	        departmentcmb.setBounds(130,90,200,30);
	        IDtf.setBounds(130, 130, 200, 30);
	        PWtf.setBounds(130, 170, 200, 30);
	        
	        save.setBounds(125, 260, 80, 30);
	        cancle.setBounds(240, 260, 80, 30); 
	        IDC.setBounds(350, 130, 100, 30); 
		    add(p);
		    setIconImage(img);
			setSize(500,350);
			setTitle("회원가입");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
       
       IDC.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
				Connection con = DriverManager.getConnection(url, "root", "1111");
				
					String sql = "SELECT Count(*) FROM `1-2`.member where UserID = " + "\'"
					+IDtf.getText()+"\'"; //데이터 테이블에서 입력한 아이디가 하나라도 있으면 
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);//rs에 count 1
					rs.last();
					int rowcnt = rs.getInt(1);
					
					if(rowcnt == 0){//값이 없으면
						JOptionPane.showMessageDialog(null, "사용이 가능한 아이디 입니다.");
						st.close();//mysql문을 닫는다
						
					}else{//rs에 값이 하나라도 있으면
						JOptionPane.showMessageDialog(null, "사용이 불가능한 아이디 입니다.");
						IDtf.setText("");
					}
			}//end of try
			catch (Exception ex){
				JOptionPane.showMessageDialog(null, "회원가입이 불가능 합니다. 관리자에게 문의주십시오");
			}//end of catch
		}
       });
		
       save.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent T) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
				Connection con = DriverManager.getConnection(url, "root", "1111");
				
				String sql = "Insert into `1-2`.member (StuNum,UserName, UserID, UserPW, Department) values ("
						+ "\'" +  stunumtf.getText()+ "\'," + "\'" + nametf.getText()  + "\'," +"\'"+ IDtf.getText() +"\',"
						+"\'"+ PWtf.getText() +"\'," + "\'"+ departmentcmb.getSelectedItem().toString() +"\')";  
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				System.out.println("====================");
				dispose();
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다");
				LoginGUI lv=new LoginGUI();
			}catch(Exception e) {
				System.out.println("회원가입에 실패하였습니다. 관리자에게 문의바랍니다.");
				System.out.println(e.getMessage());
			}
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
				Connection con = DriverManager.getConnection(url, "root", "1111");
				
				String sql = "Insert into `1-2`.stuclasslist (StuNum) values (" + "\'" + stunumtf.getText()+ "\')";  
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				System.out.println("회원가입에 성공했습니다!");
				System.out.println("====================");
			}catch(Exception e) {
				System.out.println("회원가입에 실패하였습니다. 관리자에게 문의바랍니다.");
				System.out.println(e.getMessage());
			}
			/*try {
				
				
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
				Connection con = DriverManager.getConnection(url, "root", "1111");
				System.out.println("1");
						
				String sql1 = "Insert into `1-2`.member (StuNum,UserName, UserID, UserPW, Department) values ("
								+ "\'" + stunumtf.getText() + "\'," + "\'" + nametf.getText() + "\'," +"\'"+ IDtf.getText() +"\',"
								+"\'"+ PWtf.getText() +"\'," + "\'"+ departmentcmb.getSelectedItem().toString() +"\')";  
				System.out.println("11");
				Statement st1 = con.createStatement();
				System.out.println("22");
				st1.executeUpdate(sql1);
				System.out.println("2");
				String sql11 = "Insert into `1-2`.stuclasslist (StuNum) values (" + "\'" + stunumtf.getText() + "\')";  
				Statement st11 = con.createStatement();
				st11.executeUpdate(sql11);
				System.out.println("3");
				dispose();
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다");
				LoginGUI lv=new LoginGUI();
						
				System.out.println("4");		
					
	 
			}//end of try
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
			}//end of catch	*/
		}
		});
	}
       
		public static void main(String args[]) {
			JoinGUI j=new JoinGUI();
		}
      }
	

