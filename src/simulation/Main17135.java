package simulation;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 17135 캐슬디펜스
 * https://www.acmicpc.net/problem/17135
 * Simulation
 */
public class Main17135 {
	static int N, M, D, MAX;
	static int[][] map, tmap;
	static int[] arr = new int[3];
	static ArrayList<Position> target;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17135.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 0);
		
		System.out.println(MAX);
	}

	// 궁수위치결정
	private static void combination(int idx, int cnt) {
		if(cnt == 3) {
			battle();
			return;
		}
		for (int i = idx; i < M; i++) {
			arr[cnt] = i;
			combination(i+1, cnt+1);
		}
	}
	private static void init() {
		target = new ArrayList<Position>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmap[i][j] = map[i][j];
				if(tmap[i][j] == 1) target.add(new Position(i, j));
			}
		}
	}
	
	private static void battle() {
		init();
		int shoot = 0;
		// 더이상 저격할 적이 없으면 종료
		while(target.size() > 0) {
			// 이번 턴에 저격할 적군
			HashSet<Position> set = new HashSet<Position>();
			for (int i = 0; i < 3; i++) {
				// i번째 궁수가 저격할 수 있는 적군 list
				PriorityQueue<Position> pq = new PriorityQueue<Position>(); 
				for (int j = 0; j < target.size(); j++) {
					Position t = new Position(target.get(j).x, target.get(j).y);
					int d = Math.abs(N-t.x) + Math.abs(arr[i]-t.y);
					if(d <= D) {
						t.d = d;
						pq.offer(t);
					}
				}
				if(!pq.isEmpty()) set.add(pq.poll());
			}
			
			// 궁수들 동시에 사격
			if(!set.isEmpty()) {
				for (Position position : set) {
					if(tmap[position.x][position.y] == 1) shoot++;
					tmap[position.x][position.y] = 0;
				}
			}
			
			// 적군 한 칸씩 전진
			remap();
		}
		MAX = Math.max(MAX, shoot);
	}
	private static void remap() {
		target = new ArrayList<Position>();
		LinkedList<Integer> queue;
		for (int i = 0; i < M; i++) {
			queue = new LinkedList<Integer>();
			for (int j = N-2; j >= 0; j--) {
				queue.offer(tmap[j][i]);
				tmap[j][i] = 0;
			}
			tmap[N-1][i] = 0;
			int j = N-1;
			while(!queue.isEmpty()) {
				tmap[j][i] = queue.poll();
				if(tmap[j][i] == 1) {
					target.add(new Position(j, i));
				}
				j--;
			}
		}
	}
	private static class Position implements Comparable<Position> {
		int x, y, d;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
			this.d = 0;
		}
		@Override
		public int compareTo(Position o) {
			if(this.d == o.d) return this.y - o.y;
			return this.d - o.d;
		}
	}
}
