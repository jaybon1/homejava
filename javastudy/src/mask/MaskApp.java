package mask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class MaskApp {

	public static long maskPage() {
		try {
			// 1번 주소 객체 만들기
			URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=1");

			// 2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3번 버퍼 연결 (문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// 4. 문자 더하기
			StringBuilder sb = new StringBuilder();

			String input = "";
			while ((input = br.readLine()) != null) {
				sb.append(input);
			}

			System.out.println(sb.toString());
			System.out.println();

			br.close(); // 버퍼 닫기
			con.disconnect(); // 스트림 닫기

			// 5. 자바 오브젝트로 변환
			Gson gson = new Gson();
			MaskInfo mask = gson.fromJson(sb.toString(), MaskInfo.class);
			long count = mask.getTotalPages();

			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public static MaskInfo maskInfo(int page) {
		try {
			// 1번 주소 객체 만들기
			URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=" + page);

			// 2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3번 버퍼 연결 (문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// 4. 문자 더하기
			StringBuilder sb = new StringBuilder();

			String input = "";
			while ((input = br.readLine()) != null) {
				sb.append(input);
			}

			System.out.println(sb.toString());
			System.out.println();

			br.close(); // 버퍼 닫기
			con.disconnect(); // 스트림 닫기

			// 5. 자바 오브젝트로 변환
			Gson gson = new Gson();
			MaskInfo mask = gson.fromJson(sb.toString(), MaskInfo.class);

			return mask;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		System.out.println("지역을 입력하세요");
		Scanner sc = new Scanner(System.in);
		String loc = sc.next();

		List<StoreInfo> test = maskInfo(1).getStoreInfos();

		maskInfo(1).getStoreInfos().get(0).getAddr();

		ArrayList<MaskInfo> maskInfoList = new ArrayList<>();

		for (int i = 1; i < 1 + 1; i++) { // maskPage() 넣어야함
			MaskInfo mask = maskInfo(i);
			maskInfoList.add(mask);
		}

		for (MaskInfo maskInfo : maskInfoList) {
			for (int i = 0; i < maskInfo.getStoreInfos().size(); i++) {
				if (maskInfo.getStoreInfos().get(i).getAddr().contains(loc)) {
					System.out.println(maskInfo.getStoreInfos().get(i).getAddr());
					System.out.println(maskInfo.getStoreInfos().get(i).getName());
					System.out.println();
				}
			}
		}
	}
}