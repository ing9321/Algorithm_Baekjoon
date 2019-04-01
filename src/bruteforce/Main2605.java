package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 2605 줄 세우기
 * https://www.acmicpc.net/problem/2605
 */
public class Main2605 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			int t = list.size()-n;
			if(t < 0) t = 0;
			list.add(t, i);
		}
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}
