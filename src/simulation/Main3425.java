package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * 3425 고스택
 * https://www.acmicpc.net/problem/3425
 * Simulation
 */
public class Main3425 {
	private static class Gostack {
		int INF = 1000000000;
		Stack<Integer> stack;
		public Gostack() {
			this.stack = new Stack<Integer>();
		}
		private boolean num(int x) { // x를 스택의 가장 위에 저장한다. (0 <= x <= 109)
			stack.push(x);
			return true;
		}
		private boolean pop() { // 스택 가장 위의 숫자를 제거한다.
			if(!stack.isEmpty()) {
				stack.pop();
				return true;
			}
			return false;
		}
		private boolean inv() { // 첫번째 수의 부호를 바꾼다.
			if(!stack.isEmpty()) {
				int n = stack.pop();
				n = n * (-1);
				if(n > INF) return false;
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean dup() { // 첫번째 숫자를 하나 더 스택의 가장 위에 저장한다.
			if(!stack.isEmpty()) {
				int n = stack.peek();
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean swp() { // 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
			if(stack.size() > 1) {
				int n1 = stack.pop();
				int n2 = stack.pop();
				stack.push(n1);
				stack.push(n2);
				return true;
			}
			return false;
		}
		private boolean add() { // 첫 번째 숫자와 두 번째 숫자를 더한다.
			if(stack.size() > 1) {
				int n1 = stack.pop();
				int n2 = stack.pop();
				int n = n1 + n2;
				if(n > INF) return false;
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean sub() { // 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번쨰)
			if(stack.size() > 1) {
				int n1 = stack.pop();
				int n2 = stack.pop();
				int n = n2 - n1;
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean mul() { // 첫번째 숫자와 두 번째 숫자를 곱한다.
			if(stack.size() > 1) {
				int n1 = stack.pop();
				int n2 = stack.pop();
				int n = n1 * n2;
				if(n > INF) return false;
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean div() { // 첫 번째 숫자(제수)로 두 번째 숫자(피제수)를 나눈 몫을 저장한다.
			if(stack.size() > 1) {
				int n1 = stack.pop();
				int n2 = stack.pop();
				if(n1 == 0) return false;
				int n11 = Math.abs(n1);
				int n22 = Math.abs(n2);
				int n = n22 / n11;
				if(n1 * n2 < 0) { // 곱해서 음수면 둘 중 하나만 음수
					n = n * (-1);
				}
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean mod() { // 첫 번째 숫자(제수)로 두 번째 숫자(피제수)를 나눈 나머지를 저장한다.
			if(stack.size() > 1) {
				int n1 = stack.pop();
				int n2 = stack.pop();
				if(n1 == 0) return false;
				int n11 = Math.abs(n1);
				int n22 = Math.abs(n2);
				int n = n22 % n11;
				if(n1 < 0) { // 피제수가 음수면 나머지 부호도 음수
					n = n * (-1);
				}
				stack.push(n);
				return true;
			}
			return false;
		}
		private String get() {
			if(stack.size() == 1) {
				int n = stack.pop();
				return n+"";
			}
			return "ERROR";
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3425.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Gostack gostack = new Gostack();
		ArrayList<String> list = new ArrayList<String>();
		start:
		while(true) {
			String str = br.readLine().trim();
			if(str.equals("QUIT")) break;
			System.out.println(str);
		}
		
		
		System.out.print(sb);
	}
}
