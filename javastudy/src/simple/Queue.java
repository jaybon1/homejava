package simple;

import java.util.LinkedList;


public class Queue {
	public static void main(String[] args) {
		java.util.Queue<Integer> a = new LinkedList<>();
		
		a.offer(5);
		a.offer(4);
		a.offer(3);
		a.offer(1);
		a.offer(1);
		
		System.out.println(a.toString());
		
		a.poll();
		a.poll();
		
		System.out.println(a.toString());
		
	}
}
