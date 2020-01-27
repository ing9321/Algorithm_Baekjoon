package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 17069 파이프 옮기기 2
 * https://www.acmicpc.net/problem/17069
 * DP
 */

public class Main17069 {
	public static int N;
	public static int[][] map;
	public static long[][][] dp;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17069.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N+2][N+2];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		
		dp = new long[3][N+2][N+2];
		dp[0][1][2] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j+1] == 0) { // 가로 가능
					dp[0][i][j+1] += (dp[0][i][j] + dp[2][i][j]);
				}
				if(map[i+1][j] == 0) { // 세로 가능
					dp[1][i+1][j] += (dp[1][i][j] + dp[2][i][j]);
				}
				if(map[i+1][j+1] == 0 && map[i][j+1] == 0 && map[i+1][j] == 0) { // 대각선 가능
					dp[2][i+1][j+1] += (dp[0][i][j] + dp[1][i][j] + dp[2][i][j]);
				}
			}
		}
		
		System.out.println((dp[0][N][N] + dp[1][N][N] + dp[2][N][N]));
	}
}
