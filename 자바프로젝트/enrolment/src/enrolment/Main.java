package enrolment;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member = new Member();//전역변수 사용을 위한 멤버 클래스 호출
		Scanner scan = new Scanner(System.in);
		int dowhilenum = 0;
		
		System.out.println("<<미림여자정보과학고등학교 수강신청 프로그램 입니다>>");
		
		do {
			
			System.out.println("회원이시면 <로그인>을, 회원이 아니시면 <회원가입>을 눌러주세요");
			System.out.println();
			System.out.print("1. 회원가입    |  2. 로그인     |   3. 프로그램 종료  => ");
			int num = scan.nextInt();
			System.out.println();
			
			switch(num) {
			case 1 : {//회원가입
				Join join = new Join();
				join.main(null);
				}
			
			case 2 : {//로그인
				System.out.println("로그인을 시작하겠습니다.");
				Login login = new Login();
				login.main(null);
				dowhilenum = 1;
				Enrolment en = new Enrolment();
				Enrolment.main(null);
				}
				break;
			
			case 3 : {//종료
				System.out.println("프로그램 종료합니다.");
				dowhilenum = 1;
			
			}
			}
		}while(dowhilenum == 0);
		
		
	}

}