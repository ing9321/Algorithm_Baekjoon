package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

// 로마 숫자 만들기
public class Main16922 {
	static int N, C, I;
	static int[] roman = {1, 5, 10, 50};
	static HashSet<Integer> numbers;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16922.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		numbers = new HashSet<Integer>();
		combination(0, 0, 0);
		System.out.println(numbers.size());
	}
	private static void combination(int idx, int cnt, int sum) {
		if(cnt == N) {
			numbers.add(sum);
			return;
		}
		for (int i = idx, size=roman.length; i < size; i++) {
			combination(i, cnt+1, sum+roman[i]);
		}
	}
}