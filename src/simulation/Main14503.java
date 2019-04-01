package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 14503 로봇청소기
 * https://www.acmicpc.net/problem/14503
 * dfs, Simulation
 */
public class Main14503 {
	static int N, M, C;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input14503.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		st = new StringTokenizer(br.readLine().trim());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(x, y, d);
	}

	private static void dfs(int x, int y, int d) {
		if(!visit[x][y]) {
			C++;
			visit[x][y] = true;
		}
		for (int i = 0; i < 4; i++) {
			int dir = (d-i+3) % 4;
			int nx = x + pos[dir][0];
			int ny = y + pos[dir][1];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if(map[nx][ny] == 1 || visit[nx][ny]) continue;
			dfs(nx, ny, dir);
		}
		int nx = x - pos[d][0];
		int ny = y - pos[d][1];
		if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
			if(map[nx][ny] != 1) {
				dfs(nx, ny, d);
			}else {
				System.out.println(C);
				System.exit(0);
			}
		}
	}
}
