package enrolment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Member {//ȸ�� 
	private static String StuNum;//������ ���̺� ���� ���� �� �й����� ������ �Ѵ�
	private String UserName;
	private String UserID;//
    private String UserPW;
    private String PwCheck;//��й�ȣ Ȯ��
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
				System.out.println("ȸ�����Կ� �����Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�.");
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
				System.out.println("ȸ�����Կ� �����߽��ϴ�!");
				System.out.println("====================");
			}catch(Exception e) {
				System.out.println("ȸ�����Կ� �����Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�.");
				System.out.println(e.getMessage());
			}
		}



}