package ch15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class NetworkEx02 {
	
	static void airinfo() {
		
	}
	
	public static void main(String[] args) {

		try {
			// 1번 주소 객체 만들기
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=zkymID3s0eE1ymiOd0WYTwCEMeo4qKgV5e9DGU6QHceEc%2BWgah6BN5uEhr9tFRjolXkryBNbw9CNLnn6z9LTpg%3D%3D&numOfRows=50&pageNo=1&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20200407&_type=json");

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
			
			Gson gson = new Gson();
			
			Air air1 = gson.fromJson(sb.toString(), Air.class);
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
