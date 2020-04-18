package simple;

interface Callback { // 함수를 매개변수에 넘기기 위해 어쩔수 없이 만든 인터페이스
	void printmoney(int money);
}

class MoneyChange {
	int money = 10000;

	public void accept(Callback callback) {
		// 은행에 인출요청을해서 2만원을 받을 예정 2초
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					money = money + 20000;
					callback.printmoney(money);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}

public class Callback1 {
	public static void main(String[] args) {
		
		MoneyChange mc = new MoneyChange();
		
		Callback cb1 = new Callback() {
			
			@Override
			public void printmoney(int money) {
				System.out.println("통장 잔액 : " + money);
				
			}
		};
		
		// 다른 스레드에 함수를 넘긴것
		mc.accept(cb1);
		
		for (int i = 1; i < 6; i++) {
			System.out.println("메인쓰레드 : " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
