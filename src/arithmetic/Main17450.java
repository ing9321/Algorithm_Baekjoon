package arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 17450 과자 사기
 * https://www.acmicpc.net/problem/17450
 */

public class Main17450 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double[] better = new double[3];
		for (int i = 0; i < 3; i++) {
			String[] strarr = br.readLine().trim().split(" ");
			int price = Integer.parseInt(strarr[0]) * 10;
			if(price >= 5000) price -= 500;
			int weight = Integer.parseInt(strarr[1]) * 10;
			better[i] = (double)(weight / price);
		}
		
		if(better[0] > Math.max(better[1], better[2])) {
			System.out.println("S");
		} else if(better[1] > Math.max(better[0], better[2])) {
			System.out.println("N");
		} else {
			System.out.println("U");
		}
	}

}
