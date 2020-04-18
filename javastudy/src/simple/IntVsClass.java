package simple;


class 명함{
	String 이름 = "홍길동";
	String 전화번호 = "010-1234-5678";
}


public class IntVsClass {
	
	static int 기본자료형반환() {
		
		return 123;
		
	}
	
	static 명함 클래스자료형반환() {
		
		명함 m1 = new 명함();
		
		return m1;
	}
	
	public static void main(String[] args) {
		System.out.println("기본자료형반환 : " + 기본자료형반환());
		
		System.out.println();
		
		명함 m2 = 클래스자료형반환();
		
		System.out.println("클래스자료형반환 : " + m2);
	}
}
