package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 12100 2048(Easy)
 * https://www.acmicpc.net/problem/12100
 */

public class Main12100_2 {
	public static int N, A;
	public static int[][] origin;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input12100.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		origin = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		A = 0;
		play(0, origin);
		System.out.println(A);
		
	}

	public static void play(int cnt, int[][] map) {
		System.out.println(cnt);
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		if(cnt == 5) {
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					res = Math.max(res, map[i][j]);
				}
			}
			A = Math.max(A, res);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			switch(i) {
			case 0:
				System.out.println("up");
				play(cnt+1, up(map));
				break;
			case 1:
				System.out.println("down");
				play(cnt+1, down(map));
				break;
			case 2:
				System.out.println("left");
				play(cnt+1, left(map));
				break;
			case 3:
				System.out.println("right");
				play(cnt+1, right(map));
				break;
			}
		}
	}
	
	public static int[][] up(int[][] map){
		int[][] tmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			Stack<Integer> stack = new Stack<Integer>();
			boolean used = false;
			for (int j = 0; j < N; j++) {
				if(map[j][i] == 0) {
					continue;
				} else if(!stack.isEmpty() && !used && stack.peek() == map[j][i]) {
					stack.pop();
					stack.push(map[j][i]*2);
					used = true;
				} else {
					stack.push(map[j][i]);
					used = false;
				}
			}
			while(!stack.isEmpty()) {
				tmap[stack.size()-1][i] = stack.pop();
			}
		}
		return tmap;
	}
	
	public static int[][] down(int[][] map){
		int[][] tmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			Stack<Integer> stack = new Stack<Integer>();
			boolean used = false;
			for (int j = N-1; j >= 0; j--) {
				if(map[j][i] == 0) {
					continue;
				} else if(!stack.isEmpty() && !used && stack.peek() == map[j][i]) {
					stack.pop();
					stack.push(map[j][i]*2);
					used = true;
				} else {
					stack.push(map[j][i]);
					used = false;
				}
			}
			int size = stack.size();
			for (int j = N-size; j < N; j++) {
				tmap[j][i] = stack.pop();
			}
		}
		return tmap;
	}
	
	public static int[][] left(int[][] map){
		int[][] tmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			Stack<Integer> stack = new Stack<Integer>();
			boolean used = false;
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					continue;
				} else if(!stack.isEmpty() && !used && stack.peek() == map[i][j]) {
					stack.pop();
					stack.push(map[i][j]*2);
					used = true;
				} else {
					stack.push(map[i][j]);
					used = false;
				}
			}
			while(!stack.isEmpty()) {
				tmap[i][stack.size()-1] = stack.pop();
			}
		}
		return tmap;
	}
	
	public static int[][] right(int[][] map){
		int[][] tmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			Stack<Integer> stack = new Stack<Integer>();
			boolean used = false;
			for (int j = N-1; j >= 0; j--) {
				if(map[i][j] == 0) {
					continue;
				} else if(!stack.isEmpty() && !used && stack.peek() == map[i][j]) {
					stack.pop();
					stack.push(map[i][j]*2);
					used = true;
				} else {
					stack.push(map[i][j]);
					used = false;
				}
			}
			int size = stack.size();
			for (int j = N-size; j < N; j++) {
				tmap[i][j] = stack.pop();
			}
		}
		return tmap;
	}
}
