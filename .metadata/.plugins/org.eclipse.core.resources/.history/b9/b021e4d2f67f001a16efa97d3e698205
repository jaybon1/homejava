package simple.coffee;

import java.util.ArrayList;

public class CoffeeApp {
	public static void main(String[] args) {

		// 바리스타, 손님
		Comsumer comsumer = new Comsumer();
		Barista barista = new Barista();
		

		// 메뉴 생성과 메뉴판 리스트에 자료를 넣는 것은 바리스타의 일이지만
		// 간략하게 하기위해서 메인에서 작성한다
		
		// 개별 메뉴 생성
		MenuItem m1 = new MenuItem("아메리카노", 1500);
		MenuItem m2 = new MenuItem("카페라떼", 2500);
		MenuItem m3 = new MenuItem("카푸치노", 4000);

		// 어레이 리스트에 자료 입력 .add
		ArrayList<MenuItem> menuItems = new ArrayList<>();
		menuItems.add(m1);
		menuItems.add(m2);
		menuItems.add(m3);

		// 어레이리스트 자료를 출력할때 .get
		System.out.println(menuItems.get(1).getName());
		System.out.println();
		
		
		// 메뉴 생성
		Menu menu = new Menu(menuItems);
		
		comsumer.주문("아메리카노", menu, barista);
	}
}
