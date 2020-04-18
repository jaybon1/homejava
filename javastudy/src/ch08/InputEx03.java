package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputEx03 {
	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(reader);

		// 자바통신은 이것으로 함
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

		String data = "";

		// 선을 계속 연결해줄 필요는 없이 선에서 받아온 내용을 읽기 때문에 여기서 while을 돌린다
		try {
			while ((data = br2.readLine()) != null) {
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
