package ch03;

class Data {
	int num = 10;
}

public class MethodEx02 {
	
	static void ����(int num) {
		num++;
		System.out.println("���� num : " + num);
	}
	
	// ���� �����ϴٸ� return�� �ϰų� heap�� �Űܴ�ƾ��Ѵ�
	static int ����1(int num) {
		num++;
		System.out.println("����1 num : " + num);
		return num;
	}
	
	static void ����(int num) {
		num--;
		System.out.println("���� num : " + num);
		
	}
	
	static void ����1(Data d) {
		d.num--;
		System.out.println("����1 num : " + d.num);
		
	}
	
	public static void main(String[] args) {
		
		int myNum = 100;
		����(myNum); // call by value passing
		System.out.println("myNum : " + myNum);
		
		myNum = ����1(myNum); // call by value passing
		System.out.println("myNum : " + myNum);
		
		
		Data data = new Data();
		����(data.num); // call by value passing
		System.out.println("data.num : " + data.num);
		
		
		����1(data); // call by reference passing
		System.out.println("data.num : " + data.num);
		
	}
}