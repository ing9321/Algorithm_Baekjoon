package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 17281 야구공
 * https://www.acmicpc.net/problem/17281
 * 미해결
 */

public class Main17281 {

	public static int N, MAX;
	public static int[] tasun;
	public static String[][] players;

	public static void permutation(int cnt, int flag) {
		if(cnt == 9) {
			//play
			System.out.println(Arrays.toString(tasun));
			
			MAX = Math.max(MAX, play());
			System.out.println(MAX);
			
			return;
		}
		if(cnt == 3) {
			permutation(cnt + 1, flag);
		} else {
			for (int i = 1; i < 9; i++) {
				if((flag & 1 << i) == 0) {
					tasun[cnt] = i;
					permutation(cnt + 1, flag | 1<<i);
				}
				
			}
		}
	}
	
	public static int play() {
		int score = 0;
		
		int num = 8;
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder("0000");
			
			System.out.println(i + "이닝");
			int cnt = 0;
			while(cnt < 3) {
				int tmp = 0;
				num++;
				if(num == 9) num = 0;
				System.out.println(cnt + "아웃, " + sb);
				System.out.println(cnt + "타석, " + num + "번 타자 " + tasun[num] + "는 " + players[i][tasun[num]] + "을 친다.");
				
				if(players[i][tasun[num]].equals("0")) {
					cnt++;
				} else if(players[i][tasun[num]].equals("1")) {
					sb.insert(0, "1");
					if(sb.charAt(4) == '1') {
						score++;
						tmp++;
					}
					sb = sb.delete(3, 4);
				} else if(players[i][tasun[num]].equals("2")) {
					sb.insert(0, "01");
					String str = sb.substring(3);
					for (char c : str.toCharArray()) {
						if(c == '1') {
							tmp++;
							score++;
						}
					}
					sb = sb.delete(3, 5);
				} else if(players[i][tasun[num]].equals("3")) {
					sb.insert(0, "001");
					String str = sb.substring(3);
					for (char c : str.toCharArray()) {
						if(c == '1') {
							tmp++;
							score++;
						}
					}
					sb = sb.delete(3, 6);
				} else if(players[i][tasun[num]].equals("4")) {
					sb.insert(0, "1");
					for (int j = 0; j < sb.length(); j++) {
						if(sb.charAt(j) == '1') {
							tmp++;
							score++;
						}
					}
					sb = new StringBuilder("0000");
				}
				System.out.println(tmp + "점 획득");
			}
			System.out.println(i + "이닝에 " + score + "점");
		}
		
		return score;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17281.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		MAX = 0;
		
		players = new String[N][9];
		for (int i = 0; i < N; i++) {
			players[i] = br.readLine().split(" ");
		}
		
		tasun = new int[9];
		permutation(0, 0);
		
		System.out.println("최대 점수 : " + MAX);
	}
	
}
