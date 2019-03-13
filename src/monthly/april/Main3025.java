package monthly.april;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

// 돌 던지기
public class Main3025 {
	static int R, C;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3025.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rc = br.readLine().split(" ");
		R = Integer.parseInt(rc[0]);
		C = Integer.parseInt(rc[1]);
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if(line.charAt(j) == 'X') map[i][j] = 2;
			}
		}
		
		int N = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(br.readLine().trim()) - 1;
			go(0, c);
		}
		
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	private static void go(int r, int c) {
		if(r+1 < R) {
			if(map[r+1][c] == 0) {
				go(r+1, c);
			} else if(map[r+1][c] == 2) {
				map[r][c] = 1;
			} else if(map[r+1][c] == 1) {
				if(c > 0 && map[r+1][c-1] == 0) {
					go(r+1, c-1);
				} else if(c-1 < C && map[r+1][c+1] == 0) {
					go(r+1, c+1);
				} else {
					map[r][c] = 1;
				}
			}
		} else {
			map[r][c] = 1;
		}
	}
}
