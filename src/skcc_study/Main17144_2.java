package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 17144 미세먼지 안녕
 * https://www.acmicpc.net/problem/17144
 * simulation
 */

public class Main17144_2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17144.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int R = Integer.parseInt(st.nextToken().trim());
		int C = Integer.parseInt(st.nextToken().trim());
		int T = Integer.parseInt(st.nextToken().trim());
		
		int[][] map = new int[R][C];
		int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
		ArrayList<Integer> cleaner = new ArrayList<Integer>();
		LinkedList<int[]> queue = new LinkedList<int[]>();
		LinkedList<int[]> queue2 = new LinkedList<int[]>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < C; j++) {
				int k = Integer.parseInt(st.nextToken().trim());
				map[i][j] = k;
				if(k < 0) {
					cleaner.add(i);
				} else if(k > 0) {
					queue.add(new int[] {i, j, k});
				}
			}
		}
		
		while(T > 0) {
			// 미세먼지 분할
			while(!queue.isEmpty()) {
				int[] dust = queue.poll();
				int cnt = 0;
				int amount = dust[2]/5;
				if(amount > 0) {
					for (int i = 0; i < 4; i++) {
						int nr = dust[0] + dir[i][0];
						int nc = dust[1] + dir[i][1];
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] < 0) continue;
						queue2.add(new int[] {nr, nc, amount});
						cnt++;
					}
				}
				map[dust[0]][dust[1]] = dust[2] - (amount * cnt);
			}
			
			// 미세먼지 확산
			while(!queue2.isEmpty()) {
				int[] dust = queue2.poll();
				map[dust[0]][dust[1]] += dust[2];
			}
			
			// 공기청정기 가동
			for (int i = cleaner.get(0)-1; i > 0; i--) {
				map[i][0] = map[i-1][0];
			}
			for (int i = 1; i < C; i++) {
				map[0][i-1] = map[0][i];
			}
			for (int i = 1; i <= cleaner.get(0); i++) {
				map[i-1][C-1] = map[i][C-1];
			}
			for (int i = C-1; i > 1; i--) {
				map[cleaner.get(0)][i] = map[cleaner.get(0)][i-1];
			}
			map[cleaner.get(0)][1] = 0;
			for (int i = cleaner.get(1)+1; i < R-1; i++) {
				map[i][0] = map[i+1][0];
			}
			for (int i = 1; i < C; i++) {
				map[R-1][i-1] = map[R-1][i];
			}
			for (int i = R-2; i >= cleaner.get(1); i--) {
				map[i+1][C-1] = map[i][C-1];
			}
			for (int i = C-1; i > 1; i--) {
				map[cleaner.get(1)][i] = map[cleaner.get(1)][i-1];
			}
			map[cleaner.get(1)][1] = 0;
			
			// 미세먼지 조회
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] > 0) queue.add(new int[] {i, j, map[i][j]});
				}
			}
			
			T--;
		}
		
		int S = 0;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			S += tmp[2];
		}
		System.out.println(S);
	}

}
