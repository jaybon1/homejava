package ch13;

// OS는 Runnable타입의 heap공간에 run메서드를 호출해야된다는 걸 이미 알고 있음
class Sub implements Runnable { // 러너블타입만이 OS가 힙의 메서드를 찾을 수 있다

	String data = "값 없음";

	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println("서브 쓰레드 : " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		data = "안녕";
	}
}

public class ThreadEx01 {

	// 메인 쓰레드
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Sub()); // 힙이 뜨고 안의 메서드를 찾고 OS가 해당 메서드를 실행
		t1.start();

		for (int i = 1; i < 6; i++) {
			System.out.println("메인 쓰레드 : " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
