package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 체스판 다시 칠하기
public class Main1018 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1018.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				int cnt1 = 0;
				for (int x = i; x < i+8; x++) {
					for (int y = j; y < j+8; y++) {
						if((x-i + y-j) % 2 == 0) {
							if(map[x][y] == 'B') cnt1++;
						} else {
							if(map[x][y]=='W') cnt1++;
						}
					}
				}
				min = Math.min(min, cnt1);
				int cnt2 = 0;
				for (int x = i; x < i+8; x++) {
					for (int y = j; y < j+8; y++) {
						if((x-i + y-j) % 2 == 0) {
							if(map[x][y] == 'W') cnt2++;
						} else {
							if(map[x][y]=='B') cnt2++;
						}
					}
				}
				min = Math.min(min, cnt2);
			}
		}
		System.out.println(min);
	}

}
