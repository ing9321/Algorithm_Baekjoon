package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 2493 탑
 * https://www.acmicpc.net/problem/2493
 * 스택
 */

public class Main2493 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2493.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Stack<int[]> stack = new Stack<int[]>();
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken().trim());
			
			while(!stack.isEmpty()) {
				if(tmp <= stack.peek()[1]) {
					System.out.print(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				System.out.print(0 + " ");
			}
			
			stack.push(new int[] {i, tmp});
		}

	}
}
