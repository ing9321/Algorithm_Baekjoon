package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2468 {
	static int N, maxH, maxS;
	static int[][] map, flood;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2468.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] strarr = br.readLine().trim().split(" ");
			for(int j=0; j<N; j++) {
				int h = Integer.parseInt(strarr[j]);
				map[i][j] = h;
				maxH = Math.max(h, maxH);
			}
		}
		
		for(int i=0; i<=maxH; i++) {
			flood = new int[N][N];
			int result = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					// i 높이만큼 물에 잠길 때
					int temp = dfs(r, c, i);
					if(temp > 0) {
						result++;
					}
				}
			}
			maxS = Math.max(maxS, result);
		}
		System.out.println(maxS);
	}
	public static int dfs(int r, int c, int h) {
		if(map[r][c] <= h) { // 현재 위치가 물에 잠겼을 때
			flood[r][c] = 1;
		}
		if(flood[r][c] >= 1) { // 방문했으면 리턴
			return 0;
		}
		flood[r][c] = 2;
		int cnt = 1; // 안잠긴 지역 갯수
		for(int k=0, size=pos.length; k<size; k++) {
			int nr = r + pos[k][0];
			int nc = c + pos[k][1];
			if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
				cnt += dfs(nr, nc, h);
			}
		}
		return cnt;
	}
}
