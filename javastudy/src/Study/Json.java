package Study;

import com.google.gson.Gson;

public class Json {

	public static void main(String[] args) {
		String bb = "{\"response\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL SERVICE.\"},\"body\":{\"items\":{\"item\":[{\"airlineNm\":\"진 에어\",\"arrAirportNm\":\"제주\",\"arrPlandTime\":202004110935,\"depAirportNm\":\"광주\",\"depPlandTime\":202004110845,\"vihicleId\":\"LJ593\"},{\"airlineNm\":\"티웨이항공\",\"arrAirportNm\":\"제주\",\"arrPlandTime\":202004111025,\"depAirportNm\":\"광주\",\"depPlandTime\":202004110930,\"vihicleId\":\"TW901\"},{\"airlineNm\":\"아시아나항공\",\"arrAirportNm\":\"제주\",\"arrPlandTime\":202004111045,\"depAirportNm\":\"광주\",\"depPlandTime\":202004110955,\"economyCharge\":57900,\"prestigeCharge\":0,\"vihicleId\":\"OZ8141\"},{\"airlineNm\":\"제주항공\",\"arrAirportNm\":\"제주\",\"arrPlandTime\":202004111105,\"depAirportNm\":\"광주\",\"depPlandTime\":202004111000,\"vihicleId\":\"7C601\"},{\"airlineNm\":\"대한 항공\",\"arrAirportNm\":\"제주\",\"arrPlandTime\":202004111115,\"depAirportNm\":\"광주\",\"depPlandTime\":202004111010,\"economyCharge\":57900,\"prestigeCharge\":82900,\"vihicleId\":\"KE1901\"},{\"airlineNm\":\"티웨이항공\",\"arrAirportNm\":\"제주\",\"arrPlandTime\":202004111255,\"depAirportNm\":\"광주\",\"depPlandTime\":202004111210,\"vihicleId\":\"TW903\"},{\"airlineNm\":\"아시아나항공\",\"arrAirportNm\":\"제주\",\"arrPlandTime\":202004111340,\"depAirportNm\":\"광주\",\"depPlandTime\":202004111245,\"economyCharge\":57900,\"prestigeCharge\":0,\"vihicleId\":\"OZ8143\"},{\"airlineNm\":\"아시아나항공\",\"arrAirportNm\":\"제주\",\"arrPlandTime\":202004111530,\"depAirportNm\":\"광주\",\"depPlandTime\":202004111440,\"economyCharge\":57900,\"prestigeCharge\":0,\"vihicleId\":\"OZ8145\"},{\"airlineNm\":\"티웨이항공\",\"arrAirportNm\":\"제주\",\"arrPlandTime\":202004111530,\"depAirportNm\":\"광주\",\"depPlandTime\":202004111445,\"vihicleId\":\"TW905\"},{\"airlineNm\":\"아시아나항공\",\"arrAirportNm\":\"제주\",\"arrPlandTime\":202004111855,\"depAirportNm\":\"광주\",\"depPlandTime\":202004111800,\"economyCharge\":57900,\"prestigeCharge\":0,\"vihicleId\":\"OZ8147\"}]},\"numOfRows\":10,\"pageNo\":1,\"totalCount\":14}}}";
		Gson aa = new Gson();
		Json2 bk = aa.fromJson(bb, Json2.class);

		System.out.println(bk.response.body.items.item.get(2).airlineNm);
	}

}
