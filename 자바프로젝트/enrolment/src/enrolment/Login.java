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
			Class.forName("com.mysql.jdbc.Driver");//mysql 드라이버 호출
		    String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";//DB 주소 확인
			Connection con = DriverManager.getConnection(url, "root", "1111");//DB 연결
			
			//ID,PW 확인을 위한 dowhile문
			int dowhilenum = 0;
			do {
				System.out.print("아이디를 입력하세요 : ");
				member.setUserID(scan.next());
				
				System.out.print("비밀번호를 입력하세요 : ");
				member.setUserPW(scan.next());
				
			
				//Id와 password 일치여부 확인
				String sql = "SELECT Count(*) FROM `1-2`.member where UserID = " + "\'"+member.getUserID()+"\'" + " and UserPW = " 
						+ "\'"+member.getUserPW()+"\'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				rs.last();
				int rowcnt = rs.getInt(1);
				
				if(rowcnt == 0){
					System.out.println("잘못된 ID 또는 패스워드 입니다.");
				}else {
					dowhilenum = 1;
					st.close();
				}
				
				
			}while(dowhilenum == 0);
			
			
			System.out.println("=====================");
			System.out.println("로그인에 성공하였습니다!");
			System.out.println("=====================");
			
			//학번을 불러오기 위해-> 환영하는 사람 이름을 불러오기 위해 쓰인다
			String sql_Num = "SELECT StuNum FROM `1-2`.member where UserID = " + "\'"+member.getUserID()+"\'";
			Statement st_Num = con.createStatement();
			ResultSet rs_Num = st_Num.executeQuery(sql_Num);
			rs_Num.last();
			String stuNum = rs_Num.getString(1);
			member.setStuNum(stuNum);
			st_Num.close();
			
			//환영하는 사람 이름을 불러오기 위해
			String sql = "SELECT UserName FROM `1-2`.member where StuNum = " + "\'"+ member.getStuNum() + "\'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.last();
			String name = rs.getString(1);
			System.out.println(name+"님 환영합니다.");
			
		}catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}
		
		
	}

}