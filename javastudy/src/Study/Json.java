package Study;

import com.google.gson.Gson;

public class Json {

	public static void main(String[] args) {
		String bb = "{\"response\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL SERVICE.\"},\"body\":{\"items\":{\"item\":[{\"airlineNm\":\"�� ����\",\"arrAirportNm\":\"����\",\"arrPlandTime\":202004110935,\"depAirportNm\":\"����\",\"depPlandTime\":202004110845,\"vihicleId\":\"LJ593\"},{\"airlineNm\":\"Ƽ�����װ�\",\"arrAirportNm\":\"����\",\"arrPlandTime\":202004111025,\"depAirportNm\":\"����\",\"depPlandTime\":202004110930,\"vihicleId\":\"TW901\"},{\"airlineNm\":\"�ƽþƳ��װ�\",\"arrAirportNm\":\"����\",\"arrPlandTime\":202004111045,\"depAirportNm\":\"����\",\"depPlandTime\":202004110955,\"economyCharge\":57900,\"prestigeCharge\":0,\"vihicleId\":\"OZ8141\"},{\"airlineNm\":\"�����װ�\",\"arrAirportNm\":\"����\",\"arrPlandTime\":202004111105,\"depAirportNm\":\"����\",\"depPlandTime\":202004111000,\"vihicleId\":\"7C601\"},{\"airlineNm\":\"���� �װ�\",\"arrAirportNm\":\"����\",\"arrPlandTime\":202004111115,\"depAirportNm\":\"����\",\"depPlandTime\":202004111010,\"economyCharge\":57900,\"prestigeCharge\":82900,\"vihicleId\":\"KE1901\"},{\"airlineNm\":\"Ƽ�����װ�\",\"arrAirportNm\":\"����\",\"arrPlandTime\":202004111255,\"depAirportNm\":\"����\",\"depPlandTime\":202004111210,\"vihicleId\":\"TW903\"},{\"airlineNm\":\"�ƽþƳ��װ�\",\"arrAirportNm\":\"����\",\"arrPlandTime\":202004111340,\"depAirportNm\":\"����\",\"depPlandTime\":202004111245,\"economyCharge\":57900,\"prestigeCharge\":0,\"vihicleId\":\"OZ8143\"},{\"airlineNm\":\"�ƽþƳ��װ�\",\"arrAirportNm\":\"����\",\"arrPlandTime\":202004111530,\"depAirportNm\":\"����\",\"depPlandTime\":202004111440,\"economyCharge\":57900,\"prestigeCharge\":0,\"vihicleId\":\"OZ8145\"},{\"airlineNm\":\"Ƽ�����װ�\",\"arrAirportNm\":\"����\",\"arrPlandTime\":202004111530,\"depAirportNm\":\"����\",\"depPlandTime\":202004111445,\"vihicleId\":\"TW905\"},{\"airlineNm\":\"�ƽþƳ��װ�\",\"arrAirportNm\":\"����\",\"arrPlandTime\":202004111855,\"depAirportNm\":\"����\",\"depPlandTime\":202004111800,\"economyCharge\":57900,\"prestigeCharge\":0,\"vihicleId\":\"OZ8147\"}]},\"numOfRows\":10,\"pageNo\":1,\"totalCount\":14}}}";
		Gson aa = new Gson();
		Json2 bk = aa.fromJson(bb, Json2.class);

		System.out.println(bk.response.body.items.item.get(2).airlineNm);
	}

}