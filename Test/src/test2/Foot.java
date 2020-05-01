package test2;

import java.awt.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foot {
	Image image;
	int type;
	int x;
	int y;
	int width;
	int height;
}
