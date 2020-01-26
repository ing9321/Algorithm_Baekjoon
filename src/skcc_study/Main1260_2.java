package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 1260 DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 * DFS, BFS
 */

public class Main1260_2 {
	public static int N, M, V;
	public static int[][] map;
	public static boolean[] visit;
	public static LinkedList<Integer> queue;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1260.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken().trim()); // 정점 개수
		M = Integer.parseInt(st.nextToken().trim()); // 간선 개수
		V = Integer.parseInt(st.nextToken().trim()); // 시작 정점
		
		map = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int s = Integer.parseInt(st.nextToken().trim());
			int e = Integer.parseInt(st.nextToken().trim());
			map[s][e] = 1;
			map[e][s] = 1;
		}
		visit = new boolean[N+1];
		dfs(V);
		System.out.println();
		
		queue = new LinkedList<Integer>();
		Arrays.fill(visit, false);
		bfs(V);
	}
	
	public static void dfs(int node) {
		System.out.print(node + " ");
		visit[node] = true;
		for (int i = 1; i <= N; i++) {
			if(!visit[i] && map[node][i] > 0) {
				dfs(i);
			}
		}
	}

	public static void bfs(int node) {
		System.out.print(node + " ");
		visit[node] = true;
		for (int i = 1; i <= N; i++) {
			if(!visit[i] && map[node][i] > 0) {
				visit[i] = true;
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			bfs(queue.poll());
		}
	}
}
