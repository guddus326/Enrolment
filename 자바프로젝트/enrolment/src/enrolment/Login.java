package enrolment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Member member = new Member();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//mysql ����̹� ȣ��
		    String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";//DB �ּ� Ȯ��
			Connection con = DriverManager.getConnection(url, "root", "1111");//DB ����
			
			//ID,PW Ȯ���� ���� dowhile��
			int dowhilenum = 0;
			do {
				System.out.print("���̵� �Է��ϼ��� : ");
				member.setUserID(scan.next());
				
				System.out.print("��й�ȣ�� �Է��ϼ��� : ");
				member.setUserPW(scan.next());
				
			
				//Id�� password ��ġ���� Ȯ��
				String sql = "SELECT Count(*) FROM `1-2`.member where UserID = " + "\'"+member.getUserID()+"\'" + " and UserPW = " 
						+ "\'"+member.getUserPW()+"\'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				rs.last();
				int rowcnt = rs.getInt(1);
				
				if(rowcnt == 0){
					System.out.println("�߸��� ID �Ǵ� �н����� �Դϴ�.");
				}else {
					dowhilenum = 1;
					st.close();
				}
				
				
			}while(dowhilenum == 0);
			
			
			System.out.println("=====================");
			System.out.println("�α��ο� �����Ͽ����ϴ�!");
			System.out.println("=====================");
			
			//�й��� �ҷ����� ����-> ȯ���ϴ� ��� �̸��� �ҷ����� ���� ���δ�
			String sql_Num = "SELECT StuNum FROM `1-2`.member where UserID = " + "\'"+member.getUserID()+"\'";
			Statement st_Num = con.createStatement();
			ResultSet rs_Num = st_Num.executeQuery(sql_Num);
			rs_Num.last();
			String stuNum = rs_Num.getString(1);
			member.setStuNum(stuNum);
			st_Num.close();
			
			//ȯ���ϴ� ��� �̸��� �ҷ����� ����
			String sql = "SELECT UserName FROM `1-2`.member where StuNum = " + "\'"+ member.getStuNum() + "\'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.last();
			String name = rs.getString(1);
			System.out.println(name+"�� ȯ���մϴ�.");
			
		}catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}
		
		
	}

}