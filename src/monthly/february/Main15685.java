package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15685 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input15685.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[100][100];
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		int lx = 0;
		int ly = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			// x y d g
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 시작방향 : 왼 위 오 아
			int g = Integer.parseInt(st.nextToken()); // 세대
			
			for (int i = 0; i <= g; i++) {
				
			}
		}
	}

}
