package datasearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 명령 프롬프트
public class Main1032 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1032.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		char[] pattern = br.readLine().toCharArray();
        int size = pattern.length;
		for(int n=0; n<N-1; n++) {
			char[] input = br.readLine().toCharArray();
            for(int c=0; c<size; c++) {
                if(pattern[c] == '?') {
                    continue;
                } else if(pattern[c] != input[c]) {
                    pattern[c] = '?';
                }
            }
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(char c : pattern) {
			bw.write(c);
		}
		bw.close();
	}
}