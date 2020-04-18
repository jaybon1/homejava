package simple;

public class While {
	public static void main(String[] args) {
		
		// i가 1이 되면 i를 증가시키고 while 문을 다시 돌려라
		
		// i가 5보다 크면 while 문을 빠져나와라
		
		// 그외에는 i를 프린트해라

		// while
		int i = 0;
		while (i < 100) {
			

			if (i == 1) {
				i++;
				continue;

			} else if (i > 5) {
				break;

			} else {
				System.out.println(i);
			}
			i++;
		}
		
		System.out.println();
		
		
		for (int j = 0; j < 100; j++) {
			
			if (j == 1) {
				continue;
			
			// i가 5보다 크면 while 문을 빠져나와라
			} else if (j > 5) {
				break;
				
			// 그외에는 i를 프린트해라
			} else {
				System.out.println(j);
			}
		}

	}
}
