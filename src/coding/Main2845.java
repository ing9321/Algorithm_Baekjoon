package coding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 파티가 끝나고 난 후
public class Main2845 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2845.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().trim().split(" ");
		int L = Integer.parseInt(str[0]);
		int P = L * Integer.parseInt(str[1]);
		String[] str2 = br.readLine().trim().split(" ");
		for(int i=0; i<5; i++) {
			bw.append(Integer.parseInt(str2[i]) - P + " ");
		}
		bw.flush();
	}
}