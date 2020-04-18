package simple.composite;

public class LotteriaApp {
	public static void main(String[] args) {
		// 빅버거 세트
		BigBurgerSet set1 = new BigBurgerSet();
		
		System.out.println();
		
		// 기본버거
		Burger burger1 = new Burger();
		
		System.out.println();
		
		// 콜라
		Coke coke1 = new Coke();
		
		System.out.println();
		
		
		// BigBurgerSet
		BigBurgerSet set2 = new BigBurgerSet(
				new BigBurger(3000, "빅버거할인"),
				new Coke(),
				new FrenchFried()	
				);
		
		System.out.println();
		
		BigBurgerSet set3 = new BigBurgerSet(
				new BigBurger(2000, "빅버거할인"),
				new Coke(),
				new FrenchFried()
				);
		
		
		System.out.println();
		
		
		// 새우버거 세트 추가요
		ShrimpBurgerSet set4 = new ShrimpBurgerSet();
		
		System.out.println();
		
		
		BigBurgerSet set5 = new BigBurgerSet(
				new BigBurger(2000, "빅버거할인")
				);
		
		
		System.out.println();
	}
}
