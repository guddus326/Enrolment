package enrolment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Member {//회원 
	private static String StuNum;//데이터 테이블에 값을 넣을 때 학번으로 구분을 한다
	private String UserName;
	private String UserID;//
    private String UserPW;
    private String PwCheck;//비밀번호 확인
    private String Department;
	
    
 
	public Member() {
		super();
		this.UserName = UserName;
		this.UserID = UserID;
		this.UserPW = UserPW;
		this.Department = Department;
		this.PwCheck=PwCheck;
	}



	public String getUserName() {
		return UserName;
		}
	
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public String getUserID() {
		return UserID;
	}
	
	public void setUserID(String userID) {
		UserID = userID;
	}
	
	public String getUserPW() {
		return UserPW;
	}
	
	public void setUserPW(String userPW) {
		UserPW = userPW;
	}
	public String getPwCheck() {
		return PwCheck;
	}

	public void setPwCheck(String pwCheck) {
		PwCheck = pwCheck;
	}
	
	public String getDepartment() {
		return Department;
	}
	
	public void setDepartment(String department) {
		Department = department;
	}
	
	public static String getStuNum() {
		return StuNum;
	}
	public void setStuNum(String stunum) {
		StuNum=stunum;
	}
	

   public void sendData(){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
				Connection con = DriverManager.getConnection(url, "root", "1111");
				
				String sql = "Insert into `1-2`.member (StuNum,UserName, UserID, UserPW, Department) values ("
						+ "\'" + StuNum + "\'," + "\'" + UserName + "\'," +"\'"+ UserID +"\',"
						+"\'"+ UserPW +"\'," + "\'"+ Department +"\')";  
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				System.out.println("====================");
			}catch(Exception e) {
				System.out.println("회원가입에 실패하였습니다. 관리자에게 문의바랍니다.");
			}
		}
		
		public void sendData_list() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
				Connection con = DriverManager.getConnection(url, "root", "1111");
				
				String sql = "Insert into `1-2`.stuclasslist (StuNum) values (" + "\'" + StuNum + "\')";  
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				System.out.println("회원가입에 성공했습니다!");
				System.out.println("====================");
			}catch(Exception e) {
				System.out.println("회원가입에 실패하였습니다. 관리자에게 문의바랍니다.");
				System.out.println(e.getMessage());
			}
		}



}