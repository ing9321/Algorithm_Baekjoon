package coding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 이진수
public class Main3460 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3460.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1; test_case<=T; test_case++) {
			int num = Integer.parseInt(br.readLine().trim());
			String str = Integer.toBinaryString(num);
			int size = str.length() - 1;
			for(int i=size; i>=0; i--) {
				if(str.charAt(i) - '0' == 1) {
					bw.write(size - i + "");
					bw.write(' ');
				}
			}
			bw.flush();
		}
	}
}
