package divideconquer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 6236 용돈관리
 * https://www.acmicpc.net/problem/6236
 * 분할 정복 (분할 정복, 이분 탐색)
 */
public class Main6236 {
	static int N;
	static int[] days;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strarr = br.readLine().split(" ");
		N = Integer.parseInt(strarr[0]);
		int M = Integer.parseInt(strarr[1]);
		days = new int[N];
		int MIN = 0;
		int MAX = 0;
		for(int i=0; i<N; i++) {
			days[i] = Integer.parseInt(br.readLine().trim());
			MIN = Math.max(MIN, days[i]);
			MAX += days[i];
		}

		while(MIN < MAX) {
			System.out.println(MIN + " " + MAX);
			int mid = (MIN + MAX) / 2;
			if(withraw(mid) > M) {
				// 중간값 넣고 돌렸을 때 인출 횟수가 많으면 중간값을 증가시켜서 분할
				MIN = mid+1;
			} else {
				// 중간값만큼 인출했을 때 횟수가 모자라므로 중간값 밑으로 분할
				MAX = mid;
			}
		}
		System.out.println(MIN);
	}
	private static int withraw(int money) {
		int m = 1;
		int cash = money;
		for(int i=0; i<N; i++) {
			if(days[i] > cash) {
				m++;
				cash = money;
			}
			cash -= days[i];
			System.out.println("current : " + cash);
		}
		System.out.println("withraw : " + m);
		return m;
	}
}
