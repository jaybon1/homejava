package array03;

import java.util.Scanner;

public class ArrayEx07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("6자리 숫자를 입력하세요.");
		int num = sc.nextInt();
		String strNum = num + "";
		System.out.println();

		for (int i = 0; i < strNum.length(); i++) {

			if (strNum.charAt(i) == '3') {
				System.out.println("내용에 3이 존재합니다.");
				break;
			}

			else if (i == strNum.length() - 1) {
				System.out.println("내용에 3이 없습니다.");
			}

		}
	}
}
