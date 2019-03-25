package bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 7569 토마토(3차원)
 * https://www.acmicpc.net/problem/7569
 * bfs
 */
public class Main7569 {
	static int M, N, H, D;
	static int[][][] box;
	static int[][] pos = {{0,0,1}, {0,1,0}, {0,0,-1}, {0,-1,0}, {1,0,0}, {-1,0,0}};
	static LinkedList<int[]> queue;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/prep/input2606.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		queue = new LinkedList<int[]>();
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int m = 0; m < M; m++) {
					box[h][n][m] = Integer.parseInt(st.nextToken());
					if(box[h][n][m] == 1) {
						// 익은 토마토 기준으로 익히기 위해서 위치랑 날짜를 queue에 저장
						queue.offer(new int[] {h,n,m,0});
					}
				}
			}
		}
		
		bfs(); // 토마토 익히기
		
		// 안익은 토마토 확인하기
		out :
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if(box[h][n][m] == 0) {
						D = -1;
						break out;
					}
				}
			}
		}
		
		System.out.println(D);
	}
	private static void bfs() {
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			D = Math.max(D, current[3]); // 항상 최대 일 수 확인하고 갖고있기
			for (int i = 0; i < 6; i++) {
				int nh = current[0] + pos[i][0];
				int nx = current[1] + pos[i][1];
				int ny = current[2] + pos[i][2];
				if(nx>=0 && ny>=0 && nx<N && ny<M && nh>=0 && nh<H) {
					if(box[nh][nx][ny] == 0) {
						box[nh][nx][ny] = 1;
						queue.offer(new int[] {nh, nx, ny, D+1});
					}
				}
			}
		}
	}
}
