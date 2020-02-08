package bruteforce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1966 프린트 큐
 * https://www.acmicpc.net/problem/1966
 * 브루트포스, 큐, 시뮬레이션
 * 
 * 문서의 순서와 중요도를 가진 큐와 문서를 중요도 순으로 정렬할 우선순위 큐
 */

public class Main1966 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M, p;
		Queue<int[]> list = new LinkedList<int[]>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken().trim()); // 문서의 수
			M = Integer.parseInt(st.nextToken().trim()); // 궁금한 문서 index
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				p = Integer.parseInt(st.nextToken().trim());
				list.add(new int[] {i, p});
				pq.add(p);
			}
			
			int cnt = 0;
			while(!list.isEmpty()) {
				int curidx = list.peek()[0];
				int curpri = list.peek()[1];
				list.poll();
				
				if(curpri == pq.peek()) {
					cnt++;
					pq.poll();
					if(curidx == M) {
						System.out.println(cnt);
						break;
					}
				} else {
					list.add(new int[] {curidx,curpri});
				}
			}
			
			list.clear();
			pq.clear();
		}
	}

}
