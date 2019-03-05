package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 퇴사
public class Main14501 {
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
			dp[i] = price;
		}
		
		for (int i = 1; i <= N; i++) {
			// i일 + 일하는 날이 N일보다 작을 때
			if(i + meetings[i].day -1 <= N) {
				for (int j = 1; j < i; j++) {
					// meeting 1일부터 2일 전까지
					int tmp = meetings[j].day + j - 1;
					if(tmp < i) { // 일할 수 있으면
						dp[i] = Math.max((dp[j] + meetings[i].price), dp[i]);
					}
				}
			} else {
				dp[i] = 0;
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
