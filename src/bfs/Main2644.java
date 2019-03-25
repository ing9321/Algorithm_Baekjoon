package bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
 * 2644 촌수계산
 * https://www.acmicpc.net/problem/2644
 * bfs
 */
public class Main2644 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int[][] matrix = new int[n+1][n+1];
		int[] depth = new int[n+1];
		String[] strarr = br.readLine().split(" ");
		int n1 = Integer.parseInt(strarr[0]);
		int n2 = Integer.parseInt(strarr[1]);
		int m = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < m; i++) {
			strarr = br.readLine().split(" ");
			int x = Integer.parseInt(strarr[0]);
			int y = Integer.parseInt(strarr[1]);
			matrix[x][y] = 1;
			matrix[y][x] = 1;
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(n1);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 1; i <= n; i++) {
				if(matrix[current][i] == 1 && depth[i] == 0) {
					depth[i] = depth[current] + 1;
					queue.offer(i);
				}
			}
		}
		
		if(depth[n2] > 0) {
			System.out.println(depth[n2]);
		} else {
			System.out.println("-1");
		}
	}
}
