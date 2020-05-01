package Test3;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;

import javax.imageio.ImageIO;

public class Bf {
	
	static int[][] getPic(String src) throws Exception{
		File imgf = new File(src);
		BufferedImage img = ImageIO.read(imgf);
		int width = img.getWidth();
		int height = img.getHeight();
		int[] pixels=new int[width*height];
		PixelGrabber grab = new PixelGrabber(img, 0, 0, width, height, pixels, 0,width);
		grab.grabPixels();
		
		int[][] picture=new int[width][height];
		for(int i=0;i<pixels.length;i++)
		      picture[i%width][i/width]=pixels[i] + 16777216;
		return picture;
	}
	
	public static void main(String[] args) {
        int x = 10;
        int y = 21;
        try {
        	System.out.printf("이미지 픽셀 좌표 X:%d  Y:%d의 색값은 ", x, y);
			System.out.println(getPic("img/testbf.png")[x][y]);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
}
