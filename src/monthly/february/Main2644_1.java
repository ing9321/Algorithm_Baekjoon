package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 촌수계산
public class Main2644_1 {
	static int N, M, p1, p2;
	static int[][] matrix;
	static int[] depth;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()); // 전체 사람 수
		matrix = new int[N+1][N+1];
		depth = new int[N+1];
		String[] strarr = br.readLine().split(" ");
		p1 = Integer.parseInt(strarr[0]); // 시작점
		p2 = Integer.parseInt(strarr[1]); // 도착점
		M = Integer.parseInt(br.readLine().trim());		// 관계의 개수
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken().trim());
			int c = Integer.parseInt(st.nextToken().trim());
			matrix[p][c] = 1;
			matrix[c][p] = 1;
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(p1);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i=1; i<=N; i++) {
				if(matrix[current][i] == 1 && depth[i] == 0) {
					depth[i] = depth[current] + 1;
					queue.offer(i);
				}
			}
		}
		if(depth[p2] != 0) {
			System.out.println(depth[p2]);
		} else {
			System.out.println(-1);
		}
	}
}
