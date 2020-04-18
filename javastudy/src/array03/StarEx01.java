package array03;

public class StarEx01 {
	
	static void printStars(int i) {
		for (int j = 0; j < i; j++) {			
			System.out.print("*"); // 1개
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
//		for (int i = 1; i < 5; i++) { // 바깥 for문은 행이다
//			printStars(i); // 열의 개수
//		}
		
		
		for (int i = 4; i > 0; i--) { // 바깥 for문은 행이다
			printStars(i); // 열의 개수
		}
	}
}
