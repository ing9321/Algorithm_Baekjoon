package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 봄버맨
public class Main16918 {
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16918.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < R; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < C; j++) {
				if(str.charAt(j) != '.') {
					map[i][j] = 2; // 폭탄설치는 1이지만 시작 후 1초간 아무 동작 안하기 때문에 default를 2로 줌
				}
			}
		}
		N--; // 1초간 아무작동 안함
		LinkedList<int[]> queue = new LinkedList<int[]>();
		while(N > 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j]++;
					if(map[i][j] > 3) {
						queue.add(new int[] {i, j});
					}
				}
			}
			while(!queue.isEmpty()) {
				int[] position = queue.poll();
				map[position[0]][position[1]] = 0;
				for (int j = 0; j < 4; j++) {
					int nx = position[0] + pos[j][0];
					int ny = position[1] + pos[j][1];
					if(nx>=0 && ny>=0 && nx<R && ny<C) {
						map[nx][ny] = 0;
					}
				}
			}
			N--;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0) {
					sb.append('O');
				} else {
					sb.append('.');
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
