package ch02;

public class VarEx02 {

	public static void main(String[] args) {
		double myNum = 10.5; // 8바이트
		System.out.println(myNum);
		
		int num1 = (int)myNum;
		System.out.println(num1);
		
		int num2 = 10;
		double num3 = num2;
		System.out.println(num3);
		
		float aa = 1.5f; // float는 뒤에 f붙여야함.
	}

}
