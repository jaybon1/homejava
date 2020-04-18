package coffeeshop.test;

class Data1 {
	
	// 오브젝트 자료형은 받기는 쉬우나 받은뒤 사용하려면 캐스팅 해야하기 때문에 불편
	Object data;
}


// 제네릭
class Data <T> {
	T value;
}

// 콤마를 통해서 두개를 넣을 수 있다
class Str<K, V>{
	K k;
	V v;
}


public class GenericEx01 {
	public static void main(String[] args) {
		Data1 data1 = new Data1();
		data1.data = "오브젝트자료형";
		System.out.println((String)data1.data);
		
		
		
		Data<String> data = new Data<>();
		data.value = "제네릭문자열";
		System.out.println(data.value);
		
		// 제네릭에는 기본자료형이 들어갈 수 없다 (Wrapper 클래스로 감싸야한다)
		// Wrapper 클래스 = 기본자료형에 첫글자에 대문자(클래스자료형처럼) (기본자료형의 수만큼 있음)
		// int -> Integer / char -> Character
		Data<Integer> data2 = new Data<>(); 
		
		data2.value = 10;
		System.out.println(data2.value);
		
		
		Str<String, String> s = new Str<>();
		s.k = "비밀번호";
		s.v = "bitc5500";
		
		System.out.println(s.k);
		System.out.println(s.v);
	}
}
