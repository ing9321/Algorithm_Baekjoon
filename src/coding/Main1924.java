package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

// 2007년
public class Main1924 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1924.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int m = Integer.parseInt(line[0]);
		int d = Integer.parseInt(line[1]);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2007);
		cal.set(Calendar.MONTH, m-1);
		cal.set(Calendar.DATE, d);
		switch(cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			System.out.println("SUN");
			break;
		case 2:
			System.out.println("MON");
			break;
		case 3:
			System.out.println("TUE");
			break;
		case 4:
			System.out.println("WED");
			break;
		case 5:
			System.out.println("THU");
			break;
		case 6:
			System.out.println("FRI");
			break;
		case 7:
			System.out.println("SAT");
			break;
		}
	}

}
