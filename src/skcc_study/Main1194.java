package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 1194 달이 차오른다 가자
 * https://www.acmicpc.net/problem/1194
 * 미해결
 * 
 * 빈 곳 : 언제나 이동할 수 있다. ('.‘로 표시됨)
벽 : 절대 이동할 수 없다. (‘#’)
열쇠 : 언제나 이동할 수 있다. 이 곳에 처음 들어가면 열쇠를 집는다. (a - f) 6
문 : 대응하는 열쇠가 있을 때만 이동할 수 있다. (A - F)
민식이의 현재 위치 : 빈 곳이고, 민식이가 현재 서 있는 곳이다. (숫자 0)
출구 : 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. (숫자 1)
탈출 최소 이동거리
 */

class MoonMiro {
	int x, y, step, visit;
	boolean[] keys;
	public MoonMiro(int x, int y) {
		this.x = x;
		this.y = y;
		this.step = 0;
		this.visit = 0;
		keys = new boolean[6];
	}
	public MoonMiro(int x, int y, int step, int visit, boolean[] keys) {
		this.x = x;
		this.y = y;
		this.step = step;
		this.visit = visit;
		this.keys = new boolean[6];
		System.arraycopy(keys, 0, this.keys, 0, 6);
	}
	public boolean getKey(char ch) {
		if(ch == 'a') {
			return true;
		} else if(ch == 'b') {
			return true;
		} else if(ch == 'c') {
			return true;
		} else if(ch == 'd') {
			return true;
		} else if(ch == 'e') {
			return true;
		} else if(ch == 'f') {
			return true;
		}
		return false;
	}
	public boolean isKey(char ch) {
		System.out.println(ch);
		if(ch == 'A' && keys[0]) {
			return true;
		} else if(ch == 'B' && keys[1]) {
			return true;
		} else if(ch == 'C' && keys[2]) {
			return true;
		} else if(ch == 'D' && keys[3]) {
			return true;
		} else if(ch == 'E' && keys[4]) {
			return true;
		} else if(ch == 'F' && keys[5]) {
			return true;
		}
		return false;
	}
}
public class Main1194 {

	public static int N, M, sr, sc, MIN;
	public static char[][] map;
	public static boolean[][][] visit;
	public static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1194.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken().trim());
		M = Integer.parseInt(st.nextToken().trim());
		map = new char[N][M];
		visit = new boolean[N][M][3];
		MIN = Integer.MAX_VALUE;
		LinkedList<MoonMiro> queue = new LinkedList<MoonMiro>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
				if(ch == '0') {
					queue.add(new MoonMiro(i, j));
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		while(!queue.isEmpty()) {
			MoonMiro cur = queue.poll();
			System.out.println(cur);
			System.out.println("cur: " + cur.x + " " + cur.y + " " + cur.step);
			System.out.println(Arrays.toString(cur.keys));
			
			for (int j = 0; j < 4; j++) {
				int nx = cur.x + dir[j][0];
				int ny = cur.y + dir[j][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || cur.visit > 2 || visit[nx][ny][cur.visit]) continue;
				System.out.println(map[nx][ny]);
				
				if(map[nx][ny] == '#') {
					System.out.println(nx + " " + ny + " 벽");
					continue;
				} else if(map[nx][ny] == '1') {
					System.out.println(nx + " " + ny + " 탈출");
					MIN = Math.max(MIN, cur.visit+1);
				} else if(map[nx][ny] == '0' || map[nx][ny] == '.') {
					System.out.println(nx + " " + ny + " 패스");
					visit[nx][ny][cur.visit+1] = true;
					queue.add(new MoonMiro(nx, ny, cur.step+1, cur.visit+1, cur.keys));
				} else if(cur.getKey(map[nx][ny])) {
					System.out.println(nx + " " + ny + " 키");
					MoonMiro m = new MoonMiro(nx, ny, cur.step+1, cur.visit+1, cur.keys);
					visit[nx][ny][cur.visit+1] = true;
//					System.out.println(map[nx][ny]- 97);
					m.keys[map[nx][ny] - 97] = true;
					queue.add(m);
				} else if(cur.isKey(map[nx][ny])){
					System.out.println(cur.isKey(map[nx][ny]));
					System.out.println(nx + " " + ny + " 문");
					visit[nx][ny][cur.visit+1] = true;
					queue.add(new MoonMiro(nx, ny, cur.step+1, cur.visit+1, cur.keys));
				}
			}
			System.out.println("--------");
		}
		
		if(MIN == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(MIN);
		}
	}
}
