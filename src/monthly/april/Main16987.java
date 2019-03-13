package monthly.april;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 계란으로 계란치기 : 완전탐색
public class Main16987 {
	private static class Egg {
		int hard;
		int weight;
		public Egg(int hard, int weight) {
			this.hard = hard;
			this.weight = weight;
		}
	}
	static int N, MAX;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16987.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		Egg[] eggs = new Egg[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		go(0, eggs);
		System.out.println(MAX);
	}
	private static void go(int n, Egg[] eggs) {
		if(n == N) {
			count(eggs);
			return;
		}
		if(eggs[n].hard <= 0) {
			go(n+1, eggs);
		} else {
			for (int i = 0; i < N; i++) {
				if(eggs[i].hard <= 0) continue;
				if(i == n) continue;
				eggs[n].hard -= eggs[i].weight;
				eggs[i].hard -= eggs[n].weight;
				go(n+1, eggs);
				eggs[n].hard += eggs[i].weight;
				eggs[i].hard += eggs[n].weight;
			}
		}
		count(eggs);
	}
	private static void count(Egg[] eggs) {
		int c = 0;
		for (int i = 0; i < N; i++) {
			if(eggs[i].hard <= 0) c++;
		}
		MAX = Math.max(MAX, c);
	}
}
