package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2163 초콜렛자르기
 * https://www.acmicpc.net/problem/2163
 * 다이나믹 프로그래밍
 * 
 * NxM 초콜렛을 1x1로 나누는 최소 횟수
 */
public class Main2163 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		// int C = (N-1) + (N * (M-1));
		int C = N * M - 1;
		System.out.println(C);
	}
}
