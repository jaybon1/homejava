package array03;

import java.util.Scanner;

public class ArrayEx05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String tempNum = num + ""; // 숫자에 문자열을 더하면 문자열이된다(묵시적 형변환)
		String tempNum2[] = tempNum.split("");
		System.out.println(tempNum2[0]);
		System.out.println("길이 : " + tempNum2.length);
		int l3 = tempNum2.length % 3;
		for (int i = 0; i < tempNum2.length - 1; i++) {
			if (i % 3 + 1 == l3) {
				tempNum2[i] = tempNum2[i] + ",";
			}
			System.out.print(tempNum2[i]);
		}
		System.out.print(tempNum2[tempNum2.length - 1]);
	}
}
