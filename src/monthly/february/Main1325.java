package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		
		for (int i = 0; i <= N; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		com = new int[N+1];
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		
	}
	private static void bfs(int i) {
		System.out.println("bfs : " + i);
		int max = 0;
		for (int j = 1; j <= N; j++) {
			if(matrix[i][j] != 0) {
				visited = new boolean[N+1];
				visited[i] = true;
				System.out.println(dfs(i, j, 1));
				max = Math.max(max, dfs(i, j, 1));
			}
		}
		com[i] = max;
	}
	private static int dfs(int i, int j, int cnt) {
		System.out.println("dfs : " + i + " " + j + " " + cnt);
		int c = 0;
		if(matrix[i][j] == 0) {
			return cnt;
		}
		visited[j] = true;
		for (int k = 1; k <= N; k++) {
			if(!visited[k] && matrix[j][k] == 1) {
				c += dfs(j, k, cnt+1);
			}
		}
		return c;
	}
}
