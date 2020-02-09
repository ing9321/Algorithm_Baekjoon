package inputoutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 2439 별찍기2
 * https://www.acmicpc.net/problem/2439
 */

public class Main2439 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N-1; j++) {
				bw.append(" ");
			}
			for (int j = 0; j <= i; j++) {
				bw.append("*");
			}
			bw.append("\n");
		}
		bw.flush();
	}

}
