package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 펠린드롬인지 맞추기
public class Main10988 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input10988.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int size = input.length;
		int result = 1;
		for(int i=0, ns=size/2; i<ns; i++) {
			char front = input[i];
			char rear = input[size-i-1];
			if(front != rear) {
				result = 0;
				break;
			}
		}
		System.out.println(result);
	}
}
