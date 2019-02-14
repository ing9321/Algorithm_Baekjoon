package divideconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 별 찍기 10
public class Main2447 {
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2447.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				star(N, i, j);
			}
			bw.append("\n");
		}
		bw.close();
	}
	private static void star(int n, int i, int j) throws IOException {
		if((i/n) % 3 == 1 && (j/n) % 3 == 1) {
			bw.append(" ");
		} else {
			if(n % 3 == 0) {
				star(n/3, i, j);
			} else {
				bw.append("*");				
			}
		}
	}
}
