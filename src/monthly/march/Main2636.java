package monthly.march;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 치즈
public class Main2636 {
	static int R, C;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int cheese = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cheese += map[i][j];
			}
		}
		melting(0, 0);

		int hour = 0;
		while(true) {
			hour++;
			cheese = 0;
			int melt = 0;
			for (int i = 1; i < R-1; i++) {
				for (int j = 1; j < C-1; j++) {
					if(map[i][j] == 1) {
						cheese++;
						if(map[i-1][j] < 0 || map[i+1][j] < 0 || map[i][j-1] < 0 || map[i][j+1] < 0) {
							map[i][j] = 9;
							melt++;
						}
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] < 0 || map[i][j] == 9) {
						map[i][j] = 0;
					}
				}
			}
			if(cheese - melt == 0) {
				break;
			}
			melting(0, 0);
		}
		System.out.println(hour + "\n" + cheese);
	}
	private static void melting(int x, int y) {
		if(map[x][y] == 0) {
			map[x][y] = -1;
			if(y-1 >= 0) melting(x, y-1);
			if(y+1 < C) melting(x, y+1);
			if(x-1 >= 0) melting(x-1, y);
			if(x+1 < R) melting(x+1, y);
		}
	}
}
