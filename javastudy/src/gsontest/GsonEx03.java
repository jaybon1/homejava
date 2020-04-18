package gsontest;

import com.google.gson.Gson;


class Cos {

	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}

//{"name":"코스", "age":40}

public class GsonEx03 {

	public static void main(String[] args) {
		// 다운받은 json 데이터
		//타입은 String (BufferdReader로 읽을테니까.. 문자열이다) 
		String jsonDate = "{\"name\":\"코스\", \"age\":40}";  

		// json 데이터 -> java 오브젝트
		Gson gson = new Gson();
		
		Cos c1 = gson.fromJson(jsonDate, Cos.class);
		
		System.out.println(c1.getName());

	}
}
