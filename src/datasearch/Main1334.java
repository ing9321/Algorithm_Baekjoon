package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main1334 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1334.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		BigInteger origin = new BigInteger(str);
		char[] input = str.toCharArray();
		int size = input.length;
		for(int i=0, ns=size/2; i<ns; i++) {
			char front = input[i];
			char rear = input[size-i-1];
			if(front != rear) {
				input[size-i-1] = front;
			}
		}

		BigInteger palin = new BigInteger(new String(input));
		if(origin.compareTo(palin) == 1) {
			if(size%2 == 0) {
				input[(size/2)-1] += 1;
			}
			input[size/2] += 1;
		}
		palin = new BigInteger(new String(input));
		System.out.println(palin);
	}
}
