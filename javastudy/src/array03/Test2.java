package array03;

import javax.xml.transform.Templates;

public class Test2 {
	public static void main(String[] args) {
		char arr[] = { '가', '나', '다', '라', '마' };
		System.out.println(arr);

		for (int i = 0; i < (arr.length) / 2; i++) {

			char temp = arr[arr.length - 1 - i];

			arr[arr.length - 1 - i] = arr[i];

			arr[i] = temp;

		}

		System.out.println(arr);
	}
}
