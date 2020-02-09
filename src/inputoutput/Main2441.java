package inputoutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 2441 별찍기4
 * https://www.acmicpc.net/problem/2441
 */

public class Main2441 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				bw.append(" ");
			}
			for (int j = i; j < N; j++) {
				bw.append("*");
			}
			bw.append("\n");
		}
		bw.flush();
	}

}
