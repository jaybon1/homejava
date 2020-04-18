package simple;

public class ForEx01 {
	public static void main(String[] args) {
		
		// i 가 0 ~ 9 까지 도는 for문을 만든다
		
		// i 가 2일 경우 continue 를 실행한다
		
		// i 가 7일 경우 break를 실행한다
		
		for (int i = 0; i < 10; i++) {
			
			if(i == 2) {
				
				System.out.println("continue 실행");
				continue;
				
			} else if(i == 7) {
				
				System.out.println("break 실행");
				break;
				
			}
			System.out.println(i);
		}
	}
}
