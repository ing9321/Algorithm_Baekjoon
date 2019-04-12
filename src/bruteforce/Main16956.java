package bruteforce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 16956 늑대와 양
 * https://www.acmicpc.net/problem/16956
 * brute force
 */
public class Main16956 {
	static int R, C;
	static char[][] map;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16956.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ArrayList<Point> wolves = new ArrayList<Point>();
		HashSet<Point> set = new HashSet<Point>();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'W') wolves.add(new Point(i, j));
			}
		}
		
		if(wolves.size() == 0) {
			bw.write("1\n");
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					bw.append(map[i][j]);
				}
				bw.append('\n');
			}
		} else {
			boolean flag = true;
			for (Point wolf : wolves) {
				for (int i = 0; i < 4; i++) {
					int nr = wolf.r + pos[i][0];
					int nc = wolf.c + pos[i][1];
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
					if(map[nr][nc] == 'S') {
						// 막을 수 없음
						flag = false;
						break;
					} else if(map[nr][nc] == '.') {
						set.add(new Point(nr,nc));
					}
				}
			}
			
			
			if(!flag) {
				bw.write("0\n");
			} else {
				bw.write("1\n");
				for (Point point : set) {
					map[point.r][point.c] = 'D';
				}
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						bw.append(map[i][j]);
					}
					bw.append('\n');
				}
			}
		}
		bw.flush();
	}
	private static class Point {
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
