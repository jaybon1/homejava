package simple.coffee;

import java.util.ArrayList;

import lombok.Data;

// 책임 : 메뉴 선택
@Data
public class Menu {

	// 메뉴 아이템들 (컬렉션)
	private ArrayList<MenuItem> menuItems;

	public Menu(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	
	// 메뉴판에 메뉴가 있는지 찾는 코드
	public MenuItem 메뉴선택(String menuName) {
		for (MenuItem menuItem : menuItems) { // foreach문은 : 뒤에 배열이 들어가고 배열의 길이만큼 돈다
			if (menuItem.getName().equals(menuName)) {
				
				// menuItems 리스트 안에 menuName와 같은 이름의 커피가 있다면 리턴
				//(리턴하면 함수를 빠져나간다)
				return menuItem;
			}
		}
		return null;
	}

}
