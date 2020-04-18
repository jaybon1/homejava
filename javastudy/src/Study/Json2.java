package Study;

import java.util.List;

public class Json2 {

	public Response response;

}

class Body {

	public Items items;
	public long numOfRows;
	public long pageNo;
	public long totalCount;

}

class Header {

	public String resultCode;
	public String resultMsg;

}

class Item {

	public String airlineNm;
	public String arrAirportNm;
	public long arrPlandTime;
	public String depAirportNm;
	public long depPlandTime;
	public String vihicleId;
	public long economyCharge;
	public long prestigeCharge;
}

class Items {

	public List<Item> item = null;

}

class Response {

	public Header header;
	public Body body;

}
