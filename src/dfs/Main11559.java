package dfs;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/* 
 * 11559  뿌요뿌요
 * https://www.acmicpc.net/problem/11559
 * Simulation, DFS, BFS
 */
public class Main11559 {
	static int R = 12, C = 6, A;
	static char[][] map = new char[R][C];
	static boolean[][] visit;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static LinkedList<int[]> queue;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input11559.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().trim().toCharArray();
		}
		
		while(true) {
			boolean flag = false;
			visit = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == '.' || visit[i][j]) continue;
					queue = new LinkedList<int[]>();
					queue.offer(new int[] {i, j});
					visit[i][j] = true;
					dfs(i, j, map[i][j]);
					
					if(queue.size() >= 4) {
						flag = true;
						while(!queue.isEmpty()) {
							int[] cur = queue.poll();
							map[cur[0]][cur[1]] = '.';
						}
					}
				}
			}
			
			if(!flag) break;
			A++;
			gravity();
		}
		
		System.out.println(A);
	}
	private static void dfs(int r, int c, char value) {
		for (int i = 0; i < 4; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] != value || visit[nr][nc]) continue;
			queue.offer(new int[] {nr, nc});
			visit[nr][nc] = true;
			dfs(nr, nc, value);
		}
	}
	private static void gravity() {
		LinkedList<Character> q;
		for (int i = 0; i < C; i++) {
			q = new LinkedList<Character>();
			for (int j = R-1; j >= 0; j--) {
				if(map[j][i] != '.') {
					q.offer(map[j][i]);
				}
				map[j][i] = '.';
			}
			int j = R-1;
			while(!q.isEmpty()) {
				map[j][i] = q.poll();
				j--;
			}
		}
	}
}
