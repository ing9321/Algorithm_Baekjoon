package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 17142 연구소3
 * https://www.acmicpc.net/problem/17142
 * 미해결
 */

public class Main17142 {
	public static int N, M;
	public static int[][] origin;
	public static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static ArrayList<int[]> walls;
	public static ArrayList<int[]> virus;
	public static int[] selected;
	public static int MS = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17142.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken().trim());
		M = Integer.parseInt(st.nextToken().trim());
		origin = new int[N][N];
		walls = new ArrayList<int[]>();
		virus = new ArrayList<int[]>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken().trim());
				if(origin[i][j] == 1) {
					walls.add(new int[] {i,j});
				} else if(origin[i][j] == 2) {
					virus.add(new int[] {i, j});
				}
			}
		}
		
		selected = new int[M];
		combination(0, 0);
		
		if(MS == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(MS);
		}
	}

	private static void combination(int cnt, int idx) {
		if(cnt == M) {
			MS = Math.min(MS, spread());
			return;
		}
		for(int i = idx; i < virus.size(); i++) {
			selected[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	private static int spread() {
		boolean[][] visit = new boolean[N][N];
		for (int i = 0, size = walls.size(); i < size; i++) {
			visit[walls.get(i)[0]][walls.get(i)[1]] = true;
		}
		
		LinkedList<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < M; i++) {
			int r = virus.get(selected[i])[0];
			int c = virus.get(selected[i])[1];
			visit[r][c] = true;
			queue.offer(new int[] {r,c});
		}
		
		int SEC = 0;
		while(!queue.isEmpty()) {
			if(SEC > MS) return SEC;
			
			boolean chk = false;
			for (int i = 0, size = queue.size(); i < size; i++) {
				int[] cur = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dir[d][0];
					int nc = cur[1] + dir[d][1];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc] || origin[nr][nc] == 1) continue;
					visit[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
					if(origin[nr][nc] == 0) chk = true;
				}
			}
			if(chk) SEC++;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j] && origin[i][j] == 0) {
					return Integer.MAX_VALUE;
				}
			}
		}
		return SEC;
	}
}
