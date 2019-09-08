package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 16957 체스판 위의 공
 * https://www.acmicpc.net/problem/16957
 * priority queue
 */

class Chess implements Comparable<Chess>{
	int x;
	int y;
	int n;
	public Chess(int x, int y, int n) {
		this.x = x;
		this.y = y;
		this.n = n;
	}
	@Override
	public int compareTo(Chess o) {
		return this.n <= o.n ? 1 : -1;
	}
}
public class Main16957 {
	public static int R, C;
	public static int[][] map;
	public static int[][] balls;
	public static int[][] dir = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1, 0}, {-1,1}};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16957.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		R = Integer.parseInt(st.nextToken().trim());
		C = Integer.parseInt(st.nextToken().trim());

		map = new int[R][C];
		balls = new int[R][C];
		PriorityQueue<Chess> queue = new PriorityQueue<>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < C; j++) {
				int t = Integer.parseInt(st.nextToken().trim());
				map[i][j] = t;
				balls[i][j] = 1;
				queue.offer(new Chess(i, j, t));
			}
		}
		
		while(!queue.isEmpty()) {
			Chess chess = queue.poll();
			boolean chk = false;
			int minN = chess.n;
			int minX = chess.x;
			int minY = chess.y;
			
			for (int i = 0; i < 8; i++) {
				int nr = chess.x + dir[i][0];
				int nc = chess.y + dir[i][1];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if(minN > map[nr][nc]) {
					chk = true;
					minN = map[nr][nc];
					minX = nr;
					minY = nc;
				}
			}
			
			if(chk) {
				balls[minX][minY] += balls[chess.x][chess.y];
				balls[chess.x][chess.y] = 0;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(balls[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
