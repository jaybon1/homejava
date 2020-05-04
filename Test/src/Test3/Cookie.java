package Test3;

import java.awt.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cookie {
	
	private Image image; // ��Ű �̹���
	
	// ��Ű�� ��ǥ�� ���� ����
	private int x;
	private int y;
	private int width;
	private int height;
	
	// ��Ű�� ����
	private int alpha;
	
	// ��Ű�� ü��
	private int health;
	
	// ��Ű�� ���� (�Ŵ�ȭ�� ����ȭ �̱���)
	private int invincible; // ���� ���� �ð�
	private int big; // �Ŵ�ȭ ���� �ð�
	private int fast; // ����ȭ ���� �ð�
	private int jumpCount; // ���� Ƚ��
	private boolean fall; // ���� ����
	private boolean jump; // ���� ����
}
