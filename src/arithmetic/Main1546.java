package arithmetic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1546 평균
 * https://www.acmicpc.net/problem/1546
 */
public class Main1546 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1546.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int M = 0;
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken().trim());
			sum += tmp;
			if(M < tmp) M = tmp;
		}

		double avg = 100.0 * sum / M / N;
		System.out.printf("%.2f", avg);
	}

}
