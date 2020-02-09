package arithmetic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 행렬 곱셈
 * https://www.acmicpc.net/problem/2740
 * 분할 정복
 * 
 * NxM행렬, MXK행렬의 곱셈
 */

public class Main2740 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2740.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken().trim());
		int M = Integer.parseInt(st.nextToken().trim());
		int[][] metrixA = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				metrixA[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken().trim());
		int K = Integer.parseInt(st.nextToken().trim());
		int[][] metrixB = new int[M][K];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < K; j++) {
				metrixB[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		
		int tmp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				tmp = 0;
				for (int k = 0; k < M; k++) {
					tmp += metrixA[i][k] * metrixB[k][j];
				}
				bw.append(tmp + " ");
			}
			bw.append("\n");
		}
		bw.flush();
	}
}
