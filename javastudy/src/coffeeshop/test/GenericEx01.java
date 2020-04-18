package coffeeshop.test;

class Data1 {
	
	// ������Ʈ �ڷ����� �ޱ�� ���쳪 ������ ����Ϸ��� ĳ���� �ؾ��ϱ� ������ ����
	Object data;
}


// ���׸�
class Data <T> {
	T value;
}

// �޸��� ���ؼ� �ΰ��� ���� �� �ִ�
class Str<K, V>{
	K k;
	V v;
}


public class GenericEx01 {
	public static void main(String[] args) {
		Data1 data1 = new Data1();
		data1.data = "������Ʈ�ڷ���";
		System.out.println((String)data1.data);
		
		
		
		Data<String> data = new Data<>();
		data.value = "���׸����ڿ�";
		System.out.println(data.value);
		
		// ���׸����� �⺻�ڷ����� �� �� ���� (Wrapper Ŭ������ ���ξ��Ѵ�)
		// Wrapper Ŭ���� = �⺻�ڷ����� ù���ڿ� �빮��(Ŭ�����ڷ���ó��) (�⺻�ڷ����� ����ŭ ����)
		// int -> Integer / char -> Character
		Data<Integer> data2 = new Data<>(); 
		
		data2.value = 10;
		System.out.println(data2.value);
		
		
		Str<String, String> s = new Str<>();
		s.k = "��й�ȣ";
		s.v = "bitc5500";
		
		System.out.println(s.k);
		System.out.println(s.v);
	}
}