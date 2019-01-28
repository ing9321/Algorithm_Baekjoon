package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2583 {
	static int M, N;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2583.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(stn.nextToken().trim());
		N = Integer.parseInt(stn.nextToken().trim());
		map = new int[M][N];
		visit = new boolean[M][N];
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int K = Integer.parseInt(stn.nextToken().trim());
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			color(Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim()));
		}
		int C = 0;
		int cnt = 0;
		for(int r=0; r<M; r++) {
			for(int c=0; c<N; c++) {
				cnt = dfs(r,c);
				if(cnt > 0) {
					C++;
					arr.add(cnt);
				}
			}
		}
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int c : arr) {
			sb.append(c);
			sb.append(" ");
		}
		System.out.println(C);
		System.out.println(sb.toString());
	}
	
	public static void color(int x1, int y1, int x2, int y2) {
		for(int r=x1; r<x2; r++) {
			for(int c=y1; c<y2; c++) {
				map[c][r] = 1;
			}
		}
	}
	public static int dfs(int r, int c) {
		if(visit[r][c]) {
			return 0;
		}
		visit[r][c] = true;
		if(map[r][c] == 1) {
			return 0;
		}
		int cnt = 1;
		for(int k=0, size=pos.length; k<size; k++) {
			int nr = r + pos[k][0];
			int nc = c + pos[k][1];
			if(nc >= 0 && nr >= 0 && nr < M && nc < N && map[nr][nc] == 0 && !visit[nr][nc]) {
				cnt += dfs(nr, nc);
			}
		}
		return cnt;
	}
}
