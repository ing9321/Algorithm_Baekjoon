package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 촌수계산
public class Main2645_1 {
	static int N, M, p1, p2, cnt;
	static int[][] matrix;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()); // 전체 사람 수
		matrix = new int[N+1][N+1];
		visit = new boolean[N+1];
		String[] strarr = br.readLine().split(" ");
		p1 = Integer.parseInt(strarr[0]); // 시작점
		p2 = Integer.parseInt(strarr[1]); // 도착점
		M = Integer.parseInt(br.readLine().trim());		// 관계의 개수
		cnt = 0;
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken().trim());
			int c = Integer.parseInt(st.nextToken().trim());
			matrix[p][c] = 1;
			matrix[c][p] = 1;			
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(i + " : " + matrix[i]);
		}

		bfs();
		System.out.println(cnt);
	}
	private static void bfs() {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(p1);
		int sub = 0;
		while(!queue.isEmpty()) {
			System.out.println(queue);
			int current = queue.poll();
			if(current == p2) {
				break;
			}
			if(!visit[current]) {
				System.out.println("visit : " + current);
				visit[current] = true; // 방문처리
//				Node temp = matrix[current];
//				cnt++;
//				while(temp != null) {
//					sub++;
//					if(!visit[temp.vertex]) {
//						queue.offer(temp.vertex);
//					}
//					temp = temp.link;
//				}
			}
		}
		System.out.println(sub);
		System.out.println(Arrays.toString(visit));
	}

}
