package simple;

public class Var2 {
	public static void main(String[] args) {

		
		// 괄호 안에서도 값 변경 가능
		int num = 0;
		System.out.println(num = num + 1);
		
		
		// 출력 후 1 증가
		num = 0;
		System.out.println(num++);

		
		// 1증가 후 출력
		num = 0;
		System.out.println(++num);

		
		num = 0;
		System.out.println(num++ + 1);

		
		num = 0;
		System.out.println(++num + 1);

	}
}
