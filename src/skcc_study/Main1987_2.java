package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 1987 알파벳
 * https://www.acmicpc.net/problem/1987
 * dfs
 */

public class Main1987_2 {
	public static int R, C, A;
	public static char[][] map;
	public static boolean[][] visit;
	public static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static ArrayList<Character> alphabet;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1987.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().trim().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		A = 0;
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		alphabet = new ArrayList<>();
		dfs(0, 0);
		System.out.println(A);
	}

	public static void dfs(int r, int c) {
		if(alphabet.indexOf(map[r][c]) > -1) return;
		
		alphabet.add(map[r][c]);
		visit[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr < 0 || nc < 0 || nr >= R || nc >= C || visit[nr][nc]) continue;
			dfs(nr, nc);
		}
		A = Math.max(A, alphabet.size());
		alphabet.remove(alphabet.size()-1);
		visit[r][c] = false;
	}
}
