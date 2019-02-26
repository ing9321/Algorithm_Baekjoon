package inputoutput;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main10172 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append("|\\_/|\n");
		bw.append("|q p|   /}\n");
		bw.append("( 0 )\"\"\"\\\n");
		bw.append("|\"^\"`    |\n");
		bw.append("||_/=\\\\__|\n");
		bw.close();
	}
}
