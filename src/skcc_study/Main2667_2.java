package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 2667 단지번호 붙이기
 * https://www.acmicpc.net/problem/2667
 * dfs
 */

public class Main2667_2 {
	public static int N;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2667.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				if(map[i][j] > 0 && !visit[i][j]) {
					visit[i][j] = true;
					cnt = dfs(i, j);
				}
				if(cnt > 0) list.add(cnt);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (Integer i : list) {
			System.out.println(i);
		}
	}

	public static int dfs(int r, int c) {
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(map[nr][nc] > 0 && !visit[nr][nc]) {
				visit[nr][nc] = true;
				cnt += dfs(nr, nc);
			}
		}
		return cnt;
	}
}
