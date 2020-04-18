package array03;

import java.util.Random;
import java.util.Scanner;

public class Updown {
	public static void main(String[] args) {
		Random random = new Random();
		int k = random.nextInt(100);
		int min = 0;
		int max = 99;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("수를 결정하였습니다. 맟추어 보세요.");
		
		while (true) {

			System.out.println(min + "-" + max);
			
			int say = sc.nextInt();
			
			if (say == k) {
				System.out.println("맞았습니다.");
				System.out.println("다시하시겠습니까?(y/n)");
				String yn = sc.next();
				if (yn.equals("y")) {
					System.out.println("수를 결정하였습니다. 맟추어 보세요.");
					k = random.nextInt(100);
					min = 0;
					max = 99;
				} else {
					System.out.println("종료합니다.");
					break;
				}
			} else if (say > k) {
				System.out.println("더 낮게");
				if (max > say) {
					max = say;
				}
			} else if (say < k) {
				System.out.println("더 높게");
				if (min < say) {
					min = say;
				}
			}

		}

	}
}
