package monthly.april;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16954 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[8][8];
		StringTokenizer st;
		for (int i = 0; i < 8; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				if(st.nextToken().charAt(0) == '#') map[i][j] = 1;
			}
		}
	}
}
