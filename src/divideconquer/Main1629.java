package divideconquer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 1629 곱셈
 * https://www.acmicpc.net/problem/1629
 * 분할정복
 */
public class Main1629 {
	static int C;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1629.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strarr = br.readLine().split(" ");
		long A = Integer.parseInt(strarr[0]);
		long B = Integer.parseInt(strarr[1]);
		C = Integer.parseInt(strarr[2]);
		long result = power(A, B);
		System.out.println(result);
	}
	private static long power(long x, long y) {
		long ret = 1;
		while(y>0) {
			if(y%2 == 1) {
				ret *= x;
				ret %= C;
			}
			y /= 2;
			x *= x;
			x %= C;
		}
		return ret;
	}
}
