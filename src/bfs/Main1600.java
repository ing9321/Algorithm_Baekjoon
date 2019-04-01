package bfs;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 1600 말이 되고픈 원숭이
 * https://www.acmicpc.net/problem/1600
 * bfs
 */
public class Main1600 {
	static int[][] horse = {{1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}, {-2,1}, {-1,2}};
	static int[][] monky = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1600.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		boolean[][][] visit = new boolean[K+1][H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0, 0, 0, 0});
		visit[0][0][0] = true;
		int C = 0;
		top:
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			int ck = cur[2];
			int cc = cur[3];
			if(ck < K) { // 말처럼 이동 가능
				for (int h = 0; h < horse.length; h++) {
					int nx = cx + horse[h][0];
					int ny = cy + horse[h][1];
					if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
					if(nx == H-1 && ny == W-1) { // 도착
						C = cc+1;
						break top;
					}
					if(!visit[ck+1][nx][ny] && map[nx][ny] == 0) {
						visit[ck+1][nx][ny] = true;
						queue.offer(new int[] {nx, ny, ck+1, cc+1});
					}
				}
			}
			
			for (int m = 0; m < monky.length; m++) {
				int nx = cx + monky[m][0];
				int ny = cy + monky[m][1];
				if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
				if(nx == H-1 && ny == W-1) { // 도착
					C = cc+1;
					break top;
				}
				if(!visit[ck][nx][ny] && map[nx][ny] == 0) {
					visit[ck][nx][ny] = true;
					queue.offer(new int[] {nx, ny, ck, cc+1});
				}
			}
		}
		System.out.println((C == 0 ? -1 : C));
	}
}
