package simple.coffee;

import java.util.ArrayList;

import lombok.Data;

// å�� : �޴� ����
@Data
public class Menu {

	// �޴� �����۵� (�÷���)
	private ArrayList<MenuItem> menuItems;

	public Menu(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	
	// �޴��ǿ� �޴��� �ִ��� ã�� �ڵ�
	public MenuItem �޴�����(String menuName) {
		for (MenuItem menuItem : menuItems) { // foreach���� : �ڿ� �迭�� ���� �迭�� ���̸�ŭ ����
			if (menuItem.getName().equals(menuName)) {
				
				// menuItems ����Ʈ �ȿ� menuName�� ���� �̸��� Ŀ�ǰ� �ִٸ� ����
				//(�����ϸ� �Լ��� ����������)
				return menuItem;
			}
		}
		return null;
	}

}