package ch03;

// 자바 기준
// 메소드(함수)는 클래스 안에 작성할 수 있다.
// 메소드(함수)는 메소드 (함수)안에 작성할 수 없다.

public class MethodEx01 {

	// 전역공간

	// void는 리턴하지 않는다는 뜻이다

	public static void main(String[] args) {

		int num = Cal.add(5, 3);
		System.out.println("더하기 : " + num);

		System.out.println("빼기    : " + Cal.minus(5, 3));

		System.out.println("곱하기 : " + Cal.multi(5, 3));

		System.out.println("나누기 : " + Cal.devide(5, 3));
		
	}
}
