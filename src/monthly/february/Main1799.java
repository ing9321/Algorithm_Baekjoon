package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 비숍
public class Main1799 {
	static int N, MAX;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/TSP.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int b = Integer.parseInt(st.nextToken());
				if(b > 0) {
					map[i][j] = 1;
					MAX++;
				}
			}
		}
		
		// 1 비숍 가능, 0 불가능
		
	}
}
