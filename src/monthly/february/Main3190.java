package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 뱀
public class Main3190 {
	static int[][] pos = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // 위 오른쪽 아래 왼쪽
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3190.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		int K = Integer.parseInt(br.readLine().trim()); // 사과 개수
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		int cnt = 0;
		boolean live = true;
		int idx = 1; // pos 배열의 idx = 뱀의 진행 방향
		int x = 0;
		int y = 0;
		LinkedList<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x,y));
		// 뱀 방향 변환 횟수
		int L = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < L; i++) {
			System.out.println(idx);
			if(!live) {
				break;
			}
			st = new StringTokenizer(br.readLine().trim());
			// x만큼 이동
			int X = Integer.parseInt(st.nextToken());
			for (int k = cnt; k < X; k++) {
				int nx = x+pos[idx][0];
				int ny = y+pos[idx][1];
				cnt++;
				// 맵을 벗어나거나 자기 몸에 부딪히면 종료
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 2) {
					live = false;
					break;
				}
				if(map[nx][ny] == 1) {
					map[nx][ny] = 0;
				} else {
					queue.poll();
				}
				queue.offer(new Point(nx, ny));
				x = nx;
				y = ny;
			}

			// 방향전환 : 왼쪽:L 또는 오른쪽:D
			String dir = st.nextToken();
			if(dir.equals("D")) { // 오른쪽
				idx++;
				if(idx >= 4) {
					idx -= 4;
				}
			} else { // 왼쪽
				idx--;
				if(idx < 0) {
					idx += 4;
				}
			}
			
			System.out.println(idx);
			for (int j = 0; j < N; j++) {
				System.out.println(Arrays.toString(map[j]));
			}
			
		}
		while(live) {
			int nx = x+pos[idx][0];
			int ny = y+pos[idx][1];
			System.out.println(x + " " + y + " -> " + nx + " " + ny);
			cnt++;
			// 맵을 벗어나거나 자기 몸에 부딪히면 종료
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 2) {
				live = false;
				break;
			}
			if(map[nx][ny] == 1) {
				map[nx][ny] = 2;
			}
			map[x][y] = 0;
			x = nx;
			y = ny;
			map[x][y] = 2;
		}
		System.out.println(cnt);
	}
	private static void move() {
		
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
