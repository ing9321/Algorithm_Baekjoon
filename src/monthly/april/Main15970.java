package monthly.april;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 부분 성공
 * 15970 화살표 그리기
 * https://www.acmicpc.net/problem/15970
 */
public class Main15970 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input15970.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] point = new int[N+1][100001];
		int Answer = 0;
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int position = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			point[color][position] = 1;
		}
		for (int i = 1; i <= N; i++) { // color
			if(point[i].length == 0) continue;
			for (int j = 0, size=point[i].length; j < size; j++) { // position
				if(point[i][j] == 0) continue;
				// 좌로 비교
				int lidx = j-1;
				int lcnt = 0;
				while(lidx >= 0) {
					if(point[i][lidx] != 0) {
						lcnt = j - lidx;
						break;
					} else {
						lidx--;
					}
				}
				// 우로 비교
				int ridx = j+1;
				int rcnt = 0;
				while(ridx < size) {
					if(point[i][ridx] != 0) {
						rcnt = ridx - j;
						break;
					} else {
						ridx++;
					}
				}
				int min = 0;
				if(lcnt == 0 || rcnt == 0) {
					min = lcnt + rcnt;
				} else {
					min = Math.min(lcnt, rcnt);
				}
				Answer += min;
			}
		}
		System.out.println(Answer);
	}
}
