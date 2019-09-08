package skcc_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 6378 디지털루트
 * https://www.acmicpc.net/problem/6378
 */
public class Main6378_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine().trim();
		while(!N.equals("0")) {
			
			while(N.length() > 1) {
				N =solve(N);
			}
			System.out.println(N);
			
			N = br.readLine().trim();
		}
	}
	public static String solve(String N) {
		int tmp = 0;
		for (char c : N.toCharArray()) {
			tmp += (c - '0');
		}
		return tmp + "";
	}
}
