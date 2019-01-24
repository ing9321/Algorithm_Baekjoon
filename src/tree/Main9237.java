package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main9237 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input9237.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] str = br.readLine().trim().split(" ");
		Integer[] dates = new Integer[N];
		for(int i=0; i<N; i++) {
			dates[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(dates, Collections.reverseOrder());
		int maxDate = 0;
		for(int i=0; i<N; i++) {
			int date = dates[i] + (i+1);
			maxDate = Math.max(date, maxDate);
		}
		System.out.println(maxDate + 1);
	}
}
