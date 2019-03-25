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
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3425.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		StringBuilder sb = new StringBuilder();
		while(!str.equals("QUIT")) {
			ArrayList<String> list = new ArrayList<String>();
			while(!str.equals("END")) {
				list.add(str);
				str = br.readLine().trim();
			}
			System.out.println(list);
			
			int N = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				boolean flag = false;
				Stack<Integer> stack = new Stack<Integer>();
				stack.push(Integer.parseInt(br.readLine().trim()));
				System.out.println(stack.peek());
				calc:
				for (int j = 0; j < list.size(); j++) {
					String order = list.get(j);
					if(order.contains("NUM")) {
						int n1 = Integer.parseInt(order.split(" ")[1]);
						stack.push(n1);
					} else if(order.contains("POP")) {
						stack.pop();
					} else if(order.contains("INV")) {
						int n1 = stack.pop();
						n1 *= -1;
						stack.push(n1);
					} else if(order.contains("DUP")) {
						int n1 = stack.peek();
						stack.push(n1);
					} else if(order.contains("SWP")) {
						if(stack.size() < 2) {
							flag = true;
							break calc;
						}
						int n1 = stack.pop();
						int n2 = stack.pop();
						stack.push(n1);
						stack.push(n2);
					} else if(order.contains("ADD")) {
						if(stack.size() < 2) {
							flag = true;
							break calc;
						}
						int n1 = stack.pop();
						int n2 = stack.pop();
						int temp = n1+n2;
						stack.push(temp);
					} else if(order.contains("SUB")) {
						if(stack.size() < 2) {
							flag = true;
							break calc;
						}
						int n1 = stack.pop();
						int n2 = stack.pop();
						int temp = n2-n1;
						stack.push(temp);
					} else if(order.contains("MUL")) {
						if(stack.size() < 2) {
							flag = true;
							break calc;
						}
						int n1 = stack.pop();
						int n2 = stack.pop();
						int temp = n2 * n1;
						stack.push(temp);
					} else if(order.contains("DIV")) {
						int n1 = stack.pop();
						if(stack.size() < 1 || n1 == 0) {
							flag = true;
							break calc;
						}
						int n2 = stack.pop();
						int cnt = 0;
						if(n1 < 0) {
							n1 *= -1;
							cnt++;
						}
						if(n2 < 0) {
							n2 *= -1;
							cnt++;
						}
						int temp = n2 / n1;
						if(cnt == 1) {
							temp *= -1;
						}
						stack.push(temp);
					} else if(order.contains("MOD")) {
						int n1 = stack.pop();
						if(stack.size() < 1 || n1 == 0) {
							flag = true;
							break calc;
						}
						int n2 = stack.pop();
						int n11 = n1;
						if(n1 < 0) {
							n1 *= -1;
						}
						if(n2 < 0) {
							n2 *= -1;
						}
						int temp = n2 % n1;
						if(n11 < 0) {
							temp *= -1;
						}
						stack.push(temp);
					}
					if(stack.peek() > 1000000000) {
						flag = true;
						break calc;
					}
				}
				
				if(!flag && stack.size() == 1) {
					sb.append(stack.peek());
					sb.append("\n");
				} else {
					sb.append("ERROR\n");
				}
			}
			sb.append("\n");
			br.readLine();
			str = br.readLine().trim();
		}
		
		System.out.println(sb);
	}

}
