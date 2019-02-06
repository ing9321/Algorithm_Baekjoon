package datasearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

// 문제집
public class Main1766 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1766.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strarr = br.readLine().split(" ");
		int N = Integer.parseInt(strarr[0]);
		int M = Integer.parseInt(strarr[1]);
		List<String> list = new LinkedList<String>();
		for(int n=0; n<=N; n++) {
			list.add(n + "");
		}
		
		for(int m=0; m<M; m++) {
			String[] arr = br.readLine().split(" ");
			String A = arr[0];
			String B = arr[1];
			int idx = list.indexOf(A);
			list.add(idx+1, B);
			list.remove(B);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int n=1; n<=N; n++) {
			bw.write(list.get(n) + " ");
		}
		bw.close();
	}

}
