package arithmetic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 2739 구구단
 * https://www.acmicpc.net/problem/2739
 * 
 * N단 출력 : N * 1 = N
 */
public class Main2739 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		for (int i = 1; i < 10; i++) {
			bw.append(N + " * ").append(i + " = ").append((N*i) + "\n");
		}
		bw.flush();
	}

}
