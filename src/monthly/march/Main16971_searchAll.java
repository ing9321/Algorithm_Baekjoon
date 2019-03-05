package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열 B의 값
public class Main16971_searchAll {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16971.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[] rowSum = new int[N];
		int[] colSum = new int[M];
		int allSum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				allSum += tmp;
				rowSum[i] += tmp;
				colSum[j] += tmp;
			}
		}
		int max = Integer.MIN_VALUE;
		int tmp;
		// col 교환 검사
		for (int i = 0; i < M; i++) {
			// 0이 고정
			if(i != 0) {
				tmp = (allSum * 4) - ((colSum[0] + colSum[i]) * 2) - ((rowSum[0] + rowSum[N-1]) * 2) 
						+ (map[0][0] + map[N-1][0] + map[0][i] + map[N-1][i]);
				max = Math.max(max, tmp);
			}
			// M-1이 고정
			if(i != M-1) {
				tmp = (allSum * 4) - ((colSum[M-1] + colSum[i]) * 2) - ((rowSum[N-1] + rowSum[0]) * 2) 
						+ (map[0][M-1] + map[N-1][M-1] + map[0][i] + map[N-1][i]);
				max = Math.max(max, tmp);
			}
		}
		// row 교환 검사
		for (int i = 0; i < N; i++) {
			// 0이 고정
			if(i != 0) {
				tmp = (allSum * 4) - ((rowSum[0] + rowSum[i]) *2) - ((colSum[0] + colSum[M-1]) * 2) 
						+ (map[0][0] + map[0][M-1] + map[i][0] + map[i][M-1]);
				max = Math.max(max, tmp);
			}
			// N-1이 고정
			if(i != N-1) {
				tmp = (allSum * 4) - ((rowSum[N-1] + rowSum[i]) * 2) - ((colSum[0] + colSum[M-1]) * 2) 
						+ (map[N-1][0] + map[N-1][M-1] + map[i][0] + map[i][M-1]);
				max = Math.max(max, tmp);
			}
		}
		
		System.out.println(max);
	}
}
