package dfs;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 17070 파이프 옮기기1
 * https://www.acmicpc.net/problem/17070
 * dfs, simulation
 */
public class Main17070 {
	static int N, C;
	static int[][] map;
	static int[][] pos = {{0,1}, {1,0}, {1,1}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17070.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(0, 1, 0);
		System.out.println(C);
	}
	private static void go(int r, int c, int d) {
		if(r == N-1 && c == N-1) {
			C++;
			return;
		}
		
		for (int i = 0; i < pos.length; i++) {
			if(d == 0 && i == 1) continue;
			if(d == 1 && i == 0) continue;
			
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(nr >= N || nc >= N || map[nr][nc] == 1) continue;
			if(i == 2 && (map[nr-1][nc] == 1 || map[nr][nc-1] == 1)) continue;
			go(nr, nc, i);
		}
	}
}
