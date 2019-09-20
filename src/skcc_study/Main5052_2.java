package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

/*
 * 5052 전화번호 목록
 * https://www.acmicpc.net/problem/5052
 * 해싱, 트라이, 정렬
 */

public class Main5052_2 {
	public static int N;
	public static TreeMap<String, String> map;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5052.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new TreeMap<String, String>();
			
			for (int i = 0; i < N; i++) {
				map.put(br.readLine().trim(), "");
			}
			
			boolean flag = false;
			String key = map.firstKey();
			for (int i = 0; i < map.size()-1; i++) {
				if(map.higherKey(key).contains(key)) {
					flag = true;
					break;
				} else {
					key = map.higherKey(key);
				}
			}
			
			if(flag) System.out.println("NO");
			else System.out.println("YES");
		}
	}
}
