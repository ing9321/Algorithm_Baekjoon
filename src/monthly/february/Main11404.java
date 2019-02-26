package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드
public class Main11404 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input11404.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		int[][] matrix = new int[N][N];
		int max = Integer.MAX_VALUE>>1;
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(matrix[i], max);
			matrix[i][i] = 0;
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) -1;
			int b = Integer.parseInt(st.nextToken()) -1;
			int c = Integer.parseInt(st.nextToken());
			matrix[a][b] = Math.min(matrix[a][b], c);
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(matrix[i][k] != max && matrix[k][j] != max) {
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(matrix[i][j] == max) {
					matrix[i][j] = 0;
				}
				sb.append(matrix[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}