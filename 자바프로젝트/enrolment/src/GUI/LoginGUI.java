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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



import enrolment.Member;
 
public class LoginGUI extends JFrame{
    public LoginGUI() {
    	
    	  JPanel p =new JPanel();
    	  JButton btnLogin=new JButton("로그인");
    	  JButton btnInit=new JButton("초기화");
    	  JPasswordField PWText=new JPasswordField();
    	  JTextField IDText=new JTextField();
    	  JLabel idLabel = new JLabel("아이디");
    	  JLabel passLabel = new JLabel("비밀번호");
    	  Font fontbutton=new Font("12롯데마트드림Medium",Font.BOLD,15);
    	  Toolkit toolkit = Toolkit.getDefaultToolkit();
    	  Image img = toolkit.getImage("C:\\\\Users\\\\s2019\\\\OneDrive\\\\바탕 화면\\\\미림로고.png");



    	  
    	  btnLogin.setBackground(new Color(62,157,55));
    	  btnLogin.setForeground(Color.WHITE);
		  btnLogin.setBorderPainted(false);
		  btnLogin.setFocusPainted(false);
    	  btnLogin.setFont(fontbutton);
    	  add(btnLogin);
    	  btnInit.setBackground(new Color(62,157,55));
    	  btnInit.setForeground(Color.WHITE);
		  btnInit.setBorderPainted(false);
		  btnInit.setFocusPainted(false);
    	  btnInit.setFont(fontbutton);
    	  add(btnInit);
    	  add(PWText);
    	  add(IDText);
    	  add(idLabel);
    	  add(passLabel);
    	  idLabel.setBounds(10, 10, 80, 25);
          passLabel.setBounds(10, 40, 80, 25);
          IDText.setBounds(100, 10, 160, 25);
          PWText.setBounds(100, 40, 160, 25);
          PWText.setEchoChar('*');
          btnInit.setBounds(160, 80, 90, 25);
          btnLogin.setBounds(10, 80, 90, 25);
	      add(p); 
	      
	      
	      setTitle("로그인");
	      setSize(280, 150);
	      setResizable(false);
	      setVisible(true);
	      setIconImage(img);
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	      btnInit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IDText.setText("");
                PWText.setText("");
            }
        });   
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			Member member = new Member();
			try {
			Class.forName("com.mysql.jdbc.Driver");//mysql 드라이버 호출
			String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";//DB 주소 확인
			Connection con = DriverManager.getConnection(url, "root", "1111");//DB 연결
			
			//Id와 password 일치여부 확인
			String sql = "SELECT Count(*) FROM `1-2`.member where UserID = " + "\'"+IDText.getText()+"\'" + " and UserPW = " 
			+ "\'"+PWText.getText()+"\'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.last();
			int rowcnt = rs.getInt(1);
			if(rowcnt == 0){
				JOptionPane.showMessageDialog(null, "잘못된 아이디 또는 패스워드 입니다.");
			}else {
				st.close();
				dispose();
				
				String sql_Num = "SELECT StuNum FROM `1-2`.member where UserID = " + "\'"+IDText.getText()+"\'";
				Statement st_Num = con.createStatement();
				ResultSet rs_Num = st_Num.executeQuery(sql_Num);
				rs_Num.last();
				String stuNum = rs_Num.getString(1);
				member.setStuNum(stuNum);
				st_Num.close();
				
				JOptionPane.showMessageDialog(null, member.getStuNum()+"님 환영합니다.");
				EnrolmentGUI eg=new EnrolmentGUI();
			}
			
			}catch(Exception e1) {
				System.out.println("Got an exception!");
				System.out.println(e1.getMessage());
			}	
            
    }
        });
    	
}
}
 
