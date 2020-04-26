package slug;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Test1 {
	public static void main(String[] args) {
		//System.out.println(LocalDateTime.now());
		
		long a = Timestamp.valueOf(LocalDateTime.now()).getTime();
	}
}
