package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2098 외판원 순회
 * https://www.acmicpc.net/problem/2098
 * Bitmask, DP
 */

public class Main2098 {
	public static int N;
	public static int[][] W, dp;
	public static final int MAX = 987654321;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2098.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		W = new int[N][N];
		dp = new int[N][1<<N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		
		System.out.println(dfs(0, 1));
	}
	
	public static int dfs(int node, int visit) {
		System.out.println(node + " " + visit);
		if(visit == (1 << N) -1) {
			if(W[node][0] != 0) {
				return W[node][0];
			}
			return MAX;
		}
		
		if(dp[node][visit] != -1) { // 방문 안했으면
			return dp[node][visit];
		}
		
		int ans = MAX;
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		for (int i = 0; i < N; i++) {
			if( (visit & (1<<i)) == 0 && W[node][i] > 0) {
				ans = Math.min(ans, dfs(i, visit | (1<<i)) + W[node][i]);
			}
		}
		
		return dp[node][visit] = ans;
	}

}
