package composite;

public class LotteriaApp {
	public static void main(String[] args) {
		// ����� ��Ʈ
		BigBurgerSet set1 = new BigBurgerSet();
		
		System.out.println();
		
		// �⺻����
		Burger burger1 = new Burger();
		
		System.out.println();
		
		// �ݶ�
		Coke coke1 = new Coke();
		
		System.out.println();
		
		
		// BigBurgerSet
		BigBurgerSet set2 = new BigBurgerSet(
				new BigBurger(3000, "���������"),
				new Coke(),
				new FrenchFried()	
				);
		
		System.out.println();
		
		BigBurgerSet set3 = new BigBurgerSet(
				new BigBurger(2000, "���������"),
				new Coke(),
				new FrenchFried()
				);
		
		
		System.out.println();
		
		
		// ������� ��Ʈ �߰���
		ShrimpBurgerSet set4 = new ShrimpBurgerSet();
		
		System.out.println();
		
		
		BigBurgerSet set5 = new BigBurgerSet(
				new BigBurger(2000, "���������")
				);
		
		
		System.out.println();
	}
}