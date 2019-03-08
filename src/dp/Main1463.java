package dp;

import java.util.Arrays;
import java.util.Scanner;

// 1로 만들기
public class Main1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		// 3의 배수 일 때
		// 2의 배수일 때
		// -1
		
		for (int i = 2; i <=N; i++) {
			
		}
		
		System.out.println(Arrays.toString(dp));
		
		System.out.println(dp[N]);
	}

}
