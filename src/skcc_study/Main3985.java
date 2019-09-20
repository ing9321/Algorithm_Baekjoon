package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 3985 롤 케이크
 * https://www.acmicpc.net/problem/3985
 * Simulation
 */

public class Main3985 {
	public static boolean[] cakes;
	public static int L, N, E, En, T, Tn;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3985.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine().trim());
		N = Integer.parseInt(br.readLine().trim());
		cakes = new boolean[L+1];
		E = 0;
		En = 0;
		T = 0;
		Tn = 0;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int P = Integer.parseInt(st.nextToken().trim());
			int K = Integer.parseInt(st.nextToken().trim());
			
			if(En < K-P+1) {
				En = K-P+1;
				E = i+1;
			}
			int tmp = 0;
			for (int j = P; j <= K; j++) {
				if(!cakes[j]) {
					cakes[j] = true;
					tmp++;
				}
			}
			if(Tn < tmp) {
				Tn = tmp;
				T = i+1;
			}
		}
		System.out.println(E);
		System.out.println(T);
	}
}