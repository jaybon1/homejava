package ch15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class NetworkEx03 {
	
	public static int getTotalCount(String depAirportId, String arrAirportId, long depPlandTime) {
		try {
			// 1번 주소 객체 만들기
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=zkymID3s0eE1ymiOd0WYTwCEMeo4qKgV5e9DGU6QHceEc%2BWgah6BN5uEhr9tFRjolXkryBNbw9CNLnn6z9LTpg%3D%3D&numOfRows=50&pageNo=1&depAirportId=" + FlightInfoService.airPortId.get(depAirportId) + "&arrAirportId=" + FlightInfoService.airPortId.get(arrAirportId) + "&depPlandTime=" + depPlandTime + "&_type=json");

			// 2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3번 버퍼연결(문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// 4번 StringBuilder는 ArrayList<String>과 비슷하다
			// append로 String을 저장한뒤 호출하면 쭉 읽는다
			StringBuilder sb = new StringBuilder();
			String input;

			while ((input = br.readLine()) != null) {
				sb.append(input);
			}
			System.out.println(sb.toString());

			Gson gson = new Gson();

			Air air1 = gson.fromJson(sb.toString(), Air.class);
			
			return air1.getResponse().getBody().getTotalCount();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	static void airinfo(String depAirportId, String arrAirportId, long depPlandTime, int page) {
		try {
			// 1번 주소 객체 만들기
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=zkymID3s0eE1ymiOd0WYTwCEMeo4qKgV5e9DGU6QHceEc%2BWgah6BN5uEhr9tFRjolXkryBNbw9CNLnn6z9LTpg%3D%3D&numOfRows=50&pageNo=" + page + "&depAirportId=" + FlightInfoService.airPortId.get(depAirportId) + "&arrAirportId=" + FlightInfoService.airPortId.get(arrAirportId) + "&depPlandTime=" + depPlandTime + "&_type=json");

			// 2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3번 버퍼연결(문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// 4번 StringBuilder는 ArrayList<String>과 비슷하다
			// append로 String을 저장한뒤 호출하면 쭉 읽는다
			StringBuilder sb = new StringBuilder();
			String input;

			while ((input = br.readLine()) != null) {
				sb.append(input);
			}
			System.out.println(sb.toString());

			Gson gson = new Gson();

			Air air1 = gson.fromJson(sb.toString(), Air.class);
			
			List<Item> flightitem = air1.getResponse().getBody().getItems().getItem();
			
			for (Item item : flightitem) {
				System.out.println("항공사 : " + item.getAirlineNm());
				System.out.println("도착지 : " + item.getArrAirportNm());
				System.out.println("도착시간 : " + item.getArrPlandTime());
				System.out.println("출발지 : " + item.getDepAirportNm());
				System.out.println("출발시간 : " + item.getDepPlandTime());
				System.out.println("항공기ID : " + item.getVihicleId());
				System.out.println("이코노미요금 : " + item.getEconomyCharge());
				System.out.println("프레스티지요금 : " + item.getPrestigeCharge());
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		FlightInfoService.setAirLineId();
		FlightInfoService.setAirPortId();
		
		for (String key : FlightInfoService.airPortId.keySet()) {
			System.out.print(key + " ");
		}
		
		System.out.println();
		System.out.println("출발지를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String depAirportId = sc.next();
		
		System.out.println("도착지를 입력하세요.");
		String arrAirportId = sc.next();
		
		System.out.println("출발일자를 입력하세요.");
		String depPlandTimeTemp = sc.next();
		
		// 문자를 숫자타입으로 바꿀 수 있다
		long depPlandTime = Long.parseLong(depPlandTimeTemp);
		int depPlandTimeInt = Integer.parseInt(depPlandTimeTemp); // 기본자료형은 변수메서드를 가지고 있지 않아서 toString을 쓰지 못한다
		Integer depPlandTimeInteger = Integer.parseInt(depPlandTimeTemp);
		double depPlandTimeDouble = Double.parseDouble(depPlandTimeTemp);
		
		int page = 1;
		
		// 기본자료형은 뒤에 문자열을 붙여서 묵시적 형변환을 한다
		String strTemp = depPlandTime + " ";
		
		// 랩퍼자료형은 메서드를 가지고 있으니 toString을 사용한다
		String strTemp2 = depPlandTimeInteger.toString();
		
		
		String strTemp3 = depPlandTimeDouble + " ";

		int totalCount = getTotalCount(depAirportId, arrAirportId, 20200407);
		
		int count = 0;
		
		if(totalCount % 50 == 0) {
			count = totalCount / 50;
		} else {
			count = totalCount / 50 + 1;	
		}
		
		System.out.println(count);
		
		for (int i = 1; i < count+1; i++) {
			airinfo(depAirportId, arrAirportId, 20200407, i);
		}
	}
}
