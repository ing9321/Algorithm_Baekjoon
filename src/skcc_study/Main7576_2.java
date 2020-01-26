package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 7576 토마토
 * https://www.acmicpc.net/problem/7576
 * BFS
 */

public class Main7576_2 {
	public static int M, N, D;
	public static int[][] map;
	public static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7576.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken().trim()); // 가로
		N = Integer.parseInt(st.nextToken().trim()); // 세로
		D = 0; // 날짜
		map = new int[N][M]; // 상자
		LinkedList<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken().trim());
				if(map[i][j] == 1) {
					queue.add(new int[] {i, j, 0}); // 익은 토마토(r, c, date)
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			D = Math.max(D, cur[2]);
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dir[i][0];
				int nc = cur[1] + dir[i][1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
					map[nr][nc] = 1;
					queue.add(new int[] {nr, nc, D+1});
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(Arrays.binarySearch(map[i], 0) >= 0) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(D);
	}

}
