package kakao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main15953 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input15953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] first = {{500, 1}, {300, 2}, {200, 3}, {50, 4}, {30, 5}, {10, 6}};
		int[][] second = {{512, 1}, {256, 2}, {128, 4}, {64, 8}, {32, 16}};
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=T; tc++) {
			String[] str = br.readLine().trim().split(" ");
			int f = Integer.parseInt(str[0]);
			int s = Integer.parseInt(str[1]);
			int ascore = 0;
			int bscore = 0;
			if(f < 22) {
				int x = 0;
				for(int i=0, size=first.length; i<size; i++) {
					if(f > x && f <= x+first[i][1]) {
						ascore = first[i][0];
						break;
					}
					x += first[i][1];
				}
			}
			if(s < 32) {
				int x = 0;
				for(int i=0, size=second.length; i<size; i++) {
					if(s > x && s <= x+second[i][1]) {
						bscore = second[i][0];
						break;
					}
					x += second[i][1];
				}
			}
			System.out.println((ascore + bscore) * 10000);
		}
	}

}
