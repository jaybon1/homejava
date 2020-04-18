package ch08;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Family {
	int ¼¥;
	String ¾Æ¹öÁö;
	String ¾î¸Ó´Ï;
}

public class JsonEx01 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		// fromJson() ÇÔ¼ö : json(String) => java object
		// toJson() ÇÔ¼ö : java object => json(String)

		Family a = new Family(3, "È«ÆÇ¼­", "Ãá¼¶");

		String personJson = gson.toJson(a);
		System.out.println(personJson);

	}
}
