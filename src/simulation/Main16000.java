package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 미해결
 * 16000 섬
 * https://www.acmicpc.net/problem/16000
 */
public class Main16000 {
	static int N , M;
	static char[][] map;
	static LinkedList<int[]> queue;
	static int[][] pos = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16000.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		queue = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '#') queue.offer(new int[] {i,j});
			}
		}
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			System.out.println(Arrays.toString(current));
		}
	}
}
