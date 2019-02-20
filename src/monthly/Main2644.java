package monthly;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2644 {
	static int N, M, p1, p2, cnt;
	static int[][] family;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()); // 전체 사람 수
		// 촌수 계산 해야하는 두 사람
		String[] strarr = br.readLine().split(" ");
		p1 = Integer.parseInt(strarr[0]);
		p2 = Integer.parseInt(strarr[1]);
		// 관계의 개수
		M = Integer.parseInt(br.readLine().trim());
		cnt = -1;
		family = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken().trim());
			int c = Integer.parseInt(st.nextToken().trim());
			family[p][c] = p;
			family[c][p] = c;
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(Arrays.toString(family[i]));
		}

		bfs();
		System.out.println(cnt);
	}
	private static void bfs() {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(p1);
		visit[p1] = true;
		
		while(!queue.isEmpty()) {
			System.out.println(queue);
			cnt++;
			int p = queue.poll();
			System.out.println("parent : " + p);
			if(p == p2) {
				break;
			}
			for(int i=1; i<=N; i++) {
				if(family[p][i] > 0 && !visit[i]) {
					System.out.println("next : " + family[p][i]);
					visit[i] = true;
					queue.offer(family[p][i]);
				}
			}
		}
	}

}
