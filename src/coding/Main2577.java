package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 숫자의 개수
public class Main2577 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2577.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine().trim());
		int B = Integer.parseInt(br.readLine().trim());
		int C = Integer.parseInt(br.readLine().trim());
		String str = (A * B * C) + "";
		int[] arr = new int[10];
		for(char c : str.toCharArray()) {
			int num = c - '0';
			arr[num]++;
		}
		for(int n : arr) {
			System.out.println(n);
		}
	}

}
