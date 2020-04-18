package simple;

// 상태와 행동
public class Person {

	String name;
	String job;
	int age;
	char gender;
	String bloodType;

	// 디폴트 생성자(없어도 호출됨 - 컴파일러가 자동으로만들어준다) - 초기화 용도
	// 생성자를 수동으로 만든다면 디폴트 생성자를 만들어 주지 않는다.
	// 매개변수가 없다
	public Person() { // 함수와 비슷하게 생겼지만 첫글자가 대문자며 클래스이름과 같다.

	}

	// 오버로딩(함수명이 같아도 매개변수가 다르면 다른 함수로 인식한다)
	public Person(String name, String job, int age, char gender, String bloodType) {
		this.name = name;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.bloodType = bloodType;
	}

}