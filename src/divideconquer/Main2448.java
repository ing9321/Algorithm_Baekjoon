package divideconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 별 찍기 11
/*
 * 2448 별 찍기 - 11
 * https://www.acmicpc.net/problem/2448
 * 분할정복.. 으로 풀기
 */
public class Main2448 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2448.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim()); // 3 * 2^k
		String[] tri = new String[N];
		tri[0] = "  *  ";
		tri[1] = " * * ";
		tri[2] = "*****";
		
		for(int i=1; 3*Math.pow(2, i)<=N; i++) {
			int bottom = (int) (3 * Math.pow(2, i));
			int middle = bottom/2;
			for(int j=middle; j<bottom; j++) {
				tri[j] = tri[j-middle] + " " + tri[j-middle];
			}
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<middle; j++) {
				sb.append(" ");
			}
			for(int j=0; j<middle; j++) {
				tri[j] = sb + tri[j] + sb;
			}
		}
		
		for(String str : tri) {
			bw.append(str + "\n");
		}
		bw.close();
	}
}
