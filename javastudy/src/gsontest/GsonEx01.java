package gsontest;

import com.google.gson.Gson;

class Family {
	int ��;
	String �ƹ���;
	String ��Ӵ�;
}

class Person {
	String �̸�;
	int ����;
	String ����;
	String �ּ�;
	String[] Ư��;
	Family ��������;
	String ȸ��;
}

public class GsonEx01 {
	public static void main(String[] args) {
		String jsonPerson = "{\"�̸�\":\"ȫ�浿\",\"����\":25,\"����\":\"��\",\"�ּ�\":\"����Ư���� ��õ�� ��\",\"Ư��\":[\"��\",\"����\"],\"��������\":{\"��\":2,\"�ƹ���\":\"ȫ�Ǽ�\",\"��Ӵ�\":\"�ἶ\"},\"ȸ��\":\"��� ������ �ȴޱ� �츸��\"}";

		Gson gson = new Gson();
		Person p = gson.fromJson(jsonPerson, Person.class);
		System.out.println(p.�̸�);
		
		if(p.�̸�.equals("ȫ�浿")) {
			System.out.println("�ƽþƳ��װ�");
		}
		
		
	}
}