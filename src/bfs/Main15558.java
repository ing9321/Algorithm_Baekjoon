package bfs;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 15558 점프게임
 * https://www.acmicpc.net/problem/15558
 * bfs
 */
public class Main15558 {
	static int N, K, A;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input15558.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken().trim());
		K = Integer.parseInt(st.nextToken().trim());
		int[][] map = new int[2][N+1];
		boolean[][] visit = new boolean[2][N+1];
		for (int i = 0; i < 2; i++) {
			char[] charr = br.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				map[i][j] = charr[j-1]-'0';
			}
		}
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0, 1});
		visit[0][1] = true;
		int cnt = 1;
		top:
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] current = queue.poll();
				if(current[1]+1 > N || current[1]+K > N) {
					A = 1;
					break top;
				}
				
				// 1칸 전진
				if(!visit[current[0]][current[1] + 1] && map[current[0]][current[1] + 1] > 0) {
					visit[current[0]][current[1]+1] = true;
					queue.offer(new int[] {current[0], current[1]+1});
				}
				
				// 1칸 후진
				if(current[1] - 1 > cnt && !visit[current[0]][current[1] - 1] && map[current[0]][current[1] - 1] > 0) {
					visit[current[0]][current[1]-1] = true;
					queue.offer(new int[] {current[0], current[1]-1});
				}
				
				// 점프
				if(current[0] > 0) {
					if(!visit[0][current[1] + K] && map[0][current[1] + K] > 0) {
						visit[0][current[1]+K] = true;
						queue.offer(new int[] {0, current[1]+K});
					}
				} else {
					if(!visit[1][current[1] + K] && map[1][current[1] + K] > 0) {
						visit[1][current[1]+K] = true;
						queue.offer(new int[] {1, current[1]+K});
					}
				}
			}
			cnt++;
		}
		System.out.println(A);
	}
}
