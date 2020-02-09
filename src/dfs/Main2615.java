package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2615 오목
 * https://www.acmicpc.net/problem/2615
 * DFS
 * 
 * 19x19 오목판. 검은돌 1, 흰돌2, 빈칸0. 6개는 해당 없음
 * 검은 색이 이긴 경우 1, 흰 색이 이긴 경우 2, 아직 승부가 나지 않은 경우 0
 * 
 * ** 연속된 5개의 돌 확인 후 시작점 기준 반대 방향 포함 6개인지 확인하기
 */

public class Main2615 {
	public static int winner = 0, wr = 0, wc = 0, d = 0;
	public static boolean flag = false;
	public static int[][] map;
	public static int[][] dir = {{-1,1}, {0,1}, {1,1}, {1,0}};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input2615.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[20][20];
		
		for (int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j < 20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		
		top:
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if(map[i][j] > 0) {
					winner = map[i][j];
					wr = i;
					wc = j;
					for (int k = 0; k < 4; k++) {
						d = k;
						dfs(i, j, 1);
						if(flag) break top;
					}
				}
			}
		}
		
		if(flag) {
			System.out.println(winner + "\n" + wr + " " + wc);
		} else {
			System.out.println(0);
		}
	}

	public static void dfs(int r, int c, int cnt) {
		int nr = r + dir[d][0];
		int nc = c + dir[d][1];
		if(cnt == 5) {
			int nnr = wr - dir[d][0];
			int nnc = wc - dir[d][1];
			boolean f = true;
			if(nnr > 0 && nnr < 20 && nnc > 0 && nnc < 20 && map[nnr][nnc] == winner) {
				f = false;
			}
			if(nr > 0 && nr < 20 && nc > 0 && nc < 20 && map[nr][nc] == winner) {
				f = false;
			}
			if(f) {
				flag = true;
			}
			return;
		}
		
		if(nr > 0 && nr < 20 && nc > 0 && nc < 20 && map[nr][nc] == winner) {
			dfs(nr, nc, cnt+1);
		}
	}
}