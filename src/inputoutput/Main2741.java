package inputoutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 2741 N찍기
 * https://www.acmicpc.net/problem/2741
 */

public class Main2741 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <= N; i++) {
			bw.append(i + "\n");
		}
		bw.flush();
	}

}
