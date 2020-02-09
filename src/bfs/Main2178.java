package bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 2178 미로 탐색
 * https://www.acmicpc.net/problem/2178
 * BFS
 * 
 * 1: 길, 0: 벽. 인접 영역으로만 이동 가능
 * 0,0에서 출발하여 N,M에 도착하는 최단 시간
 */

public class Main2178 {
	public static int N, M;
	public static char[][] map;
	public static boolean[][] visit;
	public static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2178.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strarr = br.readLine().split(" ");
		N = Integer.parseInt(strarr[0]);
		M = Integer.parseInt(strarr[1]);
		map = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0,0, 1});
		visit[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dir[i][0];
				int nc = cur[1] + dir[i][1];
				if(nr == N-1 && nc == M-1) {
					System.out.println(cur[2] + 1);
					return;
				}
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == '1' && !visit[nr][nc]) {
					visit[nr][nc] = true;
					queue.add(new int[] {nr, nc, cur[2]+1});
				}
			}
		}
	}
}
