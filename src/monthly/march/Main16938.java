package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

// 캠프 준비
public class Main16938 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16938.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strarr = br.readLine().split(" ");
		int N = Integer.parseInt(strarr[0]);
		int L = Integer.parseInt(strarr[1]);
		int R = Integer.parseInt(strarr[2]);
		int X = Integer.parseInt(strarr[3]);
		
		int[] prob = new int[N];
		strarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			prob[i] = Integer.parseInt(strarr[i]);
		}
		System.out.println(Arrays.toString(prob));
		
	}

}
