package simple;

public class ForEx02 {
	public static void main(String[] args) {

		// 공간이 10개인 int 배열을 만들고
		// for문을 이용하여 0 ~ 9 를 삽입한다

		int arr[] = new int[10];

		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i] = i);

		}

		// for each 문
		int arr1[] = new int[10];

		int temp = 0;
		for (int i : arr1) {

			System.out.println(i = temp);

			temp++;

		}
	}
}
