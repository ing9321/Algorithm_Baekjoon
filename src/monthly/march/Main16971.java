package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main16971 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16971.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] mapA = new int[N][M];
		int[] rowSum = new int[N];
		int[] colSum = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				rowSum[i] += tmp;
				colSum[j] += tmp;
				mapA[i][j] = tmp;
			}
		}
		
		int row1 = rowSum[0];
		int r1 = 0;
		int row2 = rowSum[N-1];
		int r2 = N-1;
		if(row1 < row2) {
			row1 = rowSum[N-1];
			r1 = N-1;
			row2 = rowSum[0];
			r2 = 0;
		}
		for (int i = 0; i < N; i++) {
			if(rowSum[i] < row1) {
				row1 = rowSum[i];
				r1 = i;
			}
		}
		
		int col1 = colSum[0];
		int c1 = 0;
		int col2 = colSum[M-1];
		int c2 = M-1;
		if(col1 < col2) {
			col1 = colSum[M-1];
			c1 = M-1;
			col2 = colSum[0];
			c2 = 0;
		}
		for (int i = 0; i < M; i++) {
			if(colSum[i] < col1) {
				col1 = colSum[i];
				c1 = i;
			}
		}
		
		int rowB = 0;
		int colB = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(i != r1 && i != r2) {
					rowB += mapA[i][j];
				}
				if(j!=0 && j!=M-1) {
					rowB += mapA[i][j];
				}
				if(j!=0 && j!=M-1 && i != r1 && i != r2) {
					rowB += mapA[i][j];
				}
				rowB += mapA[i][j];
				
				if(j!=c1 && j!=c2) {
					colB += mapA[i][j];
				}
				if(i!=0 && i!=N-1) {
					colB += mapA[i][j];
				}
				if(j!=c1 && j!=c2 && i!=0 && i!=N-1) {
					colB += mapA[i][j];
				}
				colB += mapA[i][j];
			}
		}
		
		System.out.println(Math.max(rowB, colB));
	}
}
