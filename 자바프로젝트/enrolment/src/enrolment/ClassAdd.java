package enrolment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ClassAdd {
	private String ClassCode;//�����ڵ带 �޴´�
	private String ClassName;//������
	private String Teacher;//������
	
	
	Member ClassAdd = new Member();//meember �ν��Ͻ�
	
	
	public ClassAdd() { //������ �޼ҵ�
		super();
		this.ClassCode = ClassCode;
		this.ClassName = ClassName;
		this.Teacher = Teacher;
	}

	public String getClassCode() {
		return ClassCode;
	}

	public void setClassCode(String classCode) {
		ClassCode = classCode;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getTeacher() {
		return Teacher;
	}

	public void setTeacher(String teacher) {
		Teacher = teacher;
	}

	public void printList() {//���� ��� ����ϴ� �޼���
		
		//db ����
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
				
				System.out.format("%s | %s | %s \n", ClassCode, Teacher, ClassName);
			}
			st.close();
		} catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}
	}//end of printlist()
	
	//�����͸� ������ �޼���
	public void sendData() {
		
		//db ����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
			Connection con = DriverManager.getConnection(url, "root", "1111");
			
			String sql = "SELECT ClassName FROM `1-2`.classlist where ClassCode = " + "\'"+ ClassCode + "\'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.last();
			String ClassName = rs.getString(1);
			
			
			//�����ڵ带 ���� �α����� �л��ڵ��÷� ���� �ִ´�
			
			//list_1
			String sql_L1 = "SELECT Count(*) FROM `1-2`.stuclasslist where StuNum = " + "\'"+ ClassAdd.getStuNum() 
			+ "\' and list_1 <> " + "\'" + "\'";
			Statement stE1 = con.createStatement();
			ResultSet rsE1 = st.executeQuery(sql_L1);
			rsE1.last();
			int empty = rsE1.getInt(1);
			
			//list_2
			String sql_L2 = "SELECT Count(*) FROM `1-2`.stuclasslist where StuNum = " + "\'"+ ClassAdd.getStuNum() 
			+ "\' and list_2 <> " + "\'" + "\'";
			Statement stE2 = con.createStatement();
			ResultSet rsE2 = st.executeQuery(sql_L2);
			rsE2.last();
			int empty2 = rsE2.getInt(1);
			
			//list_3
			String sql_L3 = "SELECT Count(*) FROM `1-2`.stuclasslist where StuNum = " + "\'"+ ClassAdd.getStuNum() 
			+ "\' and list_3 <> " + "\'" + "\'";
			Statement stE3 = con.createStatement();
			ResultSet rsE3 = st.executeQuery(sql_L3);
			rsE3.last();
			int empty3 = rsE3.getInt(1);
			
			
			//���� �߰��� ��, �������� ������ 3������
			//3�� �ʰ� ��û�� �޼��� ����
			
			if(empty == 0) {//ù��° ������ ��������� empty=0
				String list_1 = "UPDATE `1-2`.stuclasslist SET list_1 =" + "\'" + ClassName + "\'"
					+ " WHERE StuNum =" + "\'" + ClassAdd.getStuNum() + "\'";
				Statement stL_1 = con.createStatement();
				stL_1.executeUpdate(list_1);
				st.close();
			}else if(empty2 == 0){//�ι�° ������ ��������� empty2=0
				String list_2 = "UPDATE `1-2`.stuclasslist SET list_2 =" + "\'" + ClassName + "\'"
					+ " WHERE StuNum =" + "\'" + ClassAdd.getStuNum() + "\'";
				Statement stL_2 = con.createStatement();
				stL_2.executeUpdate(list_2);
				st.close();
			}else if(empty3 == 0) {//����° ������ ��������� empty3=0
				String list_3 = "UPDATE `1-2`.stuclasslist SET list_3 =" + "\'" + ClassName + "\'"
					+ " WHERE StuNum =" + "\'" + ClassAdd.getStuNum() + "\'";
				Statement stL_3 = con.createStatement();
				stL_3.executeUpdate(list_3);
				st.close();
			}else {//4�� ��û�Ϸ��� �ϸ�?
				System.out.println("�� �̻� ��û�� �� �����ϴ�. �����ڿ��� �����ϼ���.");
				st.close();
			}
			
			stE1.close();
			stE2.close();
			stE3.close();
		
			
		}catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}		
	}//end of senddata()
	
	
	//���� ��������� �����ִ� �޼ҵ�
	public void ShowMy() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/1-2?characterEncoding=UTF-8&serverTimezone=UTC";
			Connection con = DriverManager.getConnection(url, "root", "1111");

			//�й��� ���� ���ο� �ִ� ���� ���
			String sql = "SELECT * FROM `1-2`.stuclasslist WHERE StuNum =" + "\'" + ClassAdd.getStuNum() + "\'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				for(int i = 2; i <= 4; i++) {//2=? 1���� �ϸ� �й��� ��µǾ
					String list = rs.getString(i);//���� ��� ���
						if(list == null) {//���������
							list = " ";//����ִ� �״�� ���
						}
					System.out.format((i-1) + ". %s \n", list);
				}
			}
			st.close();
		} catch(Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}
	}// end of showmy()
}
