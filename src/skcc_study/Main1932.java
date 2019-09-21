package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 1932 정수삼각형
 * https://www.acmicpc.net/problem/1932
 * DP
 */

public class Main1932 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1932.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int size = (int) Math.pow(2, N);
		int[] dp = new int[size];
		dp[0] = Integer.parseInt(br.readLine().trim());
		for (int n = 2; n <= N; n++) {
			String[] arr = br.readLine().trim().split(" "); // n개 들어옴
			dp[n] = n;
		}
	}

}
