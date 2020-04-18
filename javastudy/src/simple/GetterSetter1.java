package simple;

import java.util.Scanner;

class 통장{
	private int num;
	private String password;
	
	public 통장(int num, String password) {
		this.num = num;
		this.password = password;
	}
	
	
	public void 통장잔액확인(String password) {
		if(this.password.equals(password)) {
			System.out.println("잔액은 : " + num);
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
	
	public void 통장입금(String password, int money) {
		if(this.password.equals(password)) {
			num = num + money;
			System.out.println("잔액은 : " + num);
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
}

public class GetterSetter1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String select;
		int money;
		String password;
		
		통장 my = new 통장(10000, "a1234");
		
		while (true) {
			System.out.print("1.입금 2.잔액확인 3.나가기 >> ");
			if((select = sc.next()).equals("1")) {
				
				System.out.print("비밀번호를 입력해주세요 >>");
				password = sc.next();
				System.out.print("얼마를 입금 하시겠습니까? >>");
				money = Integer.parseInt(sc.next());
				
				my.통장입금(password, money);
				
			} else if(select.equals("2")) {
				
				System.out.print("비밀번호를 입력해주세요 >>");
				password = sc.next();
				
				my.통장잔액확인(password);
			} else {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
		
	}
}
