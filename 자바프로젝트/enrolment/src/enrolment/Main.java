package enrolment;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member = new Member();//�������� ����� ���� ��� Ŭ���� ȣ��
		Scanner scan = new Scanner(System.in);
		int dowhilenum = 0;
		
		System.out.println("<<�̸������������а���б� ������û ���α׷� �Դϴ�>>");
		
		do {
			
			System.out.println("ȸ���̽ø� <�α���>��, ȸ���� �ƴϽø� <ȸ������>�� �����ּ���");
			System.out.println();
			System.out.print("1. ȸ������    |  2. �α���     |   3. ���α׷� ����  => ");
			int num = scan.nextInt();
			System.out.println();
			
			switch(num) {
			case 1 : {//ȸ������
				Join join = new Join();
				join.main(null);
				}
			
			case 2 : {//�α���
				System.out.println("�α����� �����ϰڽ��ϴ�.");
				Login login = new Login();
				login.main(null);
				dowhilenum = 1;
				Enrolment en = new Enrolment();
				Enrolment.main(null);
				}
				break;
			
			case 3 : {//����
				System.out.println("���α׷� �����մϴ�.");
				dowhilenum = 1;
			
			}
			}
		}while(dowhilenum == 0);
		
		
	}

}