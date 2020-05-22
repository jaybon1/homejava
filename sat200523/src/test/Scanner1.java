package test;

import java.util.Scanner;

public class Scanner1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println("출력결과 : " + str);
		
		sc.close();
		
	}
}
