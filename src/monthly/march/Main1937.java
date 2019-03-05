package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 욕심쟁이 판다
public class Main1937 {
	static int n;
	static int[][] map, dp;
	static boolean[][] visited;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1937.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		dp = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = 1;
			}
		}
		
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				visited = new boolean[n][n];
				update(x, y);
			}
		}
	}
	private static void update(int x, int y) {
		visited[x][y] = true;
		for (int p = 0; p < 4; p++) {
			int nx = x + pos[p][0];
			int ny = y + pos[p][1];
			if(nx >= 0 && ny >= 0 && nx < n && ny < n
					&& !visited[nx][ny] && map[x][y] < map[nx][ny]) {
				
			}
		}
	}
}
