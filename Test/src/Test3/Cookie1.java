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
	
	
	// ��� �̹���
	private ImageIcon backIc = new ImageIcon("����̹���1"); // ���� �� ���
	private ImageIcon secondBackIc = new ImageIcon("����̹���2"); // 2��° ���

	
	// ��Ű �̹��� �����ܵ�
	private ImageIcon cookieIc = new ImageIcon("testimg/cookieTest.png"); // �⺻���
	private ImageIcon jumpIc = new ImageIcon("testimg/jumpTest.png"); // �������
	private ImageIcon doubleJumpIc = new ImageIcon("testimg/doubleJumpTest.png"); // �����������
	private ImageIcon fallIc = new ImageIcon("testimg/fallTest.png"); // ���ϸ��(���� ���� ��)
	
	
	// ���� �̹��� �����ܵ�
	private ImageIcon jellyIc = new ImageIcon("testimg/jellyTest.png");
	private ImageIcon jellyEffectIc = new ImageIcon("testimg/effectTest.png");
	
	
	// ���� �̹��� �����ܵ�
	private ImageIcon field1Ic = new ImageIcon("testimg/footTest.png"); // ����
	private ImageIcon field2Ic = new ImageIcon("testimg/footTest2.png"); //���߹���
	
	
	// ��ֹ� �̹��� �����ܵ�
	private ImageIcon tacle10Ic = new ImageIcon("testimg/tacleTest10.png"); // 1ĭ ��ֹ�
	private ImageIcon tacle20Ic = new ImageIcon("testimg/tacleTest20.png"); // 2ĭ ��ֹ�
	private ImageIcon tacle35Ic = new ImageIcon("testimg/tacleTest35.png");	// 3.5ĭ ��ֹ�
	
	
	// ����Ʈ ����
	private List<Jelly> jellyList = new ArrayList<>(); // ���� ����Ʈ

	private List<Field> fieldList = new ArrayList<>(); // ���� ����Ʈ

	private List<Tacle> tacleList = new ArrayList<>(); // ��ֹ� ����Ʈ
	
	private int gameSpeed = 3; // ���� �ӵ�
	
	private int nowField = 2000; // ������ ���̸� ����.
	
	private boolean downKeyOn = false; // �ٿ�Ű �������� ����
	
	// �̹��� ���Ϸ� �� ���� �����´�.
	private int[] sizeArr; // �̹����� ���̿� ���̸� �������� 1���� �迭
	private int[][] colorArr; // �̹����� x y ��ǥ�� �ȼ� ������ �����ϴ� 2�����迭
	
	
	private Image buffImage; // ������� �̹���
	private Graphics buffg; // ������� g
	
	
	private AlphaComposite alphaComposite; // ���� ���� ��ü ����

	
	class MyPanel extends JPanel{
		
		public MyPanel() {
			
			setFocusable(true);
			
			// ��Ű ����   /  x���� 240 y���� -80  ���̿� ���̴� 80 , ������ 255(������)�̴�.
			Cookie c1 = new Cookie(cookieIc.getImage(), 240, -80, 80, 80, 255, 0);
			
			
			// ��Ű��  x���� ���̸� ���� ��
			int body = c1.getX() + c1.getWidth();
			
			// ��Ű�� �߹� ��ġ /  ��Ű�� y���� ���̸� ���� ���̴�.
			int foot = c1.getY() + c1.getHeight();
			
			
			// ���1-1 ����
			Back b1 = new Back(backIc.getImage(), 
					0,  
					75, // y �� (���� �ʿ�)
					backIc.getImage().getWidth(null),
					backIc.getImage().getHeight(null));
			
			// ���1-2 ����
			Back b2 = new Back(backIc.getImage(), 
					0, 
					backIc.getIconWidth(), // y �� (���� �ʿ�)
					backIc.getImage().getWidth(null),
					backIc.getImage().getHeight(null));

			
			// �� ���� �ҷ�����
			try {
				sizeArr = Util.getSize("img/firstMap.png"); // �� ����� �迭�� ����
				colorArr = Util.getPic("img/firstMap.png"); // �� �ȼ����� �迭�� ����
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			int maxX = sizeArr[0]; // ���� ����
			int maxY = sizeArr[1]; // ���� ����
			
			for (int i = 0; i < maxX; i += 1) { // ������ 1ĭ�� �����ϱ� ������ 1,1������� �ݺ����� ������.
				for (int j = 0; j < maxY; j += 1) {
					if (colorArr[i][j] == 16776960) { // ������ 16776960�� ��� (�����)
						// ��ǥ�� 40�� ���ϰ�, ���̿� ���̴� 30���� �Ѵ�.
						jellyList.add(new Jelly(jellyIc.getImage(), i * 40, j * 40, 30, 30, 0));
					}
				}
			}
			
			for (int i = 0; i < maxX; i += 2) { // ������ 4ĭ�� �����ϴ� �����̱� ������ 2,2������� �ݺ����� ������.
				for (int j = 0; j < maxY; j += 2) {
					if (colorArr[i][j] == 0) { // ������ 0 �ϰ�� (������)
						// ��ǥ�� 40�� ���ϰ�, ���̿� ���̴� 80���� �Ѵ�.
						fieldList.add(new Field(field1Ic.getImage(), i * 40, j * 40, 80, 80));
					}
				}
			}

			for (int i = 0; i < maxX; i += 2) { // ��ֹ��� 4ĭ �̻��� �����Ѵ�. ���� ����
				for (int j = 0; j < maxY; j += 2) {
					if (colorArr[i][j] == 16711680) { // ������ 16711680�� ��� (������)
						// ��ǥ�� 40�� ���ϰ�, ���̿� ���̴� 30���� �Ѵ�.
						tacleList.add(new Tacle(tacle10Ic.getImage(), i * 40, j * 40, 80, 80, 0)); 
					}
				}
			}
			
			
			// repaint ���� �ݺ� ������
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
					
					
					if (b1.getX() < -(b1.getWidth()-1)) { // ���1-1 �� -(������)���� ������, �� ȭ������� ��γ����� ��� 1-2�ڿ� ����
						b1.setX(b1.getWidth());
					}
					if (b2.getX() < -(b2.getWidth()-1)) { // ���1-2 �� -(������)���� ������, �� ȭ������� ��γ����� ��� 1-1�ڿ� ����
						b2.setX(b2.getWidth());
					}
					
					// ����� x��ǥ�� -1 ���ش� (�������� �帣�� ȿ��)
					b1.setX(b1.getX()-1); 
					b2.setX(b2.getX()-1);
					
					
					// ������ġ�� -4 �� ���ش�. (�������� �帣�� ȿ��)
					for (int i = 0; i < fieldList.size(); i++) {
						
						Field tempField = fieldList.get(i); // �ӽ� ������ ����Ʈ �ȿ� �ִ� ���� ������ �ҷ�����
						
						if(tempField.getX() < -90) { // ������  x��ǥ�� -90 �̸��̸� �ش� ������ �����Ѵ�.(����ȭ)
							
							fieldList.remove(tempField);
							
						} else {
							
							tempField.setX(tempField.getX() - 4);  // �� ���ǿ� �ش��� �ȵǸ� x��ǥ�� -4�� ������
							
						}
					}
					
					// ������ġ�� -4 �� ���ش�.
					for (int i = 0; i < jellyList.size(); i++) {
						
						Jelly tempJelly = jellyList.get(i); // �ӽ� ������ ����Ʈ �ȿ� �ִ� ���� ������ �ҷ�����
						
						if(tempJelly.getX() < -90) { // ������ x ��ǥ�� -90 �̸��̸� �ش� ������ �����Ѵ�.(����ȭ)
							
							fieldList.remove(tempJelly);
							
						} else {
							
							tempJelly.setX(tempJelly.getX() - 4); // �� ���ǿ� �ش��� �ȵǸ� x��ǥ�� -4�� ������
							
							 
							if( // ĳ������ ���� �ȿ� ������ ������ �������� �Դ´�.
							tempJelly.getX() > c1.getX()
							&& tempJelly.getX() < body
							&& tempJelly.getY() > c1.getY()
							&& tempJelly.getY() < foot) {
								
								tempJelly.setImage(jellyEffectIc.getImage()); // ������ �̹����� ����Ʈ�� �ٲ۴�
								
							}
						}
					}
					
					// ��ֹ���ġ�� - 4 �� ���ش�.
					for (int i = 0; i < tacleList.size(); i++) {
						
						Tacle tempTacle = tacleList.get(i); // �ӽ� ������ ����Ʈ �ȿ� �ִ� ���� ��ֹ��� �ҷ�����
						
						if(tempTacle.getX() < -90) { 
							
							fieldList.remove(tempTacle); // ��ֹ��� x ��ǥ�� -90 �̸��̸� �ش� ������ �����Ѵ�.(����ȭ)
							
						} else {
							
							tempTacle.setX(tempTacle.getX() - 4);	// �� ���ǿ� �ش��� �ȵǸ� x��ǥ�� -4�� ������
							
							if( // �������°� �ƴϰ� ĳ������ ���� �ȿ� ��ֹ��� ������ �ε�����
							!invincible
							&& tempTacle.getX() > c1.getX()
							&& tempTacle.getX() < body
							&& tempTacle.getY() > c1.getY()
							&& tempTacle.getY() < foot) {
								
								invincible = true; // �������·� ��ȯ		
								
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
										System.out.println("��������");
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