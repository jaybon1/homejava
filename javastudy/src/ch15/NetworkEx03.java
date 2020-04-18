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
			// 1�� �ּ� ��ü �����
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=zkymID3s0eE1ymiOd0WYTwCEMeo4qKgV5e9DGU6QHceEc%2BWgah6BN5uEhr9tFRjolXkryBNbw9CNLnn6z9LTpg%3D%3D&numOfRows=50&pageNo=1&depAirportId=" + FlightInfoService.airPortId.get(depAirportId) + "&arrAirportId=" + FlightInfoService.airPortId.get(arrAirportId) + "&depPlandTime=" + depPlandTime + "&_type=json");

			// 2�� ��Ʈ�� ����
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3�� ���ۿ���(���ڿ�)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// 4�� StringBuilder�� ArrayList<String>�� ����ϴ�
			// append�� String�� �����ѵ� ȣ���ϸ� �� �д´�
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
			// 1�� �ּ� ��ü �����
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=zkymID3s0eE1ymiOd0WYTwCEMeo4qKgV5e9DGU6QHceEc%2BWgah6BN5uEhr9tFRjolXkryBNbw9CNLnn6z9LTpg%3D%3D&numOfRows=50&pageNo=" + page + "&depAirportId=" + FlightInfoService.airPortId.get(depAirportId) + "&arrAirportId=" + FlightInfoService.airPortId.get(arrAirportId) + "&depPlandTime=" + depPlandTime + "&_type=json");

			// 2�� ��Ʈ�� ����
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3�� ���ۿ���(���ڿ�)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// 4�� StringBuilder�� ArrayList<String>�� ����ϴ�
			// append�� String�� �����ѵ� ȣ���ϸ� �� �д´�
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
				System.out.println("�װ��� : " + item.getAirlineNm());
				System.out.println("������ : " + item.getArrAirportNm());
				System.out.println("�����ð� : " + item.getArrPlandTime());
				System.out.println("����� : " + item.getDepAirportNm());
				System.out.println("��߽ð� : " + item.getDepPlandTime());
				System.out.println("�װ���ID : " + item.getVihicleId());
				System.out.println("���ڳ�̿�� : " + item.getEconomyCharge());
				System.out.println("������Ƽ����� : " + item.getPrestigeCharge());
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
		System.out.println("������� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		String depAirportId = sc.next();
		
		System.out.println("�������� �Է��ϼ���.");
		String arrAirportId = sc.next();
		
		System.out.println("������ڸ� �Է��ϼ���.");
		String depPlandTimeTemp = sc.next();
		
		// ���ڸ� ����Ÿ������ �ٲ� �� �ִ�
		long depPlandTime = Long.parseLong(depPlandTimeTemp);
		int depPlandTimeInt = Integer.parseInt(depPlandTimeTemp); // �⺻�ڷ����� �����޼��带 ������ ���� �ʾƼ� toString�� ���� ���Ѵ�
		Integer depPlandTimeInteger = Integer.parseInt(depPlandTimeTemp);
		double depPlandTimeDouble = Double.parseDouble(depPlandTimeTemp);
		
		int page = 1;
		
		// �⺻�ڷ����� �ڿ� ���ڿ��� �ٿ��� ������ ����ȯ�� �Ѵ�
		String strTemp = depPlandTime + " ";
		
		// �����ڷ����� �޼��带 ������ ������ toString�� ����Ѵ�
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