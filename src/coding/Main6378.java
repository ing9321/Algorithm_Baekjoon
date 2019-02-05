package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 디지털 루트 *1000자리*
public class Main6378 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6378.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		while(!str.equals("0")) {
			while(str.length() > 1) {
				str = droot(str);
			}
			System.out.println(str);
			str = br.readLine().trim();
		}
	}
	public static String droot(String num) {
		int sum = 0;
		for(int i=0, size=num.length(); i<size; i++) {
			sum += num.charAt(i)-'0';
		}
		return sum+"";
	}
}
