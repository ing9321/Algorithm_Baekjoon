package monthly.april;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main11559 {
	static int R = 12, C = 6;
	static char[][] map = new char[R][C];
	static boolean[][] visit;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static LinkedList<int[]> queue;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input11559.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = R-1; i >= 0; i--) {
			map[i] = br.readLine().toCharArray();
			
		}
		
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.') continue;
				System.out.println("start : " + i + ", " + j);
				visit = new boolean[R][C];
				queue = new LinkedList<int[]>();
				int cnt = dfs(i, j, 1);
				System.out.println(cnt);
				if(cnt >= 4) {
					System.out.println("뿌요뿌요");
					while(!queue.isEmpty()) {
						int[] p = queue.poll();
						map[p[0]][p[1]] = '.';
					}
					for (int ni = 0; ni < R; ni++) {
						System.out.println(Arrays.toString(map[ni]));
					}
					// 당겨주기
					
				}
			}
		}
	}
	private static void mapCheck() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.') continue;
				
			}
		}
	}
	private static void redraw() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.') {
					if(i+1 < R && map[i+1][j] != '.') {
						
					}
				}
			}
		}
	}

	private static int dfs(int x, int y, int cnt) {
		System.out.println(x + " " + y);
		queue.offer(new int[] {x, y});
		visit[x][y] = true;
		int c = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + pos[i][0];
			int ny = y + pos[i][1];
			if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
			if(visit[nx][ny] || map[x][y] != map[nx][ny]) continue;
			c = Math.max(c, dfs(nx, ny, cnt+1));
		}

		return c;
	}
}
