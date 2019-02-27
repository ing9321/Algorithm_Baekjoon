package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 효율적인 해킹 : 한 번에 가장 많은 해킹
public class Main1325 {
	static int N, M, MAX;
	static int[][] matrix;
	static int[] com;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1325.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		matrix = new int[N+1][N+1];
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// A가 B르 신뢰하면 B를 해킹할 때 A도 해킹
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[b][a] = 1;
		}
		
		for (int i = 0; i <= N; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		com = new int[N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i != j && matrix[i][j] != 0) {
					com[i]++;
					com[j]++;
				}
			}
		}
		System.out.println(Arrays.toString(com));
	}
	private static void dfs(int x, int y) {
	}
}
