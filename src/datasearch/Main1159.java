package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 1159 농구경기
 * https://www.acmicpc.net/problem/1159
 * Array
 */
public class Main1159 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1159.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26];
		int N = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			char first = br.readLine().trim().charAt(0);
			arr[first - 97]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if(arr[i] >= 5) sb.append((char)(i + 97));
		}
		
		if(sb.length() == 0) {
			System.out.println("PREDAJA");
		} else {
			System.out.println(sb);
		}
	}

}
