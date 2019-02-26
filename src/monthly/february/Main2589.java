package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 보물섬
public class Main2589 {
	static int R, C, MAX;
	static char[][] map;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2589.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 가로
		C = Integer.parseInt(st.nextToken()); // 세로
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'W') {
					continue;
				}
				MAX = Math.max(MAX, bfs(i, j));
			}
		}
		System.out.println(MAX);
	}
	private static int bfs(int i, int j) {
		LinkedList<Point> queue = new LinkedList<Point>();
		boolean[][] visited = new boolean[R][C];
		int[][] distance = new int[R][C];
		queue.offer(new Point(i, j));
		visited[i][j] = true;
		int max = 0;
		while(!queue.isEmpty()){
			Point current = queue.poll();
			int x = current.x;
			int y = current.y;
			for (int p=0, ps=pos.length; p<ps; p++) {
				int nx = x + pos[p][0];
				int ny = y + pos[p][1];
				if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if(!visited[nx][ny] && map[nx][ny] == 'L') {
						queue.offer(new Point(nx, ny));
						visited[nx][ny] = true;
						distance[nx][ny] = distance[x][y] + 1;
						max = Math.max(max, distance[nx][ny]);
					}
				}
			}
		}
		return max;
	}
	private static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}