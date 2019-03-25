package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 2667 단지번호붙이기
 * https://www.acmicpc.net/problem/2667
 * dfs (DFS or BFS)
 */
public class Main2667 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = {{0,1}, {1,0}, {0, -1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2667.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine().trim();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		ArrayList<Integer> danjis = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int danji = dfs(i,j);
				if(danji > 0) {
					danjis.add(danji);
				}
			}
		}
		System.out.println(danjis.size());
		Collections.sort(danjis);
		for(int d : danjis) {
			System.out.println(d);
		}
		
	}
	public static int dfs(int x, int y) {
		int cnt = 0;
		if(map[x][y] > 0 && !visit[x][y]) {
			visit[x][y] = true;
			cnt++;
			for(int k=0, size=pos.length; k<size; k++) {
				int nx = x + pos[k][0];
				int ny = y + pos[k][1];
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] > 0 && !visit[nx][ny]) {
					cnt += dfs(nx, ny);
				}
			}
		}
		return cnt;
	}
}
