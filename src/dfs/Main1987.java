package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 1987 알파벳
 * https://www.acmicpc.net/problem/1987
 * dfs, backtracking
 */
public class Main1987 {
	static int R, C, A;
	static char[][] map;
	static boolean[][] visit;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static ArrayList<Character> steps;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1987.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken().trim());
		C = Integer.parseInt(st.nextToken().trim());
		map = new char[R][C];
		visit = new boolean[R][C];
		steps = new ArrayList<Character>();
		for(int i=0; i<R; i++) {
			String str = br.readLine().trim();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		dfs(0, 0);
		System.out.println(A);
	}

	public static void dfs(int r, int c) {
		char step = map[r][c];
		for(char ch : steps) {
			if(step == ch) {
				return;
			}
		}
		steps.add(step);
		visit[r][c] = true;
		for(int k=0, size=pos.length; k<size; k++) {
			int nc = c + pos[k][0];
			int nr = r + pos[k][1];
			if(nc >= 0 && nr >= 0 && nc < C && nr < R && !visit[nr][nc]) {
				dfs(nr, nc);
			}
		}
		System.out.println(steps);
		A = Math.max(A, steps.size());

		steps.remove(steps.size()-1);
		visit[r][c] = false;
	}
}
