package bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 1260 DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */
public class Main1260 {
	static int N, M, V;
	static int[][] nodes;
	static boolean[] visit;
	static Queue<Integer> queue;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1260.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().trim().split(" ");
		N = Integer.parseInt(arr[0]); // 정점개수
		nodes = new int[N+1][N+1];
		visit = new boolean[N+1];
		queue = new LinkedList<Integer>();
		M = Integer.parseInt(arr[1]); // 간선개수
		V = Integer.parseInt(arr[2]); // 탐색시작 정점번호
		for(int i=0; i<M; i++) {
			String[] arr2 = br.readLine().trim().split(" ");
			int ver = Integer.parseInt(arr2[0]);
			int ver2 = Integer.parseInt(arr2[1]);
			nodes[ver][ver2] = ver2;
			nodes[ver2][ver] = ver;
		}
		dfs(V);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(V);
	}
	public static void dfs(int v) {
		System.out.print(v + " ");
		visit[v] = true;
		for(int i : nodes[v]) {
			int nv = i;
			if(nv > 0 && !visit[nv]) {
				dfs(nv);
			}
		}
	}
	public static void bfs(int v) {
		System.out.print(v + " ");
		visit[v] = true;
		for(int i : nodes[v]) {
			int nv = nodes[v][i];
			if(nv > 0 && !visit[nv]) {
				visit[nv] = true;
				queue.add(nv);
			}
		}
		if(!queue.isEmpty()) {
			bfs(queue.poll());			
		}
	}
}