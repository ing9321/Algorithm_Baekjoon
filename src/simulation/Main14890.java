package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 14890 경사로
 * https://www.acmicpc.net/problem/14890
 * simulation, dfs
 */
public class Main14890 {
	static int N, L, C;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input14890.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		C = 0;
		for (int i = 0; i < N; i++) {
			dfs(i, 0, new int[] {0, 1}, new boolean[N]);
			dfs(0, i, new int[] {1, 0}, new boolean[N]);
		}
		System.out.println(C);
	}
	private static void dfs(int x, int y, int[] dir, boolean[] visit) {
		int nx = x + dir[0];
		int ny = y + dir[1];
		if(nx >= N || ny >= N) {
			C++;
			return;
		}
		if(map[x][y] == map[nx][ny]) {
			dfs(nx, ny, dir, visit);
		} else if(map[x][y] - map[nx][ny] == 1){ // 다음 위치부터 X만큼 앞으로 내리막 경사로
			boolean flag = false;
			for (int i = 0; i < L; i++) {
				int rx = nx + i*dir[0];
				int ry = ny + i*dir[1];
				if(rx >= N || ry >= N || map[rx][ry] != map[nx][ny]) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				for (int i = 0; i < L; i++) {
					int rx = (nx + i)*dir[0];
					int ry = (ny + i)*dir[1];
					visit[Math.abs(rx-ry)] = true;
				}
				dfs(x+L*dir[0], y+L*dir[1], dir, visit);
			}
		} else if(map[x][y] - map[nx][ny] == -1) { // 현재위치부터 X만큼 뒤로 내리막 경사로
			boolean flag = false;
			for (int i = 0; i < L; i++) {
				int rx = x - i*dir[0];
				int ry = y - i*dir[1];
				int vxy = Math.abs((x - i)*dir[0] - (y - i)*dir[1]);
				if(rx < 0 || ry < 0 || map[rx][ry] != map[x][y]) {
					flag = true;
					break;
				}
				if(vxy < 0 || vxy >= N || visit[vxy]) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				for (int i = 0; i < L; i++) {
					int rx = (x - i)*dir[0];
					int ry = (y - i)*dir[1];
					visit[Math.abs(rx-ry)] = true;
				}
				dfs(nx, ny, dir, visit);
			}
		}
	}
}
