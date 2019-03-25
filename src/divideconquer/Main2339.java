package divideconquer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 미해결
 * 2339 석판자르기
 * https://www.acmicpc.net/problem/2339
 * (수학, 분할정복)
 */
public class Main2339 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2339.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
