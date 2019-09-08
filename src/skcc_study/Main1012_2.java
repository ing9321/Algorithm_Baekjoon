package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1012 유기농 배추
 * https://www.acmicpc.net/problem/1012
 * dfs
 */

public class Main1012_2 {
	
	public static int M, N, K; // 가로, 세로, 배추
	public static int[][] map;
	public static boolean[][] visit;
	public static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1012.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			M = Integer.parseInt(st.nextToken().trim());
			N = Integer.parseInt(st.nextToken().trim());
			K = Integer.parseInt(st.nextToken().trim());
			map = new int[N][M];
			visit = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int c = Integer.parseInt(st.nextToken().trim());
				int r = Integer.parseInt(st.nextToken().trim());
				map[r][c] = 1;
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						cnt++;
						solve(i, j);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	public static void solve(int x, int y) {
		if(visit[x][y]) return;
		
		visit[x][y] = true;
		for (int i = 0; i < dir.length; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(map[nx][ny] == 1 && !visit[nx][ny]) {
				solve(nx, ny);
			}
		}
	}

}
