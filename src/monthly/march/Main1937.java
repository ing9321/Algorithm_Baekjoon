package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 욕심쟁이 판다
public class Main1937 {
	static int n;
	static int[][] map, dp;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1937.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		dp = new int[n][n];
		int max = 0;
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				max = Math.max(max, update(x,y));
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(max);
	}
	private static int update(int x, int y) {
		if(dp[x][y] == 0) {
			dp[x][y] = 1;
			for (int p = 0; p < 4; p++) {
				int nx = x + pos[p][0];
				int ny = y + pos[p][1];
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[x][y] < map[nx][ny]) {
					dp[x][y] = Math.max(dp[x][y], update(nx, ny) + 1);
				}
			}
		}		
		return dp[x][y];
	}
}
