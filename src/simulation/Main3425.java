package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * 미해결
 * 3425 고스택
 * https://www.acmicpc.net/problem/3425
 * Simulation
 */
public class Main3425 {
	private static class Gostack {
		long INF = 1000000000;
		Stack<Long> stack;
		public Gostack() {
			this.stack = new Stack<Long>();
		}
		private boolean num(long x) { // x를 스택의 가장 위에 저장한다. (0 <= x <= 109)
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
				long n = stack.pop();
				n = n * (-1);
				if(Math.abs(n) > INF) return false;
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean dup() { // 첫번째 숫자를 하나 더 스택의 가장 위에 저장한다.
			if(!stack.isEmpty()) {
				long n = stack.peek();
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean swp() { // 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
			if(stack.size() > 1) {
				long n1 = stack.pop();
				long n2 = stack.pop();
				stack.push(n1);
				stack.push(n2);
				return true;
			}
			return false;
		}
		private boolean add() { // 첫 번째 숫자와 두 번째 숫자를 더한다.
			if(stack.size() > 1) {
				long n1 = stack.pop();
				long n2 = stack.pop();
				long n = n1 + n2;
				if(Math.abs(n) > INF) return false;
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean sub() { // 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번쨰)
			if(stack.size() > 1) {
				long n1 = stack.pop();
				long n2 = stack.pop();
				long n = n2 - n1;
				if(Math.abs(n) > INF) return false;
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean mul() { // 첫번째 숫자와 두 번째 숫자를 곱한다.
			if(stack.size() > 1) {
				long n1 = stack.pop();
				long n2 = stack.pop();
				long n = n1 * n2;
				if(Math.abs(n) > INF) return false;
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean div() { // 첫 번째 숫자(제수)로 두 번째 숫자(피제수)를 나눈 몫을 저장한다.
			if(stack.size() > 1) {
				long n1 = stack.pop();
				long n2 = stack.pop();
				if(n1 == 0) return false;
				long n11 = Math.abs(n1);
				long n22 = Math.abs(n2);
				long n = n22 / n11;
				if(n1 * n2 < 0) { // 곱해서 음수면 둘 중 하나만 음수
					n = n * (-1);
				}
				if(Math.abs(n) > INF) return false;
				stack.push(n);
				return true;
			}
			return false;
		}
		private boolean mod() { // 첫 번째 숫자(제수)로 두 번째 숫자(피제수)를 나눈 나머지를 저장한다.
			if(stack.size() > 1) {
				long n1 = stack.pop();
				long n2 = stack.pop();
				if(n1 == 0) return false;
				long n11 = Math.abs(n1);
				long n22 = Math.abs(n2);
				long n = n22 % n11;
				if(n1 < 0) { // 피제수가 음수면 나머지 부호도 음수
					n = n * (-1);
				}
				if(Math.abs(n) > INF) return false;
				stack.push(n);
				return true;
			}
			return false;
		}
		private String get() {
			if(stack.size() == 1) {
				long n = stack.pop();
				return n+"";
			}
			return "ERROR";
		}
		private void clear() {
			stack.clear();
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3425.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Gostack gostack = new Gostack();
		ArrayList<String> list = new ArrayList<String>();
		
		while(true) {
			String str = br.readLine().trim();
			if(str.equals("QUIT")) break;
			
			list.clear();
			while(true) {
				if(str.equals("END")) break;
				list.add(str);
				str = br.readLine().trim();
			}
			list.add(str);
			
			while(true) {
				str = br.readLine().trim();
				if(str.length() <= 0) break;

				int n = Integer.parseInt(str);
				nextnum:
				for (int i = 0; i < n; i++) {
					gostack.clear();
					gostack.num(Integer.parseInt(br.readLine().trim()));
					for (int j = 0, size=list.size(); j < size; j++) {
						String order = list.get(j).split(" ")[0];
						boolean flag = false;
						switch(order) {
						case "NUM":
							flag = gostack.num(Long.parseLong(list.get(j).split(" ")[1]));
							break;
						case "POP":
							flag = gostack.pop();
							break;
						case "INV":
							flag = gostack.inv();
							break;
						case "DUP":
							flag = gostack.dup();
							break;
						case "SWP":
							flag = gostack.swp();
							break;
						case "ADD":
							flag = gostack.add();
							break;
						case "SUB":
							flag = gostack.sub();
							break;
						case "MUL":
							flag = gostack.mul();
							break;
						case "DIV":
							flag = gostack.div();
							break;
						case "MOD":
							flag = gostack.mod();
							break;
						case "END":
							System.out.println(gostack.get());
							continue nextnum;
						}
						if(!flag) {
							System.out.println("ERROR");
							continue nextnum;
						}
					}
				}
			}
			System.out.println();
		}
	}
}
