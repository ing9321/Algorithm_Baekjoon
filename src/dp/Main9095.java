package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 미해결
 * 9095 1, 2, 3 더하기
 * https://www.acmicpc.net/problem/9095
 * dp
 */
public class Main9095 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input9095.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] dp = new int[N+1];
			
			for (int i = 1; i <= 3; i++) {
				for (int j = 0; j <= N; j++) {
					
				}
			}
		}
	}

}
