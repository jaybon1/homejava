package array03;

public class ArrayEx01 {

	public static void main(String[] args) {
		// 반복 stack
		int num = 1;
		for (long i = 2L; i <= 4000000000000000000L; i = i * 2) { // 콤마가 없으니 인수가 1개, 세미콜론은 구분자
			System.out.println("2의 " + num + "승 : " + i);
			num++;
		}
	}
}
