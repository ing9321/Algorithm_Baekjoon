package bfs;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
 * 9019 DSLR
 * https://www.acmicpc.net/problem/9019
 * bfs
 */
public class Main9019 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input9019.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			String[] strarr = br.readLine().split(" ");
			int start = Integer.parseInt(strarr[0]);
			int end = Integer.parseInt(strarr[1]);
			LinkedList<Register> queue = new LinkedList<Register>();
			queue.offer(new Register(start, ""));
			boolean[] visit = new boolean[10000];
			int d, s, l, r;
			while(!queue.isEmpty()) {
				Register current = queue.poll();

				// D : double
				d = (current.num << 1) % 10000;
				if(d == end) {
					sb.append(current.command).append("D");
					break;
				}
				if(!visit[d]) {
					visit[d] = true;
					queue.offer(new Register(d, current.command + "D"));					
				}
				
				// S : n-1
				s = current.num - 1;
				if(s < 0) s = 9999;
				if(s == end) {
					sb.append(current.command).append("S");
					break;
				}
				if(!visit[s]) {
					visit[s] = true;
					queue.offer(new Register(s, current.command + "S"));
				}
				
				// L : left  <<
				l = ((current.num % 1000) * 10) + (current.num / 1000);
				if(l == end) {
					sb.append(current.command).append("L");
					break;
				}
				if(!visit[l]) {
					visit[l] = true;
					queue.offer(new Register(l, current.command + "L"));
				}
				
				// R : right >>
				r = (current.num / 10) + ((current.num % 10) * 1000);
				if(r == end) {
					sb.append(current.command).append("R");
					break;
				}
				if(!visit[r]) {
					visit[r] = true;
					queue.offer(new Register(r, current.command + "R"));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static class Register {
		int num;
		String command;
		public Register(int num, String command) {
			this.num = num;
			this.command = command;
		}
	}
}
