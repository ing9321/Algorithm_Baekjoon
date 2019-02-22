package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 촌수계산
public class Main2644 {
	static class Node {
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Family [vertex=");
			builder.append(vertex);
			builder.append(", link=");
			builder.append(link);
			builder.append("]");
			return builder.toString();
		}
	}
	static int N, M, p1, p2, cnt;
	static Node[] matrix;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()); // 전체 사람 수
		matrix = new Node[N+1];
		visit = new boolean[N+1];
		// 촌수 계산 해야하는 두 사람
		String[] strarr = br.readLine().split(" ");
		p1 = Integer.parseInt(strarr[0]); // 시작점
		p2 = Integer.parseInt(strarr[1]); // 도착점
		// 관계의 개수
		M = Integer.parseInt(br.readLine().trim());
		cnt = 0;
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken().trim());
			int c = Integer.parseInt(st.nextToken().trim());
			matrix[p] = new Node(c, matrix[p]);
			matrix[c] = new Node(p, matrix[c]);			
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
				Node temp = matrix[current];
				cnt++;
				while(temp != null) {
					sub++;
					if(!visit[temp.vertex]) {
						queue.offer(temp.vertex);
					}
					temp = temp.link;
				}
			}
		}
		System.out.println(sub);
		System.out.println(Arrays.toString(visit));
	}

}
