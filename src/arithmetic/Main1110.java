package arithmetic;

import java.util.Scanner;

/*
 * 1110 더하기 사이클
 * https://www.acmicpc.net/problem/1110
 */
public class Main1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int N1 = -1, N2 = -1, N3 = -1;
		int cnt = 0;
		
		do {
			if(N3 < 0) N1 = N;
			else N1 = N3;

			if(N1 > 9) N2 = N1/10 + N1%10;
			else N2 = N1;
			
			N3 = (N1%10)*10 + (N2%10);
			cnt++;
		}while(N != N3);
		
		System.out.println(cnt);
	}

}
