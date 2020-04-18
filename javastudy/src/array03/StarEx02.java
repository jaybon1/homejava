package array03;

public class StarEx02 {

	static void printStars(int k) {

		for (int i = 1; i <= k; i++) {

			for (int j = 0; j < k - i; j++) {
				System.out.print("_");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		printStars(5);

	}
}
