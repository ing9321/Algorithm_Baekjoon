package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 3055 탈출
 * https://www.acmicpc.net/problem/3055
 * bfs
 */
public class Main1082 {
	static int R, C, T;
	static char[][] map;
	static LinkedList<int[]> queue;
	static LinkedList<int[]> water;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		queue = new LinkedList<int[]>();
		water = new LinkedList<int[]>();
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().trim().toCharArray();
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'S') {
					queue.offer(new int[] {i, j, 0});
				} else if(map[i][j] == '*') {
					water.offer(new int[] {i, j});
				}
			}
		}
		top:
		while(!queue.isEmpty()) {
			int step = queue.size();
			for (int i = 0; i < step; i++) {
				int[] current = queue.poll();
				if(map[current[0]][current[1]] == '*') continue;
				for (int j = 0; j < 4; j++) {
					int nx = current[0] + pos[j][0];
					int ny = current[1] + pos[j][1];
					if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '*' || map[nx][ny] == 'X') continue;
					if(map[nx][ny] == 'D') {
						T = current[2] + 1;
						break top;
					} else if(map[nx][ny] == '.') {
						map[nx][ny] = 'S';
						queue.offer(new int[] {nx, ny, current[2]+1});
					}
				}
			}
			
			int size = water.size();
			for (int i = 0; i <size; i++) {
				int[] current = water.poll();
				for (int j = 0; j < 4; j++) {
					int nx = current[0] + pos[j][0];
					int ny = current[1] + pos[j][1];
					if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == 'D' || map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
					map[nx][ny] = '*';
					water.offer(new int[] {nx, ny});
				}
			}
			
		}
		
		if(T > 0) {
			System.out.println(T);
		} else {
			System.out.println("KAKTUS");
		}
	}

}
