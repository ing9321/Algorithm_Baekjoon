package simulation;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 17143 낚시왕
 * https://www.acmicpc.net/problem/17143
 * simulation
 */
public class Main17143 {
	static int R, C, M;
	static int[][] map;
	static int[][] pos = {{0,0}, {-1,0}, {1,0}, {0,1}, {0,-1}}; // 1:상, 2:하, 3:우, 4:좌
	static HashMap<Integer, Fish> fishes = new HashMap<Integer, Fish>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17143_낚시왕.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken()) -1;
			int c = Integer.parseInt(st.nextToken()) -1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c]++;
			if(r == 0 && d == 1) {
				d = 2;
			} else if(r == R-1 && d == 2) {
				d = 1;
			} else if(c == 0 && d == 4) {
				d = 3;
			} else if(c == C-1 && d == 3) {
				d = 4;
			}
			fishes.put(z, new Fish(r, c, s, d, z));
		}
		
		int cnt = 0;
		int sum = 0;
		while(cnt < C) {
			for (int i = 0; i < R; i++) {
				if(map[i][cnt] == 1) {
					for (Fish fish : fishes.values()) {
						if(fish.r == i && fish.c == cnt) {
							sum += fish.z;
							fishes.remove(fish.z);
							break;
						}
					}
					map[i][cnt]--;
					break;
				}
			}
			
			for (Fish fish : fishes.values()) {
				map[fish.r][fish.c]--;
				for (int i = 0; i < fish.s; i++) {
					int nr = fish.r + pos[fish.d][0];
					int nc = fish.c + pos[fish.d][1];
					if(nr == 0 && fish.d == 1) {
						fish.d = 2;
					} else if(nr == R-1 && fish.d == 2) {
						fish.d = 1;
					} else if(nc == 0 && fish.d == 4) {
						fish.d = 3;
					} else if(nc == C-1 && fish.d == 3) {
						fish.d = 4;
					}
					fish.r = nr;
					fish.c = nc;
				}
				map[fish.r][fish.c]++;
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] > 1) {
						PriorityQueue<Fish> queue = new PriorityQueue<Fish>();
						for (Fish fish : fishes.values()) {
							if(fish.r == i && fish.c == j) {
								queue.offer(fish);
							}
						}
						
						while(queue.size() > 1) {
							Fish fish = queue.poll();
							fishes.remove(fish.z);
						}
						map[i][j] = 1;
					}
				}
			}
			
			cnt++;
		}
		
		System.out.println(sum);
	}
	private static class Fish implements Comparable<Fish> {
		int r, c, s, d, z;
		public Fish(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Fish o) {
			return this.z - o.z;
		}
	}
}
