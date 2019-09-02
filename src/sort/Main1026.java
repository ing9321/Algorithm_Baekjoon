package sort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 1026 보물
 * https://www.acmicpc.net/problem/1026
 * sort
 */
public class Main1026 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1026.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		PriorityQueue<Integer> A = new PriorityQueue<>();
		PriorityQueue<Integer> B = new PriorityQueue<>(Collections.reverseOrder());
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			A.offer(Integer.parseInt(st.nextToken().trim()));
		}
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			B.add(Integer.parseInt(st.nextToken().trim()));
		}
		
		int res = 0;
		while(N > 0) {
			res += A.poll() * B.poll();
			N--;
		}
		System.out.println(res);
	}

}
