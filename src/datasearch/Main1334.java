package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main1334 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1334.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int size = str.length;
		int half = str.length/2;
		System.out.println(str[str.length/2+1]);
	}

}
