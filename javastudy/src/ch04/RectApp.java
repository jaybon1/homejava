package ch04;

import java.util.Scanner;


class Rectangle {
	private int width;
	private int height;

	public int getArea() {
		return width * height;
	}
	
	void setHeight(int height ) {
		this.height = height;
	}
	
	void setWidth(int width) {
		this.width = width;
	}
}

public class RectApp {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		Scanner sc = new Scanner(System.in);
		System.out.print(">> ");
		rectangle.setWidth(sc.nextInt());
		rectangle.setHeight(sc.nextInt());

//		rectangle.setWidth(sc.nextInt());
//		rectangle.setHeight(sc.nextInt());
		System.out.println("사각형의 면적은 : " + rectangle.getArea());
		sc.close();
	}
}
