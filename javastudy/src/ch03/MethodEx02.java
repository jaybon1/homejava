package ch03;

class Data {
	int num = 10;
}

public class MethodEx02 {
	
	static void 증가(int num) {
		num++;
		System.out.println("증가 num : " + num);
	}
	
	// 값이 소중하다면 return을 하거나 heap에 옮겨담아야한다
	static int 증가1(int num) {
		num++;
		System.out.println("증가1 num : " + num);
		return num;
	}
	
	static void 감소(int num) {
		num--;
		System.out.println("감소 num : " + num);
		
	}
	
	static void 감소1(Data d) {
		d.num--;
		System.out.println("감소1 num : " + d.num);
		
	}
	
	public static void main(String[] args) {
		
		int myNum = 100;
		증가(myNum); // call by value passing
		System.out.println("myNum : " + myNum);
		
		myNum = 증가1(myNum); // call by value passing
		System.out.println("myNum : " + myNum);
		
		
		Data data = new Data();
		감소(data.num); // call by value passing
		System.out.println("data.num : " + data.num);
		
		
		감소1(data); // call by reference passing
		System.out.println("data.num : " + data.num);
		
	}
}
