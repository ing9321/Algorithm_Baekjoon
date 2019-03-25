package bruteforce;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 1065 한수
 * https://www.acmicpc.net/problem/1065
 * Brute Force
 */
public class Main1065 {
	static int N, count;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1065.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		count = 0;
		if(N <= 99) {
			count = N;
		} else {
			count = 99;
			for(int i=100; i<=N; i++) {
				hansu(i);
			}
		}
		System.out.println(count);
	}
	public static void hansu(int n) {
		int[] arr = new int[3];
		arr[0] = n/100;
		n = n - n/100*100;
		arr[1] = n / 10;
		n = n - n/10*10;
		arr[2] = n;
		
		if((arr[0] - arr[1]) == (arr[1] - arr[2])) {
			count++;
		}
	}
}
