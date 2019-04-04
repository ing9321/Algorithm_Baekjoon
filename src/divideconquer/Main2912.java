package divideconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 재채점 결과 시간초과
 * 2912 백설공주와 난쟁이
 * https://www.acmicpc.net/problem/2912
 * (세그먼트 트리, 분할 정복, 자료구조, 이분 탐색)
 */
public class Main2912 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2912.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] dwarf = new int[N+1];
		st = new StringTokenizer(br.readLine().trim());
		for(int d = 1; d <= N; d++) {
			dwarf[d] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine().trim());
		for(int m = 0; m < M; m++) {
			boolean isPretty = false;
			int[] hat = new int[C+1];
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			
			for(int i = start; i <= end; i++) {
				hat[dwarf[i]]++;
				if(hat[dwarf[i]] > (end-start+1)>>1) {
					bw.write("yes ");
					bw.write(dwarf[i] + "\n");
					isPretty = true;
					break;
				}
			}
			if(!isPretty) {
				bw.write("no\n");
			}
		}
		bw.close();
	}
}