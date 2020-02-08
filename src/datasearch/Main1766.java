package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 1766 문제집
 * https://www.acmicpc.net/problem/1766
 * 힙, 위상정렬
 * 
 */

public class Main1766 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1766.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken().trim()); // 문제의 수
		int M = Integer.parseInt(st.nextToken().trim()); // 먼저 푸는 것이 좋은 문제에 대한 정보 개수
		int[] indegree = new int[N+1];
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int n = 0; n <= N; n++) {
			list.add(new ArrayList<Integer>());
		}
		
		// A번 문제는 B번 문제보다 먼저 푸는 것이 좋다.
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken().trim());
			int b = Integer.parseInt(st.nextToken().trim());
			list.get(a).add(b);
			indegree[b]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0) pq.add(i);
		}
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			System.out.print(cur + " ");
			
			for (int i = 0, size = list.get(cur).size(); i < size; i++) {
				int next = list.get(cur).get(i);
				indegree[next]--;
				if(indegree[next] == 0) {
					pq.add(next);
				}
			}
		}
	}

}
