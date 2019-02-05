package coding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// IBM빼기 1
public class Main6321 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6321.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=T; t++) {
			String str = br.readLine().trim();
			bw.write("String #" + t + "\n");
			for(int i=0, size=str.length(); i<size; i++) {
				char ch = str.charAt(i);
				if(ch == 'Z') {
					ch = 'A';
				} else {
					ch = (char) (ch+1);
				}
				bw.write(ch);
			}
			bw.write("\n\n");
			bw.flush();
		}
	}

}
