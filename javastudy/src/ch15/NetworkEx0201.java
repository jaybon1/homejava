package ch15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class NetworkEx0201 {
	
	public static void main(String[] args) {

		try {
			// 1번 주소 객체 만들기
			URL url = new URL("여기에 주소를 입력하세요");
			
			// 2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			// 3번 버퍼연결(문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			
			// 4번 StringBuilder는 ArrayList<String>과 비슷하다
			// append로 String을 저장한뒤 호출하면 쭉 읽는다
			StringBuilder sb = new StringBuilder();
			String input = "";
			
			while ((input = br.readLine()) != null) {
				sb.append(input);
			}
			System.out.println(sb.toString());

			// gson을 이용하여 Air타입의 인스턴스 만들기
			Gson gson = new Gson();		
			
			Air air1 = gson.fromJson(sb.toString(), Air.class);
			
			// 테스트해본다
			System.out.println("항공사 : " + air1.getResponse().getBody().getItems().getItem().get(0).getAirlineNm());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
