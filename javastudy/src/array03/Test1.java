package array03;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 1; i <= num; i = i + 2) {

			int a = (num - i) / 2;

			for (int j = 0; j < a; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i <= num; i = i + 2) {

			for (int j = 0; j < i; j = j + 2) {
				System.out.print(" ");
			}

			for (int j = num - i - 1; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
