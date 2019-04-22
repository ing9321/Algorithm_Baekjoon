package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 백준 17144 미세먼지 안녕!
 * Simulation
 */
public class Main17144 {
	static int R, C, T;
	static int[][] map;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static ArrayList<Integer> cleaner;
	static LinkedList<int[]> dust;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17144.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		cleaner = new ArrayList<Integer>();
		dust = new LinkedList<int[]>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] < 0) cleaner.add(i);
			}
		}
		
		while(T > 0) {
			// 미세먼지 확산
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] > 0) { // 미세먼지
						int mise = map[i][j];
						int mise2 = mise / 5;
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int ni = i + pos[k][0];
							int nj = j + pos[k][1];
							if(ni < 0 || ni >= R || nj < 0 || nj >= C || map[ni][nj] < 0) continue;
							cnt++;
							dust.add(new int[] {ni, nj, mise2});
						}
						map[i][j] = mise - (mise2 * cnt);
					}
				}
			}
			while(!dust.isEmpty()) {
				int[] t = dust.poll();
				map[t[0]][t[1]] += t[2];
			}

			// 공기청정기
			for (int i = cleaner.get(0)-1; i > 0; i--) {
				map[i][0] = map[i-1][0];
			}
			for (int i = 0; i < C-1; i++) {
				map[0][i] = map[0][i+1];
			}
			for (int i = 0; i < cleaner.get(0); i++) {
				map[i][C-1] = map[i+1][C-1];
			}
			for (int i = C-1; i > 1; i--) {
				map[cleaner.get(0)][i] = map[cleaner.get(0)][i-1];
			}
			map[cleaner.get(0)][1] = 0;
			for (int i = cleaner.get(1)+2; i < R; i++) {
				map[i-1][0] = map[i][0];
			}
			for (int i = 1; i < C; i++) {
				map[R-1][i-1] = map[R-1][i];
			}
			for (int i = R-1; i > cleaner.get(1); i--) {
				map[i][C-1] = map[i-1][C-1];
			}
			for (int i = C-1; i > 1; i--) {
				map[cleaner.get(1)][i] = map[cleaner.get(1)][i-1];
			}
			map[cleaner.get(1)][1] = 0;

			T--;
		}
		
		int M = 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				M += map[i][j];
			}
		}
		System.out.println(M);
	}
}
