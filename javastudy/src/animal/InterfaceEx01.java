package animal;

// 인터페이스의 변수와 함수
// 1. 변수 : public static final 생략
// 2. 함수 : public abstract 생략
// 3. 통로의 역할 - 동적 바인딩
// 4. 무조건 추상메서드만 존재가능 -> 강제성부여
// 5. new 할 수 없다

public enum LoginResult
}

// 고정된 범위의 값을 주는 것을 [도메인]을 준다고 한다
interface 부서 {
	int 총무과 = 10; // 공통코드
	int 생산팀 = 20; // 공통코드
	int 인사과 = 30; // 공통코드
	int 행정과 = 40; // 공통코드
}

interface Cal {
	int num = 10; // 인터페이스의 변수는 무조건 public static final 이다.
}

public class InterfaceEx01 {
	public static void main(String[] args) {
		System.out.println(Cal.num);
	}
}
