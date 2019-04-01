package arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1475 방 번호
 * https://www.acmicpc.net/problem/1475
 * 수학, 문자열처리
 */
public class Main1475 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charr = br.readLine().toCharArray();
		int[] numset = new int[9];
		for (int i = 0, size=charr.length; i < size; i++) {
			int num = charr[i] - '0';
			if(num == 9) {
				numset[6]++;
			} else {
				numset[num]++;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 9; i++) {
			if(i == 6) {
				int tmp = numset[6] / 2;
				if(numset[6] % 2 == 1) {
					tmp += 1;
				}
				max = Math.max(max, tmp);
			} else {
				max = Math.max(max, numset[i]);
			}
		}	
		System.out.println(max);
	}
}
