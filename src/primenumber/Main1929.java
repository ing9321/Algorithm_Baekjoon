package primenumber;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1929 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1929.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] numbers = new boolean[N+1];
		numbers[0] = true;
		numbers[1] = true;
		int itr = (int) Math.sqrt(N);
		for (int i = 2; i <= itr; i++) {
			if(numbers[i]) continue;
			for (int j = i*i; j <= N; j+=i) {
				numbers[j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if(!numbers[i])
				sb.append(i + "\n");
		}
		System.out.print(sb);
	}
}
