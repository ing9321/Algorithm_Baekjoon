package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2455 지능형 기차
 * https://www.acmicpc.net/problem/2455
 * Simulation
 */

public class Main2455 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2455.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int M = 0;
		int tmp = 0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine().trim());
			tmp -= Integer.parseInt(st.nextToken().trim());
			tmp += Integer.parseInt(st.nextToken().trim());
			M = Math.max(M, tmp);
		}
		System.out.println(M);
	}
}