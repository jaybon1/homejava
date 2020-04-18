package ch15;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkEx01 {
	public static void main(String[] args) {

		try {
			// 1번 주소 객체 만들기
			URL url = new URL("https://www.naver.com");

			// 2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			// 3번 버퍼연결(문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			
			// 파일에 스트림 연결하기
			// 파일 작성기 인스턴스
			// 생성하는 순간 html 파일이 생성된다
			FileWriter fw = new FileWriter("C:\\utils\\test.html");
			
			// 4번 StringBuilder는 ArrayList<String>과 비슷하다
			// append로 String을 저장한뒤 호출하면 쭉 읽는다
			StringBuilder sb = new StringBuilder();
			String input;

			while ((input = br.readLine()) != null) {
				System.out.println(input);
				sb.append(input);
			}
			
			// toString() 모든데이터를 문자화 함
			fw.write(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
