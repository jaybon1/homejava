package Test3;

import java.awt.Frame;

import java.awt.Graphics;

import java.awt.Image;

import java.awt.Toolkit;

public class MyFrame extends Frame {
	public static void main(String[] args) {
		new MyFrame();
	}

	private Image img;

	public MyFrame() {

		Toolkit tk = Toolkit.getDefaultToolkit();

		img = tk.getImage("img/back1.jpg");
		setSize(500, 500);
		
		setVisible(true);

	}

	public void paint(Graphics g) {

		super.paint(g);

		int offy = 0;

		try {

			for (int i = 0; i < 500; i++)

			{

				g.drawImage(img, 10, 10, 510, 60, 0, 0, 500, 50 + offy, this);

				Thread.sleep(200);

				offy += 10;

			}

		}

		catch (InterruptedException e)

		{

			e.printStackTrace();

		}

	}

}
