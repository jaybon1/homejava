package simple;

public class DownUp {
	static double 더블숫자 = 1.1321324654;

	static int 인트숫자 = 132;

	static int 인트숫자1 = 5;

	public static void main(String[] args) {

		// 하위자료형을 상위로 올리는 것이 업 캐스팅(더 넓은 공간으로 가기때문에 데이터는 유지)
		System.out.println((double) 인트숫자);

		// 상위자료형을 하위로 내리는 것이 다운 캐스팅(일부 데이터를 소실한다)
		System.out.println((int) 더블숫자);

		// 상위자료형과 하위자료형을 더하는 등의 연산을 하면 상위자료형으로 묵시적 형변환 한다
		System.out.println(더블숫자 + 인트숫자);

		// 명시적으로 형변환도 가능
		System.out.println(더블숫자 + (double) 인트숫자);

	}
}
