package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;
public class JoinGUI extends JFrame {//ȸ������ȭ��
	public JoinGUI(){
			
		  	JPanel p = new JPanel();
			Font fontbutton=new Font("12�Ե���Ʈ�帲Medium",Font.BOLD,14);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
	    	Image img = toolkit.getImage("C:\\\\Users\\\\s2019\\\\OneDrive\\\\���� ȭ��\\\\�̸��ΰ�.png");
		  	JLabel stunum= new JLabel("�й�");
		  	JLabel name= new JLabel("�̸�");	
		  	JLabel department= new JLabel("�а�");	
		  	String Department[]= {"���̵�����Ʈ�����","���̵�����ַ�ǰ�","���̵������ΰ�"};
	        JComboBox departmentcmb = new JComboBox(Department);
	        JLabel ID= new JLabel("���̵�");
	        JLabel PW = new JLabel("��й�ȣ");
	       
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
	      
	        JButton save = new JButton("����");
	        JButton cancle = new JButton("���");
	        JButton IDC = new JButton("ID �ߺ�");
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
			setTitle("ȸ������");
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
					+IDtf.getText()+"\'"; //������ ���̺��� �Է��� ���̵� �ϳ��� ������ 
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);//rs�� count 1
					rs.last();
					int rowcnt = rs.getInt(1);
					
					if(rowcnt == 0){//���� ������
						JOptionPane.showMessageDialog(null, "����� ������ ���̵� �Դϴ�.");
						st.close();//mysql���� �ݴ´�
						
					}else{//rs�� ���� �ϳ��� ������
						JOptionPane.showMessageDialog(null, "����� �Ұ����� ���̵� �Դϴ�.");
						IDtf.setText("");
					}
			}//end of try
			catch (Exception ex){
				JOptionPane.showMessageDialog(null, "ȸ�������� �Ұ��� �մϴ�. �����ڿ��� �����ֽʽÿ�");
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
				JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�");
				LoginGUI lv=new LoginGUI();
			}catch(Exception e) {
				System.out.println("ȸ�����Կ� �����Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�.");
				System.out.println(e.getMessage());
			}
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
				Connection con = DriverManager.getConnection(url, "root", "1111");
				
				String sql = "Insert into `1-2`.stuclasslist (StuNum) values (" + "\'" + stunumtf.getText()+ "\')";  
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				System.out.println("ȸ�����Կ� �����߽��ϴ�!");
				System.out.println("====================");
			}catch(Exception e) {
				System.out.println("ȸ�����Կ� �����Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�.");
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
				JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�");
				LoginGUI lv=new LoginGUI();
						
				System.out.println("4");		
					
	 
			}//end of try
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
			}//end of catch	*/
		}
		});
	}
       
		public static void main(String args[]) {
			JoinGUI j=new JoinGUI();
		}
      }
	

