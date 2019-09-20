package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 5052 전화번호 목록
 * https://www.acmicpc.net/problem/5052
 * 해싱, 트라이, 정렬
 */

public class Main5052 {
	public static int N;
	public static String[] numbers;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5052.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			numbers = new String[N];
			for (int i = 0; i < N; i++) {
				numbers[i] = br.readLine().trim();
			}
			Arrays.sort(numbers);
			
			boolean flag = false;
			for (int i = 0; i < N-1; i++) {
				if(numbers[i].length() < numbers[i+1].length()) {
					if(numbers[i+1].indexOf(numbers[i]) == 0) {
						flag = true;
						break;
					}
				}
			}
			
			if(flag) System.out.println("NO");
			else System.out.println("YES");
		}
	}
}
