package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연결 요소의 갯수
/*
 * 11724 연결 요소의 갯수
 * https://www.acmicpc.net/problem/11724
 * dfs (DFS or BFS)
 */
public class Main11724 {
	static int N, M, C;
	static int[][] map;
	static int[] visit;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input11724.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken().trim()); // 정점
		M = Integer.parseInt(st.nextToken().trim()); // 간선
		map = new int[N+1][N+1];
		visit = new int[N+1];
		for(int i=0; i<M; i++){
			StringTokenizer stn = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(stn.nextToken().trim());
			int v= Integer.parseInt(stn.nextToken().trim());
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		for(int i=1; i<=N; i++){
			if(visit[i] != 1){
				C++;
				dfs(i);
			}
		}
		System.out.println(C);
	}
	public static void dfs(int v) {
		visit[v] = 1;
		for(int i=1; i<=N; i++) {
			if(map[v][i] == 1 && visit[i] == 0) {
				dfs(i);
			}
		}
	}
}
