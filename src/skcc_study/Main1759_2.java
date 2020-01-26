package skcc_study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1759 암호만들기
 * https://www.acmicpc.net/problem/1759
 */

public class Main1759_2 {
	public static int L, C;
	public static char[] data, result;
	public static char[] collections = {'a', 'e', 'i', 'o', 'u'};
	public static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1759.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		L = Integer.parseInt(st.nextToken().trim());
		C = Integer.parseInt(st.nextToken().trim());
		data = new char[C];
		result = new char[L];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < C; i++) {
			data[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(data);
		
		combination(0, 0);
		bw.flush();
		bw.close();
		br.close();
	}

	public static void combination(int idx, int cnt) throws IOException {
		if(cnt == L) {
			int collection = 0, consonant = 0;
			for (char c : result) {
				if(Arrays.binarySearch(collections, c) < 0) {
					consonant++;
				} else {
					collection++;
				}
				
			}
			
			if(collection > 0 && consonant > 1) {
				for (char c : result) {
					bw.append(c);
				}
				bw.append("\n");
			}
			return;
		}
		
		for (int i = idx; i < C; i++) {
			result[cnt] = data[i];
			combination(i+1, cnt+1);
		}
	}
}
