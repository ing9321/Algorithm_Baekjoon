package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 백준 2931 가스관
 * https://www.acmicpc.net/problem/2931
 * bfs, dfs, 다익스트라 알고리즘
 */
public class Main2931 {
	static int R, C;
	static char[][] map;
	static int[][] pos = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static char[][] block = {{'|', '+', '1', '4'},{'|', '+', '2', '3'}, {'-', '+', '1', '2'}, {'-', '+', '3', '4'}};
	static HashMap<Character, int[]> hash = new HashMap<Character, int[]>();
	public static void main(String[] args) throws Exception {
		hash.put('|', new int[]{1, 1, 0, 0});
		hash.put('-', new int[]{0, 0, 1, 1});
		hash.put('+', new int[]{1, 1, 1, 1});
		hash.put('1', new int[]{0, 1, 0, 1});
		hash.put('2', new int[]{1, 0, 0, 1});
		hash.put('3', new int[]{1, 0, 1, 0});
		hash.put('4', new int[]{0, 1, 1, 0});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strarr = br.readLine().split(" ");
		R = Integer.parseInt(strarr[0]);
		C = Integer.parseInt(strarr[1]);
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '.') continue;
				int[] tmp = new int[4];
				for (int p = 0; p < 4; p++) {
					int nx = i + pos[p][0];
					int ny = j + pos[p][1];
					if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
					for (int b = 0; b < 4; b++) {
						if(map[nx][ny] == block[p][b]) tmp[p] = 1;
					}
				}
				for (char key : hash.keySet()) {
					if(Arrays.equals(tmp, hash.get(key))) {
						System.out.println((i+1) + " " + (j+1) + " " + key);
					}
				}
			}
		}
	}
}
