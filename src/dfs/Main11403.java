package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 11403 경로찾기
 * https://www.acmicpc.net/problem/11403
 * dfs (DFS or BFS, 플로이드 와샬)
 */
public class Main11403 {
	static int N;
	static int[][] map;
	static int[] visit;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input11403.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		
		for(int i=0; i<N; i++){
			String[] str = br.readLine().trim().split(" ");
			for(int j=0; j<N; j++){
				if(str[j].equals("1")){
					map[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<N; i++){
			visit = new int[N];
			dfs(i);
			map[i] = visit;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				sb.append(map[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int v) {
		for(int i=0; i<N; i++) {
			if(map[v][i] == 1 && visit[i] == 0) {
				visit[i] = 1;
				dfs(i);
			}
		}
	}
}