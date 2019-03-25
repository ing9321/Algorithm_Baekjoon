package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 2458 키 순서
 * https://www.acmicpc.net/problem/2458
 * 플로이드 와샬
 */
public class Main2458 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strarr = br.readLine().split(" ");
		int N = Integer.parseInt(strarr[0]);
		int M = Integer.parseInt(strarr[1]);
		
		boolean[][] map = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			strarr = br.readLine().split(" ");
			map[Integer.parseInt(strarr[0])][Integer.parseInt(strarr[1])] = true;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i == j) continue;
					if(map[i][k] && map[k][j]) map[i][j] = true;
				}
			}
		}
		
		int A = 0;
		for (int i = 1; i <= N; i++) {
			int temp = 1;
			for (int j = 1; j <= N; j++) {
				if(map[i][j]) temp++;
				if(map[j][i]) temp++;
			}
			if(temp == N) A++;
		}
		
		System.out.println(A);
	}
}
