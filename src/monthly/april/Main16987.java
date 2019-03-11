package monthly.april;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 계란으로 계란치기
public class Main16987 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16987.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] eggs = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			eggs[i][0] = Integer.parseInt(st.nextToken()); // 내구도
			eggs[i][1] = Integer.parseInt(st.nextToken()); // 무게
		}
		for (int i = 0; i < N; i++) {
			if(eggs[i][0] <= 0) continue;
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				if(eggs[i][0] <= 0) break;
				if(eggs[j][0] <= 0) continue;
				eggs[i][0] -= eggs[j][1];
				eggs[j][0] -= eggs[i][1];
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(eggs[i][0] <= 0) cnt++;
		}
		System.out.println(cnt);
	}
}
