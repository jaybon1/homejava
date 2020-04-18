package airplane;

import java.util.HashMap;

public class HashEx01 {
	public static void main(String[] args) {
		HashMap<String, String> auth = new HashMap<>();
		
		
		// 해시 키는 유일하다 "아이디"는 주소를 해시한다
		// 동일한 키값을 안만들려면 HashSet을 쓰면된다
		auth.put("아이디", "ssarmango");
		auth.put("비밀번호", "1234");
		auth.put("아이디", "cos");
		
		System.out.println(auth.keySet());
		
		System.out.println(auth.get("아이디"));
	}
}
