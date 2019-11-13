package bruteforce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 14888 연산자 끼워넣기
 * https://www.acmicpc.net/problem/14888
 * 브루트포스
 */
public class Main14888 {

	public static int N, MIN, MAX;
	public static int[] numbers, operators;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input14888.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		MIN = Integer.MAX_VALUE;
		MAX = Integer.MIN_VALUE;
		
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken().trim());
		}
		operators = new int[4];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken().trim());
		}
		
		permu(1, 0, numbers[0], operators);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}

	public static void permu(int idx, int cnt, int res, int[] poper) {
		if(cnt == N-1) {
			if(res < MIN) MIN = res;
			if(res > MAX) MAX = res;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(poper[i] > 0) {
				int tmp = res;
				if(i == 0) {
					res += numbers[idx];
				} else if(i == 1) {
					res -= numbers[idx];
				} else if(i == 2) {
					res *= numbers[idx];
				} else if(i == 3) {
					res /= numbers[idx];
				}
				poper[i] = poper[i] - 1;
				permu(idx+1, cnt+1, res, poper);
				poper[i] = poper[i] + 1;
				res = tmp;
			}
		}
	}
}
