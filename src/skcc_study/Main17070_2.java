package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17070_2 {

	public static int N, C;
	public static int[][] map;
	public static int[][] dir = {{0,1}, {1,0}, {1,1}};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17070.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}

		C = 0;
		
		dfs(0, 1, 0);
		
		System.out.println(C);
	}

	public static void dfs(int x, int y, int d) {
		if(x == N-1 && y == N-1) {
			C++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if(d+i == 1) continue;
			
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			if(nx >= N || ny >= N || map[nx][ny] == 1) continue;
			if(i == 2 && (map[nx][y] == 1 || map[x][ny] == 1)) continue;
			
			dfs(nx, ny, i);
		}
		
	}
}
