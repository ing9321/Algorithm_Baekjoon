package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 17143 낚시왕
 * https://www.acmicpc.net/problem/17143
 * 시간초과
 */

class Shark {
	int r, c, s, d, z;
	public Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}
public class Main17143 {
	public static int R, C, M, S;
	public static int[][] map;
	public static int[][] dir = {{0,0}, {-1,0}, {1,0}, {0,1}, {0,-1}}; // 1:상, 2:하, 3:우, 4:좌
	public static PriorityQueue<Integer> queue;
	public static HashMap<Integer, Shark> sharks;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17143.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken().trim());
		C = Integer.parseInt(st.nextToken().trim());
		M = Integer.parseInt(st.nextToken().trim());
		S = 0;
		
		map = new int[R+1][C+1];
		sharks = new HashMap<Integer, Shark>();
		queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		int r, c, s, d, z;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			r = Integer.parseInt(st.nextToken().trim());
			c = Integer.parseInt(st.nextToken().trim());
			s = Integer.parseInt(st.nextToken().trim()); // 속력
			d = Integer.parseInt(st.nextToken().trim()); // 방향
			z = Integer.parseInt(st.nextToken().trim()); // 크기
			if(d == 1 && r == 1) {
				d = 2;
			} else if(d == 2 && r == R) {
				d = 1;
			} else if(d == 3 && c == C) {
				d = 4;
			} else if(d == 4 && c == 1) {
				d = 3;
			}
			Shark shark = new Shark(r, c, s, d, z);
			sharks.put(z, shark);
			map[r][c] = z;
		}
		
		for (int i = 1; i <= C; i++) { // 낙시왕 이동
			// 낚시왕 낚시대
			for (int j = 1; j <= R; j++) {
				if(map[j][i] > 0) {
					S += map[j][i];
					sharks.remove(map[j][i]);
					map[j][i] = 0;
					break;
				}
			}
			
			// 상어 이동
			queue.clear();
			for (int key : sharks.keySet()) {
				Shark shark = sharks.get(key);
				map[shark.r][shark.c] = 0;
//				int move = shark.s;
//				while(move > 0) {
//					if(shark.d == 1) {
//						
//					} else if(shark.d == 2){
//						
//					} else if(shark.d == 3) {
//						
//					} else if(shark.d == 4) {
//						
//					}
//				}
				
				
				for (int k = 0; k < shark.s; k++) {
					int nr = shark.r + dir[shark.d][0];
					int nc = shark.c + dir[shark.d][1];
					if(shark.d == 1 && nr == 1) {
						shark.d = 2;
					} else if(shark.d == 2 && nr == R) {
						shark.d = 1;
					} else if(shark.d == 3 && nc == C) {
						shark.d = 4;
					} else if(shark.d == 4 && nc == 1) {
						shark.d = 3;
					}
					shark.r = nr;
					shark.c = nc;
				}
				sharks.put(key, shark);
				queue.add(key);
			}

			while(!queue.isEmpty()) {
				int key = queue.poll();
				Shark shark = sharks.get(key);
				if(map[shark.r][shark.c] > 0) {
					sharks.remove(key);
				} else {
					map[shark.r][shark.c] = key;
				}
			}
		}
		
		System.out.println(S);
	}
}
