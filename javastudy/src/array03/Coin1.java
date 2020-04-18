package array03;

//남은 동전의 개수를 구하는 프로그램(500, 100 , 50, 10)
//2680
public class Coin1 {
	public static void main(String[] args) {
		int money = 2680;
		int count = 0;
		System.out.println("시작금액 : " + money);

		for (int i = 500; i > 9; i = i + 0) {

			count = money / i;
			money = money % i;
			System.out.println(i + "원 개수 : " + count);
			System.out.println("남은 금액 : " + money);
			
			// 트루 오어 폴스
			boolean a = true;
			
			// i가 5의 배수면 a = false
			for (int j = 10; j < 1000000000; j = j * 10) {
				if (i / j == 5) {
					a = false;
				}
			}
			
			// i가 5의 배수인지 확인후 계산
			if (a == true) {
				i = i / 2;
			} else {
				i = i / 5;
			}
		}
	}
}
