package simple;


class Num{
	// 변수의 선언
	private int 숫자변수; // 선언
	private int 숫자변수1;
	private int 숫자변수2;
	
	public int get숫자변수() {
		return 숫자변수;
	}
	
	
	// 메서드(함수)의 선언
	public void set숫자변수(int 숫자) {
		숫자변수 = 숫자;
	}
	
	// 오버로딩
	public void set숫자변수(int 숫자, int 숫자1) {
		숫자변수 = 숫자;
		숫자변수1 = 숫자1;
	}
	
	// 오버로딩
	public void set숫자변수(int 숫자, int 숫자1, int 숫자2) {
		숫자변수 = 숫자;
		숫자변수1 = 숫자1;
		숫자변수2 = 숫자2;
	}
	

	public int 리턴테스트() {
		
		// 리턴은 함수를 종료시킨다
		// 만약에 i가 5이상이면 i를 리턴해라
		// 모든 경우의 수를 만족하지못하면 -1을 리턴해라
		
		int i = 1;
		while(i < 100) {
			
			if(i > 5) {
				return i;
			}
			i++;
		}
		return -1;
	}
}


public class Method {
	public static void main(String[] args) {
		
		Num test1 = new Num();
		
		// 숫자변수 세팅하기
		test1.set숫자변수(12);
		
		// 숫자변수 받기
		System.out.println(test1.get숫자변수());
		
		test1.리턴테스트();
		
		// 리턴테스트
		System.out.println(test1.리턴테스트());

	}
}
