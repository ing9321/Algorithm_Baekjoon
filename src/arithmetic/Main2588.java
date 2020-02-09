package arithmetic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 2588 곱셈
 * https://www.acmicpc.net/problem/2588
 * 
 * 세자리 수 2개가 주어질 때,
 * 곱셈 연산 과정의 중간값과 최종값 출력
 */

public class Main2588 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input2588.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int str1 = Integer.parseInt(br.readLine().trim());
		String strb = br.readLine().trim();
		
		int tmp1 = str1 * (strb.charAt(2) - '0');
		int tmp2 = str1 * (strb.charAt(1) - '0');
		int tmp3 = str1 * (strb.charAt(0) - '0');
		int tmp4 = str1 * Integer.parseInt(strb);
		System.out.println(tmp1 + "\n" + tmp2 + "\n" + tmp3 + "\n" + tmp4);
	}
}
