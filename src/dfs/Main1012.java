package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main1012 {
	static int T, M, N, K;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1; test_case<=T; test_case++) {
			String[] strarr = br.readLine().trim().split(" ");
			M = Integer.parseInt(strarr[0]); // 가로길이
			N = Integer.parseInt(strarr[1]); // 세로길이
			K = Integer.parseInt(strarr[2]); // 배추위치갯수
			map = new int[N][M];
			visit = new boolean[N][M];
			for(int i=0; i<K; i++) {
				String[] sarr = br.readLine().trim().split(" ");
				int c = Integer.parseInt(sarr[0]);
				int r = Integer.parseInt(sarr[1]);
				map[r][c] = 1;
			}
			
			int cnt = 0;
			for(int c=0; c<N; c++) {
				for(int r=0; r<M; r++) {
					if(dfs(c, r) > 0) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static int dfs(int c, int r) {
		if(visit[c][r]) {
			return 0;
		}
		visit[c][r] = true;
		if(map[c][r] == 0) {
			return 0;
		}
		int cnt = 1;
		for(int k=0, size=pos.length; k<size; k++) {
			int nc = c + pos[k][0];
			int nr = r + pos[k][1];
			if(nc >= 0 && nr >= 0 && nc < N && nr < M && map[nc][nr] > 0 && !visit[nc][nr]) {
				cnt += dfs(nc, nr);
			}
		}
		return cnt;
	}
}
