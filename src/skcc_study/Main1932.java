package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 1932 정수삼각형
 * https://www.acmicpc.net/problem/1932
 * DP
 */

public class Main1932 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1932.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int MAX = 0;
		int[][] dp = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			String[] arr = br.readLine().trim().split(" ");
			for (int j = 1; j <= i; j++) {
				dp[i][j] = Integer.parseInt(arr[j-1]);
				if(j == 1) {
					dp[i][j] += dp[i-1][j];
				} else if(j == i) {
					dp[i][j] += dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + dp[i][j];
				}
				MAX = Math.max(MAX, dp[i][j]);
			}
		}
		System.out.println(MAX);
	}

}
