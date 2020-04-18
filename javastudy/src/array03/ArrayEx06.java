package array03;

import java.util.Scanner;

public class ArrayEx06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String tempNum = num + ""; // 숫자에 문자열을 더하면 문자열이된다(묵시적 형변환)
		String tempNum2[] = tempNum.split("");
		System.out.println(tempNum2[0]);
		System.out.println("길이 : " + tempNum2.length);

		// 맨뒷자리부터계산하려면 길이 -1 (하지만 맨뒷자리에 ,이 붙으면 안되니까 - 2)
		
		for (int i = tempNum2.length - 2; i >= 0; i--) {

			// (길이 - 1 - 맨뒤부터자리수) 를 3으로 나머지를 구해서 0이되면 뒤에서부터 4번째자리임
			if ((tempNum2.length - 1 - i) % 3 == 0) {

				// 그 4번째 자리뒤에 ,을 붙인다
				tempNum2[i] = tempNum2[i] + ",";
			}
		}

		// 배열을 순서대로 출력
		for (int i = 0; i < tempNum2.length; i++) {
			System.out.print(tempNum2[i]);
		}

	}
}
