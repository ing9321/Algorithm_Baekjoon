package divideconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2912 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2912.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strarr = br.readLine().split(" ");
		int N = Integer.parseInt(strarr[0]);
		int C = Integer.parseInt(strarr[1]);
		int[] dwarf = new int[N+1];
		strarr = br.readLine().split(" ");
		for(int d=0; d<N; d++) {
			dwarf[d+1] = Integer.parseInt(strarr[d]);
		}
		
		int M = Integer.parseInt(br.readLine().trim());
		for(int m=0; m<M; m++) {
			boolean isPretty = false;
			int[] hat = new int[C+1];
			strarr = br.readLine().split(" ");
			int start = Integer.parseInt(strarr[0]);
			int end = Integer.parseInt(strarr[1]);
			for(int i=start; i<=end; i++) {
				hat[dwarf[i]]++;
			}
			for(int i=1; i<=C; i++) {
				if(hat[i] > (end-start+1)/2) {
					bw.append("yes " + i + "\n");
					isPretty = true;
					break;
				}
			}
			if(!isPretty) {
				bw.append("no\n");
			}
		}
		bw.close();
	}
}