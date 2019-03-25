package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 11727 2xN 타일링 2
 * https://www.acmicpc.net/problem/11726
 * dp
 */
public class Main11727 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		br.close();
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
		}
		System.out.println(dp[N]);
	}
}