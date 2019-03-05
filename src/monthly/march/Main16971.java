package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열 B의 값
public class Main16971 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16971.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[] rowSum = new int[N];
		int[] colSum = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				rowSum[i] += tmp;
				colSum[j] += tmp;
				map[i][j] = tmp;
			}
		}
		
		//////// row 이동
		int fixedRow1 = 0; // 무조건 둘 중 하나 고정
		int fixedRow2 = N-1; // 안에꺼중에 작은 애
		if(rowSum[0] > rowSum[N-1]) {
			fixedRow1 = N-1;
			fixedRow2 = 0;
		}
		for (int i = 1; i < N-1; i++) {
			if(rowSum[fixedRow2] > rowSum[i]) {
				fixedRow2 = i;
			}
		}
		System.out.println(fixedRow1 + " " + fixedRow2);
		int maxRow = map[fixedRow1][0] + map[fixedRow1][M-1] + map[fixedRow2][0] + map[fixedRow2][M-1];
		for (int i = 0; i < N; i++) {
			if(i != fixedRow1 && i != fixedRow2) {
				maxRow += rowSum[i] << 1;				
			}
		}
		for (int i = 1; i < M-1; i++) {
			maxRow += colSum[i] << 1;
		}
		System.out.println(maxRow);
		
		
		/////// col 이동
		int fixedCol1 = 0; // 무조건 둘 중 하나 고정
		int fixedCol2 = M-1; // 안에꺼중에 작은 애
		if(colSum[0] > colSum[M-1]) {
			fixedCol1 = M-1;
			fixedCol2 = 0;
		}
		for (int i = 1; i < M-1; i++) {
			if(colSum[fixedCol2] > colSum[i]) {
				fixedCol2 = i;
			}
		}
		System.out.println(fixedCol1 + " " + fixedCol2);
		int maxCol = map[0][fixedCol1] + map[N-1][fixedCol1] + map[0][fixedCol2] + map[N-1][fixedCol2];
		for (int i = 0; i < M; i++) {
			if(i != fixedCol1 && i != fixedCol2) {
				maxCol += colSum[i] << 1;				
			}
		}
		for (int i = 1; i < N-1; i++) {
			maxCol += rowSum[i] << 1;
		}
		System.out.println(maxCol);

		
		System.out.println(Math.max(maxRow, maxCol));
	}
}
