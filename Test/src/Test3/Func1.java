package Test3;

public class Func1 {
	
	static void 함수() {
		System.out.println("그냥함수");
	}

	static void 함수(int a) {
		System.out.println(a+" 숫자함수");
	}
	
	static void 함수(String str) {
		System.out.println(str +" 문자열함수입니다");
	}
	
	static void 함수(boolean boo) {
		System.out.println(boo +" 불린함수입니다");
	}
	
	public static void main(String[] args) {
		
		함수();
		
	}
}


