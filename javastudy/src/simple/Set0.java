package simple;

import java.util.HashSet;

public class Set0 {
	public static void main(String[] args) {
		
		HashSet<Integer> a = new HashSet<>();
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(2);
		
		System.out.println(a.toString());
		
	}
}
