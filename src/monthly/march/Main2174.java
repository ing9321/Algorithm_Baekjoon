package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 로봇 시뮬레이션
public class Main2174 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2174.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int A = Integer.parseInt(st.nextToken()); // C
		int B = Integer.parseInt(st.nextToken()); // R
		int[][] map = new int[B+1][A+1];
		st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken()); // 로봇 수
		int M = Integer.parseInt(st.nextToken()); // 명령 수
		HashMap<Integer, Robot> robots = new HashMap<Integer, Robot>();
		int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // E, N, W, S
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[x][y] = i;
			int d = 0;
			switch(st.nextToken().charAt(0)) {
			case 'E':
				break;
			case 'S':
				d = 3;
				break;
			case 'W':
				d = 2;
				break;
			case 'N':
				d = 1;
				break;
			}
			robots.put(i, new Robot(i, x, y, d));
		}

		String res = "OK";
		top : 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int robot = Integer.parseInt(st.nextToken()); // 로봇 번호
			char order = st.nextToken().charAt(0); // 명령
			int cnt = Integer.parseInt(st.nextToken()); // 반복횟수
			Robot target = robots.get(robot);
			while(cnt > 0) {
				cnt--;
				switch(order) {
				case 'L':
					target.d++;
					if(target.d >= 4) target.d -= 4;
					break;
				case 'R':
					target.d--;
					if(target.d < 0) target.d += 4;
					break;
				case 'F':
					int nx = target.x + pos[target.d][0];
					int ny = target.y + pos[target.d][1];
					if(nx < 1 || ny < 1 || nx > B || ny > A) {
						// 범위벗어남
						res = "Robot " + target.n + " crashes into the wall";
						break top;
					}
					if(map[nx][ny] > 0) {
						// 주인있어요!!
						res = "Robot " + target.n + " crashes into robot " + map[nx][ny];
						break top;
					}
					map[target.x][target.y]= 0;
					map[nx][ny] = target.n;
					target.x = nx;
					target.y = ny;
					break;
				}
				robots.replace(robot, target);
			}
		}
		System.out.println(res);
	}
	private static class Robot {
		int n, x, y, d;
		public Robot(int n, int x, int y, int d) {
			this.n = n;
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
