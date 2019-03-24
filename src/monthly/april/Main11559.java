package monthly.april;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

// 뿌요뿌요
public class Main11559 {
	static int R = 12, C = 6, A;
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
		
		while(true) {
			boolean flag = false;
			visit = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == '.' || visit[i][j]) continue;
					queue = new LinkedList<int[]>();
					dfs(i, j, map[i][j]);
					if(queue.size() >= 4) {
						flag = true;
						while(!queue.isEmpty()) {
							int[] p = queue.poll();
							map[p[0]][p[1]] = '.';
						}
					}
				}
			}
			if(!flag) {
				break;
			}
			A++;
			redraw();
		}
		System.out.println(A);
	}
	private static void redraw() {
		for (int i = 0; i < C; i++) {
			for (int j = 1; j < R; j++) {
				for (int k = 0; k < j; k++) {
					if(map[k][i] == '.' && map[j][i] != '.') {
						map[k][i] = map[j][i];
						map[j][i] = '.';
					}
				}
			}
		}
	}

	private static void dfs(int x, int y, char ch) {
		for (int i = 0; i < 4; i++) {
			int nx = x + pos[i][0];
			int ny = y + pos[i][1];
			if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
			if(visit[nx][ny] || ch != map[nx][ny]) continue;
			queue.offer(new int[] {nx, ny});
			visit[nx][ny] = true;
			dfs(nx, ny, ch);
		}
	}
}
