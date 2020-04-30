package test2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
	String stair2 = "00000000000000111111111000";
	String stair1 = "00000011111111000000000000";
	String field =  "11111111000000111111000111";
	int fieldY = 400;
	int stair1Y = 350;
	
//	public static void main(String[] args) {
//		Field a= new Field();
//		
//		System.out.println(a.field.charAt(3));
//		System.out.println(a.field.length());
//	}
}
