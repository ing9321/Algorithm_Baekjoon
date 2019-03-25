package monthly.april;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 부분 해결
 * 15973 두 박스
 * https://www.acmicpc.net/problem/15973
 * 
 */
public class Main15973 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input15973.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		Square P = new Square(x1, y1, x2, y2);
		minX = Math.min(minX, x1);
		minY = Math.min(minY, y1);
		maxX = Math.max(maxX, x2);
		maxY = Math.max(maxY, y2);
		st = new StringTokenizer(br.readLine().trim());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		Square Q = new Square(x1, y1, x2, y2);
		minX = Math.min(minX, x1);
		minY = Math.min(minY, y1);
		maxX = Math.max(maxX, x2);
		maxY = Math.max(maxY, y2);
		
		int R = maxX-minX+1;
		int C = maxY-minY+1;
		int[][] map = new int[R][C];
		for (int i = P.x1-minX; i <= P.x2-minX; i++) {
			for (int j = P.y1-minY; j <= P.y2-minY; j++) {
				map[i][j]++;
			}
		}
		for (int i = Q.x1-minX; i <= Q.x2-minX; i++) {
			for (int j = Q.y1-minY; j <= Q.y2-minY; j++) {
				map[i][j]++;
			}
		}
		String res = "NULL";
		top:
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 1) {
					if(map[i+1][j+1] == 2) {
						// face
						res = "FACE";
					} else if(i+1 < R && map[i+1][j] == 2) {
						// line
						res = "LINE";
					} else if(j+1 < C && map[i][j+1] == 2) {
						// line
						res = "LINE";
					} else {
						// point
						res = "POINT";
					}
					break top;
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(res);
	}
	private static class Square {
		int x1;
		int y1;
		int x2;
		int y2;
		public Square(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;		
		}
	}
}
