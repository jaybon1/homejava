package simple;

import java.util.HashSet;
import java.util.Random;

public class Set {
	public static void main(String[] args) {

		HashSet<Integer> a = new HashSet<>();
		Random ran = new Random();
		

		while (a.size() < 6) {
			a.add(ran.nextInt(44) + 1);
		}
		
		
		System.out.println(a.toString());
		
		
	}
}
