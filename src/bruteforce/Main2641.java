package bruteforce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 2641 다각형그리기
 * https://www.acmicpc.net/problem/2641
 */
public class Main2641 {
	static int N, C;
	static ArrayList<Integer> origin, forward, reverse;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2641.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine().trim());
		origin = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			origin.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine().trim());
		forward = new ArrayList<Integer>();
		reverse = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			forward.clear();
			reverse.clear();
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				forward.add(n);
				n = (n+2) % 4;
				if(n == 0) n = 4;
				reverse.add(0, n);
			}
			forward.addAll(forward);
			reverse.addAll(reverse);
			if(forward(0, 0, 0) || reverse(0, 0, 0)) {
				C++;
				for (int j = 0; j < N; j++) {
					sb.append(forward.get(j)).append(" ");
				}
				sb.append("\n");
			}
		}
		sb.insert(0, "\n").insert(0, C);
		System.out.println(sb);
	}

	private static boolean forward(int oidx, int tidx, int cnt) {
		boolean flag = false;
		
		if(cnt == N) return true;
		if((tidx - oidx > N) || (tidx >= (N<<1)) || (oidx >= N)) return false;
		
		if(origin.get(oidx) == forward.get(tidx)) {
			flag = forward(oidx+1, tidx+1, cnt+1);
		} else {
			flag = forward(0, tidx+1, 0);				
		}
		return flag;
	}
	private static boolean reverse(int oidx, int tidx, int cnt) {
		boolean flag = false;
		
		if(cnt == N) return true;
		if((tidx - oidx > N) || (tidx >= (N<<1)) || (oidx >= N)) return false;
		if(origin.get(oidx) == reverse.get(tidx)) {
			flag = reverse(oidx+1, tidx+1, cnt+1);
		} else {
			flag = reverse(0, tidx+1, 0);				
		}
		return flag;
	}
}
