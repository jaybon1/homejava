package Test3;

import java.awt.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cookie {
	
	private Image image; // 쿠키 이미지
	
	// 쿠키의 좌표와 넓이 높이
	private int x;
	private int y;
	private int width;
	private int height;
	
	// 쿠키의 투명도
	private int alpha;
	
	// 쿠키의 체력
	private int health;
	
	// 쿠키의 상태 (거대화와 가속화 미구현)
	private int invincible; // 무적 남은 시간
	private int big; // 거대화 남은 시간
	private int fast; // 가속화 남은 시간
	private int jumpCount; // 점프 횟수
	private boolean fall; // 낙하 여부
	private boolean jump; // 점프 여부
}
