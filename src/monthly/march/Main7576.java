package monthly.march;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 토마토
public class Main7576 {
	static int M, N, D;
	static int[][] box;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static LinkedList<int[]> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		queue = new LinkedList<int[]>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int m = 0; m < M; m++) {
				box[n][m] = Integer.parseInt(st.nextToken());
				if(box[n][m] == 1) {
					queue.offer(new int[] {n,m,0});
				}
			}
		}
		
		bfs();
		
		out :
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if(box[n][m] == 0) {
					D = -1;
					break out;
				}
			}
		}
		
		System.out.println(D);
	}
	private static void bfs() {
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			D = Math.max(D, current[2]);
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + pos[i][0];
				int ny = current[1] + pos[i][1];
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					if(box[nx][ny] == 0) {
						box[nx][ny] = 1;
						queue.offer(new int[] {nx, ny, D+1});
					}
				}
			}
		}
	}
}
