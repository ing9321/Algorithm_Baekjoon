package datasearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
 * 1764 듣보잡
 * https://www.acmicpc.net/problem/1764
 * 
 * 듣도 못한 사람과 보도 못한 사람이 주어질 때, 듣도 보도 못한 사람 출력
 * 
 * ** 듣도 못한 사람을 arraylist로 구현했을 경우 시간초과
 * ** Set을 이용하니 contains 탐색시간이 빨라진 듯
 */
public class Main1764 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input1764.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp= br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> list = new ArrayList<String>();
		
		// 듣도 못한 사람 명단
		for (int i = 0; i < N; i++) {
			set.add(br.readLine().trim());
		}
		// 보도 못한 사람 명단
		for (int i = 0; i < M; i++) {
			String str = br.readLine().trim();
			if(set.contains(str)) {
				list.add(str);
			}
		}
		Collections.sort(list);
		bw.append(list.size() + "\n");
		for (String str : list) {
			bw.append(str).append("\n");
		}
		bw.flush();
	}

}
