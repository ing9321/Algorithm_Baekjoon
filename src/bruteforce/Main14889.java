package bruteforce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 14889 스타트와 링크
 * https://www.acmicpc.net/problem/14889
 * 브루트포스
 */

public class Main14889 {
	public static int N, N2, MIN;
	public static int[][] S;
	public static boolean[] selected;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input14889.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		N2 = N/2;
		MIN = Integer.MAX_VALUE;
		S = new int[N][N];
		selected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		comb(0, 0);
		System.out.println(MIN);
	}
	
	public static void comb(int idx, int cnt) {
		if(cnt == N2) {
			calc();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				comb(i, cnt+1);
				selected[i] = false;
			}
		}
	}

	public static void calc() {
		ArrayList<Integer> start = new ArrayList<Integer>(N/2);
		ArrayList<Integer> link = new ArrayList<Integer>(N/2);
		for (int i = 0; i < N; i++) {
			if(selected[i]) start.add(i);
			else link.add(i);
		}
		
		int startS = 0;
		for (int i = 0; i < N2; i++) {
			for (int j = i+1; j < N2; j++) {
				startS += S[start.get(i)][start.get(j)];
				startS += S[start.get(j)][start.get(i)];
			}
		}
		int linkS = 0;
		for (int i = 0; i < N2; i++) {
			for (int j = i+1; j < N2; j++) {
				linkS += S[link.get(i)][link.get(j)];
				linkS += S[link.get(j)][link.get(i)];
			}
		}
		MIN = Math.min(MIN, Math.abs(startS - linkS));
	}
}
