package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2048(Easy)
public class Main12100 {
	static int[][] pos = {{0,1}, {1,0}, {0, -1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input12100.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		StringTokenizer st;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		
	}
}
