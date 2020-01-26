package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1182 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 * 비트마스크
 */

public class Main1182_2 {
	public static int N, S, C;
	public static int[] data; // 수열
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1182.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken().trim());
		S = Integer.parseInt(st.nextToken().trim());
		C = 0;
		data = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken().trim());
		}
		
		for (int i = 1, size = 1<<N; i < size; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if((i & 1<<j) != 0) {
					sum += data[j];
				}
			}
			if(sum == S) C++;
		}
		System.out.println(C);
	}

}
