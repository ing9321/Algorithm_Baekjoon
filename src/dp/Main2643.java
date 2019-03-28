package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 2643 색종이 올려놓기
 * https://www.acmicpc.net/problem/2643
 * dp
 */
public class Main2643 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2643.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		ArrayList<Paper> list = new ArrayList<Paper>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(c > r) {
				int tmp = r;
				r = c;
				c = tmp;
			}
			list.add(new Paper(r, c));
		}
		Collections.sort(list);
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if((list.get(i).r <= list.get(j).r) && (list.get(i).c <= list.get(j).c) && (dp[i] < dp[j]+1)) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	private static class Paper implements Comparable<Paper>{
		int r, c;

		public Paper(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Paper o) {
			if(o.r == this.r) {
				return o.c - this.c;
			}
			return o.r - this.r;
		}
	}
}
