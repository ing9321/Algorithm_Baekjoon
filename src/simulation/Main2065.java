package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 미해결
 * 2065 나룻배
 * https://www.acmicpc.net/problem/2065
 * simulation
 */
public class Main2065 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2065.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < N; i++) {
			int time = 0;
			int pt = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			
		}
	}
}
