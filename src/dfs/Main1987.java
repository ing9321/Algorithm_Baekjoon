package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1987 {
	static int R, C;
	static char[][] map;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static ArrayList<Character> steps;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1987.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken().trim());
		C = Integer.parseInt(st.nextToken().trim());
		map = new char[R][C];
		steps = new ArrayList<Character>();
		for(int i=0; i<R; i++) {
			String str = br.readLine().trim();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int r, int c) {
		int cnt = 1;
		char step = map[r][c];
		for(char ch : steps) {
			if(step == ch) {
				return 0;
			}
		}
		steps.add(step);
		for(int k=0, size=pos.length; k<size; k++) {
			int nc = c + pos[k][0];
			int nr = r + pos[k][1];
			if(nc >= 0 && nr >= 0 && nc < C && nr < R) {
				cnt += dfs(nr, nc);
			}
		}
		return cnt;
	}
}
