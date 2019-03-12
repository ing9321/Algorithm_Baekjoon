package monthly.april;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 계란으로 계란치기 : 완전탐색
public class Main16987 {
	private static class Egg implements Comparable<Egg> {
		int num;
		int hard;
		int weight;
		public Egg(int num, int hard, int weight) {
			this.num = num;
			this.hard = hard;
			this.weight = weight;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Egg [num=");
			builder.append(num);
			builder.append(", hard=");
			builder.append(hard);
			builder.append(", weight=");
			builder.append(weight);
			builder.append("]");
			return builder.toString();
		}
		@Override
		public int compareTo(Egg o) {
			return weight - o.weight;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16987.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Egg[] eggs = new Egg[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			eggs[i] = new Egg(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(eggs[i]);
			if(eggs[i].hard <= 0) continue;
			PriorityQueue<Egg> queue = new PriorityQueue<Egg>();
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				if(eggs[j].hard <= 0) continue;
				queue.offer(eggs[j]);
			}
			System.out.println(queue);
			while(!queue.isEmpty()) {
				if(eggs[i].hard <= 0) break;
				Egg egg = queue.poll();
				System.out.println(egg);
				eggs[i].hard -= egg.weight;
				egg.hard -= eggs[i].weight;
				eggs[egg.num] = egg;
				System.out.println(eggs[i] + " vs " + egg);
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(eggs[i].hard <= 0) cnt++;
		}
		System.out.println(cnt);
	}
}
