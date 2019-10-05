package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 16236 아기상어
 * https://www.acmicpc.net/problem/16236
 */

class BabyShark {
	int r, c, size, eat;
	public BabyShark(int r, int c) {
		this.r = r;
		this.c = c;
		this.size = 2;
		this.eat = 0;
	}
}
class Fish implements Comparable<Fish>{
	int r, c, size, dist;
	public Fish(int r, int c, int size, int dist) {
		this.r = r;
		this.c = c;
		this.size = size;
		this.dist = dist;
	}
	@Override
	public int compareTo(Fish o) {
		if(this.dist == o.dist) {
			if(this.r == o.r) {
				return this.c - o.c;
			}
			return this.r - o.r;
		}
		return this.dist - o.dist;
	}
}

public class Main16236 {
	public static int N, S, A;
	public static int[][] map;
	public static boolean[][] visit;
	public static BabyShark shark;
	public static ArrayList<Fish> fishes;
	public static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken().trim());
				if(map[i][j] == 9) {
					shark = new BabyShark(i, j);
					map[i][j] = 0;
				}
			}
		}
		
		A = 0;
		while(true) {
			// 사냥 가능한 물고기 찾기
			fishes = new ArrayList<>();
			visit = new boolean[N][N];
			LinkedList<int[]> queue = new LinkedList<int[]>();
			queue.add(new int[] {shark.r, shark.c});
			visit[shark.r][shark.c] = true;
			int step = 0;
			while(!queue.isEmpty()) {
				int size = queue.size();
				step++;
				for (int i = 0; i < size; i++) {
					int[] pos = queue.poll();
					for (int j = 0; j < 4; j++) {
						int nr = pos[0] + dir[j][0];
						int nc = pos[1] + dir[j][1];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc] || map[nr][nc] > shark.size) continue;
						visit[nr][nc] = true;
						if(map[nr][nc] < shark.size && map[nr][nc] > 0) {
							fishes.add(new Fish(nr, nc, map[nr][nc], step));
						}
						queue.add(new int[] {nr, nc});
					}
				}
			}
			
			// 먹을 수 있는 물고기가 없을 때
			if(fishes.size() == 0) break;

			// 물고기가 먹기
			Collections.sort(fishes);
			Fish f = fishes.get(0);
			A = A + f.dist;
			shark.r = f.r;
			shark.c = f.c;
			map[f.r][f.c] = 0;
			shark.eat = shark.eat+1;
			if(shark.eat == shark.size) {
				shark.size = shark.size + 1;
				shark.eat = 0;
			}
		}
		System.out.println(A);
	}
	
	public static void huntFish(int fr, int fc, int sr, int sc, int step) {
		if(S < step) return;
		if(fr == sr && fc == sc) {
			S = Math.min(S, step);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nsr = sr + dir[i][0];
			int nsc = sc + dir[i][1];
			if(nsr < 0 || nsr >= N || nsc < 0 || nsc >= N || visit[nsr][nsc] || map[nsr][nsc] > shark.size) continue;
			visit[nsr][nsc] = true;
			huntFish(fr, fc, nsr, nsc, step+1);
			visit[nsr][nsc] = false;
		}
	}
}
