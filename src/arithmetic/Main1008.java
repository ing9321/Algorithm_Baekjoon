package arithmetic;

import java.util.Scanner;

/*
 * 1008 A/B
 * https://www.acmicpc.net/problem/1008
 */
public class Main1008 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double A = sc.nextInt();
		double B = sc.nextInt();
		double result = A/B;
		System.out.printf("%.9f", result);
	}
}
