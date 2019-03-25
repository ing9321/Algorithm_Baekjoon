package monthly.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 실패
 * 3025 돌 던지기
 * https://www.acmicpc.net/problem/3025
 */
public class Main3025 {
	static int R, C;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3025.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] rc = br.readLine().split(" ");
		R = Integer.parseInt(rc[0]);
		C = Integer.parseInt(rc[1]);
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int N = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			go(0, Integer.parseInt(br.readLine().trim()) - 1);
		}
		
		for (int i = 0; i < R; i++) {
			bw.write(map[i]);
			bw.write("\n");
		}
		bw.flush();
	}
	private static void go(int r, int c) {
		if(r+1 < R) {
			if(map[r+1][c] == '.') {
				go(r+1, c);
			} else if(map[r+1][c] == 'X') {
				map[r][c] = 'O';
			} else if(map[r+1][c] == 'O') {
				if(c > 0 && map[r+1][c-1] == '.') {
					go(r+1, c-1);
				} else if(c+1 < C && map[r+1][c+1] == '.') {
					go(r+1, c+1);
				} else {
					map[r][c] = 'O';
				}
			}
		} else {
			map[r][c] = 'O';
		}
	}
}
