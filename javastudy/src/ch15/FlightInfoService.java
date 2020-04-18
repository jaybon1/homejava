package ch15;

import java.util.HashMap;

// 자바의 오브젝트 역할을 하는 것이 아닌 어쩔수 없이 데이터를 저장하기 위해 만든 클래스이다 (자바의 1급 객체는 클래스 뿐이므로)
public class FlightInfoService {

	// OOP와 상관없는 유틸적인 클래스라 객체지향 규칙을 안따라도 된다.
	public static HashMap<String, String> airLineId = new HashMap<>();
	public static HashMap<String, String> airPortId = new HashMap<>();

	public static void setAirLineId() {
		airLineId.put("아시아나항공", "AAR");
		airLineId.put("에어부산", "ABL");
		airLineId.put("이스타항공", "ESR");
		airLineId.put("제주항공", "JJA");
		airLineId.put("진 에어", "JNA");
		airLineId.put("대한 항공", "KAL");
		airLineId.put("티웨이항공", "TWB");
	}

	public static void setAirPortId() {
		airPortId.put("무안", "NAARKJB");
		airPortId.put("광주", "NAARKJJ");
		airPortId.put("군산", "NAARKJK");
		airPortId.put("여수", "NAARKJY");
		airPortId.put("원주", "NAARKNW");
		airPortId.put("양양", "NAARKNY");
		airPortId.put("제주", "NAARKPC");
		airPortId.put("김해", "NAARKPK");
		airPortId.put("사천", "NAARKPS");
		airPortId.put("울산", "NAARKPU");
		airPortId.put("인천", "NAARKSI");
		airPortId.put("김포", "NAARKSS");
		airPortId.put("포항", "NAARKTH");
		airPortId.put("대구", "NAARKTN");
		airPortId.put("청주", "NAARKTU");
	}

}
