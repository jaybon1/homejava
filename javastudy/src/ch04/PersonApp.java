package ch04;

public class PersonApp {
	public static void main(String[] args) {
		Person p1 = new Person(); // 인스턴스화
		p1.name = "최승희"; // 변수에 값넣기는 문법적으로는 가능하지만 현실적이지 않다. 이렇게 짜면 좋지 않다.
		p1.job = "의사";
		p1.gender = '여';
		p1.bloodType = "AB";
		p1.age = 45;

		Person p2 = new Person();
		p2.name = "이미녀";
		p2.job = "골프선수";
		p2.gender = '여';
		p2.bloodType = "O";
		p2.age = 28;

		Person p3 = new Person();
		p3.name = "김미남";
		p3.job = "교수";
		p3.gender = '남';
		p3.bloodType = "AB";
		p3.age = 47;

		System.out.println(p3.name);
		System.out.println(p3.job);
		System.out.println(p3.gender);
		System.out.println(p3.age);
		System.out.println(p3.bloodType);

		Person p4 = new Person(
			"홍길동",
			"학생",
			33,
			'남',
			"O"
		);
		
		System.out.println(p4.name);

	}
}
