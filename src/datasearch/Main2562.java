package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 2562 최대값
 * https://www.acmicpc.net/problem/2562
 * 
 * 주어진 9개의 숫자 중 최댓값과 숫자가 입력된 순서 출력
 */

public class Main2562 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2562.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		int idx = Integer.MIN_VALUE;
		for (int i = 1; i < 10; i++) {
			int tmp = Integer.parseInt(br.readLine().trim());
			if(tmp > max) {
				max = tmp;
				idx = i;
			}
		}
		System.out.println(max + "\n" + idx);
	}
}
