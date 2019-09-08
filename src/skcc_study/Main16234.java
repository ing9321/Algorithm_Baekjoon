package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 16234 인구이동
 * https://www.acmicpc.net/problem/16234
 * dfs
 */

public class Main16234 {
	public static int N, L, R, C;
	public static int[][] map;
	public static int[][] unions;
	public static ArrayList<int[]> list;
	public static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().trim().split(" ");
		N = Integer.parseInt(str[0]);
		L = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		C = 0;
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			str = br.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		while(true) {
			// 연합탐색
			unions = new int[N][N];
			list = new ArrayList<int[]>();
			list.add(new int[] {0, 0});
			int un = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(unions[i][j] == 0) {
						un++;
						unions[i][j] = un;
						list.add(new int[] {1, map[i][j]});
						setUnions(i, j, un);
					}
				}
			}
			// 인구이동
			if(un < N * N) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(unions[i][j] > 0) {
							int[] u = list.get(unions[i][j]);
							map[i][j] = u[1] / u[0];
						}
					}
				}
				C++;
			} else {
				break;
			}
		}
		
		System.out.println(C);
	}

	public static void setUnions(int r, int c, int un) {
		for (int k = 0; k < 4; k++) {
			int nr = r + dir[k][0];
			int nc = c + dir[k][1];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			int tmp = Math.abs(map[r][c] - map[nr][nc]);
			if(tmp >= L && tmp <= R && unions[nr][nc] == 0) {
				unions[nr][nc] = un;
				list.set(un, new int[] {list.get(un)[0] + 1, list.get(un)[1] + map[nr][nc]});
				setUnions(nr, nc, un);
			}
		}
	}
}
