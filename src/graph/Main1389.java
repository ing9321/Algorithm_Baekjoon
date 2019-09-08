package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1389 케빈 베이커의 6단계 법칙
 * https://www.acmicpc.net/problem/1389
 * bfs, dfs, 플로이드 와샬
 */
public class Main1389 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1389.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken().trim());
		int M = Integer.parseInt(st.nextToken().trim());
		int[][] matrix = new int[N+1][N+1];
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(matrix[i], 9999);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int s = Integer.parseInt(st.nextToken().trim());
			int t = Integer.parseInt(st.nextToken().trim());
			matrix[s][t] = 1;
			matrix[t][s] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if(j == k) continue;
					if(matrix[j][k] > matrix[j][i] + matrix[i][k]) {
						matrix[j][k] = matrix[j][i] + matrix[i][k];
					}
				}
			}
		}
		
		int min_person = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int tmp = 0;
			for (int j = 1; j <= N; j++) {
				if(i == j) continue;
				tmp += matrix[i][j];
			}
			if(min > tmp) {
				min = tmp;
				min_person = i;
			}
		}
		
		System.out.println(min_person);
	}

}
