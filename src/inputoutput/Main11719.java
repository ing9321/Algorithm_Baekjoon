package inputoutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 11719 그대로 출력하기2
 * https://www.acmicpc.net/problem/11719
 */

public class Main11719 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		for (int i = 0; i < 100; i++) {
			str = br.readLine();
			if(str == null) break;
			bw.write(str);
			bw.write("\n");
		}

		bw.flush();
	}

}
