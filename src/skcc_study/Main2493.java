package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 2493 탑
 * https://www.acmicpc.net/problem/2493
 */

public class Main2493 {
	public static int N;
	public static int[] arr, res;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2493.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N];
		res = new int[N];
		res[0] = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken().trim());
		}

		int idx = 0;
		for (int i = 0; i < N-1; i++) {
			stack.push(arr[i]);
			System.out.println(stack);
			if(stack.peek() < arr[i+1]) {
				System.out.println(idx);
				for (int j = idx; j < i; j++) {
					res[j] = idx;
				}
				idx = i;
				stack.clear();
				stack.push(arr[i]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
