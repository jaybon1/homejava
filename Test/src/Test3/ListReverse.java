package Test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListReverse {
	public static void main(String[] args) {
		List<String> test = new ArrayList<>();
		
		test.add("aa");
		test.add("bb");
		test.add("cc");
		Collections.reverse(test);
		
		System.out.println(test);
	}
}
