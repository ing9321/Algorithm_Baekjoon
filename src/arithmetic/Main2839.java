package arithmetic;

import java.util.Scanner;

public class Main2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		while(N > 2) {
			if(N % 15 == 0) {
				N -= 15;
				cnt += 3;
			} else if(N % 3 == 0) {
				N -= 3;
				cnt++;
			} else {
				N -= 5;
				cnt++;
			}
		}
		if(N != 0) {
			cnt = -1;
		}
		System.out.println(cnt);
	}
}
