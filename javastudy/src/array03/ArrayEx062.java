package array03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ArrayEx062 {

	public static void main(String[] args) {

		DecimalFormat formatter = new DecimalFormat("###,###");
		Scanner scan = new Scanner(System.in);
		System.out.println("¼ö ÀÔ·Â : ");
		int num = scan.nextInt();
		System.out.println("result : " + formatter.format(num));

	}

}