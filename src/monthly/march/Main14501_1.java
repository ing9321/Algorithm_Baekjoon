package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 퇴사
public class Main14501_1 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input14501.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Meeting[] meetings = new Meeting[N+1];
		int[] dp = new int[N+1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int day = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(day, price);
		}
		
		for (int i = 1; i <= N; i++) {
			if(i + meetings[i].day -1 <= N) {
				for (int j = i + meetings[i].day -1; j <= N; j++) {
					// 일을 완수해서 보상을 받을 수 있는 날부터 마지막 출근일까지
					
					int tmp = meetings[j].day + j - 1;
					if(tmp < i) { // 일할 수 있으면
						dp[i] = Math.max((dp[j] + meetings[i].price), dp[i]);
					}
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	private static class Meeting {
		int day;
		int price;
		public Meeting(int day, int price) {
			this.day = day;
			this.price = price;
		}
	}
}
