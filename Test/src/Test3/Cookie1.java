package Test3;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;

public class Cookie1 {

	private JFrame frame;
	
	
	// 배경 이미지
	private ImageIcon backIc = new ImageIcon("배경이미지1"); // 제일 뒷 배경
	private ImageIcon secondBackIc = new ImageIcon("배경이미지2"); // 2번째 배경

	
	// 쿠키 이미지 아이콘들
	private ImageIcon cookieIc = new ImageIcon("testimg/cookieTest.png"); // 기본모션
	private ImageIcon jumpIc = new ImageIcon("testimg/jumpTest.png"); // 점프모션
	private ImageIcon doubleJumpIc = new ImageIcon("testimg/doubleJumpTest.png"); // 더블점프모션
	private ImageIcon fallIc = new ImageIcon("testimg/fallTest.png"); // 낙하모션(더블 점프 후)
	
	
	// 젤리 이미지 아이콘들
	private ImageIcon jellyIc = new ImageIcon("testimg/jellyTest.png");
	private ImageIcon jellyEffectIc = new ImageIcon("testimg/effectTest.png");
	
	
	// 발판 이미지 아이콘들
	private ImageIcon field1Ic = new ImageIcon("testimg/footTest.png"); // 발판
	private ImageIcon field2Ic = new ImageIcon("testimg/footTest2.png"); //공중발판
	
	
	// 장애물 이미지 아이콘들
	private ImageIcon tacle10Ic = new ImageIcon("testimg/tacleTest10.png"); // 1칸 장애물
	private ImageIcon tacle20Ic = new ImageIcon("testimg/tacleTest20.png"); // 2칸 장애물
	private ImageIcon tacle35Ic = new ImageIcon("testimg/tacleTest35.png");	// 3.5칸 장애물
	
	
	// 리스트 생성
	private List<Jelly> jellyList = new ArrayList<>(); // 젤리 리스트

	private List<Field> fieldList = new ArrayList<>(); // 발판 리스트

	private List<Tacle> tacleList = new ArrayList<>(); // 장애물 리스트
	
	private int gameSpeed = 3; // 게임 속도
	
	private int nowField = 2000; // 발판의 높이를 저장.
	
	private boolean downKeyOn = false; // 다운키 눌렀는지 여부
	
	// 이미지 파일로 된 맵을 가져온다.
	private int[] sizeArr; // 이미지의 넓이와 높이를 가져오는 1차원 배열
	private int[][] colorArr; // 이미지의 x y 좌표의 픽셀 색값을 저장하는 2차원배열
	
	
	private Image buffImage; // 더블버퍼 이미지
	private Graphics buffg; // 더블버퍼 g
	
	
	private AlphaComposite alphaComposite; // 투명도 관련 객체 저장

	
	class MyPanel extends JPanel{
		
		public MyPanel() {
			
			setFocusable(true);
			
			// 쿠키 생성   /  x값은 240 y값은 -80  넓이와 높이는 80 , 투명도는 255(불투명)이다.
			Cookie c1 = new Cookie(cookieIc.getImage(), 240, -80, 80, 80, 255, 0);
			
			
			// 쿠키의  x값과 높이를 더한 값
			int body = c1.getX() + c1.getWidth();
			
			// 쿠키의 발밑 위치 /  쿠키의 y값과 높이를 더한 값이다.
			int foot = c1.getY() + c1.getHeight();
			
			
			// 배경1-1 생성
			Back b1 = new Back(backIc.getImage(), 
					0,  
					75, // y 값 (조정 필요)
					backIc.getImage().getWidth(null),
					backIc.getImage().getHeight(null));
			
			// 배경1-2 생성
			Back b2 = new Back(backIc.getImage(), 
					0, 
					backIc.getIconWidth(), // y 값 (조정 필요)
					backIc.getImage().getWidth(null),
					backIc.getImage().getHeight(null));

			
			// 맵 정보 불러오기
			try {
				sizeArr = Util.getSize("img/firstMap.png"); // 맵 사이즈를 배열에 저장
				colorArr = Util.getPic("img/firstMap.png"); // 맵 픽셀값을 배열에 저장
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			int maxX = sizeArr[0]; // 맵의 넓이
			int maxY = sizeArr[1]; // 맵의 높이
			
			for (int i = 0; i < maxX; i += 1) { // 젤리는 1칸을 차지하기 때문에 1,1사이즈로 반복문을 돌린다.
				for (int j = 0; j < maxY; j += 1) {
					if (colorArr[i][j] == 16776960) { // 색값이 16776960일 경우 (노란색)
						// 좌표에 40을 곱하고, 넓이와 높이는 30으로 한다.
						jellyList.add(new Jelly(jellyIc.getImage(), i * 40, j * 40, 30, 30, 0));
					}
				}
			}
			
			for (int i = 0; i < maxX; i += 2) { // 발판은 4칸을 차지하는 공간이기 때문에 2,2사이즈로 반복문을 돌린다.
				for (int j = 0; j < maxY; j += 2) {
					if (colorArr[i][j] == 0) { // 색값이 0 일경우 (검은색)
						// 좌표에 40을 곱하고, 넓이와 높이는 80으로 한다.
						fieldList.add(new Field(field1Ic.getImage(), i * 40, j * 40, 80, 80));
					}
				}
			}

			for (int i = 0; i < maxX; i += 2) { // 장애물은 4칸 이상을 차지한다. 추후 수정
				for (int j = 0; j < maxY; j += 2) {
					if (colorArr[i][j] == 16711680) { // 색값이 16711680일 경우 (빨간색)
						// 좌표에 40을 곱하고, 넓이와 높이는 30으로 한다.
						tacleList.add(new Tacle(tacle10Ic.getImage(), i * 40, j * 40, 80, 80, 0)); 
					}
				}
			}
			
			
			// repaint 무한 반복 쓰레드
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						repaint();
						try {
							Thread.sleep(10);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
			
			
			// 
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					
					if (b1.getX() < -(b1.getWidth()-1)) { // 배경1-1 이 -(배경넓이)보다 작으면, 즉 화면밖으로 모두나가면 배경 1-2뒤에 붙음
						b1.setX(b1.getWidth());
					}
					if (b2.getX() < -(b2.getWidth()-1)) { // 배경1-2 가 -(배경넓이)보다 작으면, 즉 화면밖으로 모두나가면 배경 1-1뒤에 붙음
						b2.setX(b2.getWidth());
					}
					
					// 배경의 x좌표를 -1 해준다 (왼쪽으로 흐르는 효과)
					b1.setX(b1.getX()-1); 
					b2.setX(b2.getX()-1);
					
					
					// 발판위치를 -4 씩 해준다. (왼쪽으로 흐르는 효과)
					for (int i = 0; i < fieldList.size(); i++) {
						
						Field tempField = fieldList.get(i); // 임시 변수에 리스트 안에 있는 개별 발판을 불러오자
						
						if(tempField.getX() < -90) { // 발판의  x좌표가 -90 미만이면 해당 발판을 제거한다.(최적화)
							
							fieldList.remove(tempField);
							
						} else {
							
							tempField.setX(tempField.getX() - 4);  // 위 조건에 해당이 안되면 x좌표를 -4씩 줄이자
							
						}
					}
					
					// 젤리위치를 -4 씩 해준다.
					for (int i = 0; i < jellyList.size(); i++) {
						
						Jelly tempJelly = jellyList.get(i); // 임시 변수에 리스트 안에 있는 개별 젤리를 불러오자
						
						if(tempJelly.getX() < -90) { // 젤리의 x 좌표가 -90 미만이면 해당 젤리를 제거한다.(최적화)
							
							fieldList.remove(tempJelly);
							
						} else {
							
							tempJelly.setX(tempJelly.getX() - 4); // 위 조건에 해당이 안되면 x좌표를 -4씩 줄이자
							
							 
							if( // 캐릭터의 범위 안에 젤리가 있으면 아이템을 먹는다.
							tempJelly.getX() > c1.getX()
							&& tempJelly.getX() < body
							&& tempJelly.getY() > c1.getY()
							&& tempJelly.getY() < foot) {
								
								tempJelly.setImage(jellyEffectIc.getImage()); // 젤리의 이미지를 이펙트로 바꾼다
								
							}
						}
					}
					
					// 장애물위치를 - 4 씩 해준다.
					for (int i = 0; i < tacleList.size(); i++) {
						
						Tacle tempTacle = tacleList.get(i); // 임시 변수에 리스트 안에 있는 개별 장애물을 불러오자
						
						if(tempTacle.getX() < -90) { 
							
							fieldList.remove(tempTacle); // 장애물의 x 좌표가 -90 미만이면 해당 젤리를 제거한다.(최적화)
							
						} else {
							
							tempTacle.setX(tempTacle.getX() - 4);	// 위 조건에 해당이 안되면 x좌표를 -4씩 줄이자
							
							if( // 무적상태가 아니고 캐릭터의 범위 안에 장애물이 있으면 부딛힌다
							!invincible
							&& tempTacle.getX() > c1.getX()
							&& tempTacle.getX() < body
							&& tempTacle.getY() > c1.getY()
							&& tempTacle.getY() < foot) {
								
								invincible = true; // 무적상태로 전환		
								
								new Thread(new Runnable() {
									
									@Override
									public void run() {
										
										img = ichit.getImage();
										
										cookieAlpha = 80;
										try {
											Thread.sleep(500);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
										img = ic.getImage();
										
										
										for (int j = 0; j < 11; j++) {
											if(cookieAlpha == 80) {
												cookieAlpha = 160;
											} else {
												cookieAlpha = 80;
											}
											try {
												Thread.sleep(250);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										}
										cookieAlpha = 255;
										
										
										invincible = false;
										System.out.println("무적종료");
									}
								}).start();
							}
						}
					}

				}
			}).start();
			
			
			
			
			
			
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			
		}
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cookie1 window = new Cookie1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cookie1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800,480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}
}