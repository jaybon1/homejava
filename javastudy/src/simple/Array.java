package simple;

import java.util.ArrayList;

public class Array {
	
	// 배열은 클래스 자료형은 아니지만 주소다
	// 배열은 한번 길이가 정해지면 늘이거나 줄일 수 없다
	static int[] intArray = {0,1,2};
	
	
	// 어레이리스트는 대문자로시작하기 때문에 참조자료형이다
	// 
	static ArrayList<Integer> intArrayList = new ArrayList<>();
	
	
	public static void main(String[] args) {
		
		// intArray를 출력하면 주소값이 나온다.
		//System.out.println(intArray);
		
		//System.out.println(intArray[0]);
		
		// 배열을 늘일 수 없으므로 안됨
		//intArray[3] = 3;
		
		//System.out.println(intArray[3]);
		

		
		
		// 어레이리스트
		//System.out.println(intArrayList);
		
		intArrayList.add(222);
		
		//System.out.println(intArrayList);
		
		intArrayList.add(333);
		
		//System.out.println(intArrayList);
		
		//System.out.println(intArrayList.get(0));
		
		System.out.println(intArrayList.remove(0));
		
		System.out.println(intArrayList.get(1));
		
		intArrayList.clear();
		
		System.out.println(intArrayList);
	}
	
}
