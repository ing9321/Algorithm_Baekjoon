package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 2638 치즈
 * https://www.acmicpc.net/problem/2638
 * BFS
 */

public class Main2638 {
	public static int N, M;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2638.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken().trim());
		M = Integer.parseInt(st.nextToken().trim());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		
		int hours = 0;
		LinkedList<int[]> queue = new LinkedList<>();
		while(true) {
			// 녹을 치즈 찾기
			for (int i = 0; i < N; i++) {
				Arrays.fill(visit[i], false);
			}
			queue.clear();
			queue.add(new int[] {0,0});
			visit[0][0] = true;
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + pos[i][0];
					int nc = cur[1] + pos[i][1];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc]) continue;
					if(map[nr][nc] > 0) {
						map[nr][nc]++;
					} else {
						queue.add(new int[] {nr, nc});
						visit[nr][nc] = true;
					}
				}
			}
			
			// 치즈녹이기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 2) map[i][j] = 1;
					else if(map[i][j] > 2) map[i][j] = 0;
				}
			}
			
			hours++;
			
			// 남은 치즈 확인
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) cnt++;
				}
			}
			if(cnt == 0) break;
		}
		System.out.println(hours);
	}
}
