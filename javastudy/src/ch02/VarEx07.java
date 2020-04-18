package ch02;

/**
 * 
 * @author admin
 *
 */



public class VarEx07 {
	public static void main(String[] args) {
		// 타입을 Object로 만들면 추론하기 힘들어짐
		// 받을 것이 모호할때만 제한적으로 사용
		
		Object n1 = 1;
		Object n2 = '가';
		Object n3 = "문자열";
		Object n4 = 10.5;
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);
	}
}
