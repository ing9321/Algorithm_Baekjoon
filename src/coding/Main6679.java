package coding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 싱기한 네자리 숫자
public class Main6679 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=2992; i<9930; i++) {
			int num1 = change(Integer.toString(i), 10);
			int num2 = change(Integer.toString(i, 12), 12);
			int num3 = change(Integer.toString(i, 16), 16);
			if(num1 == num2 && num2 == num3) {
				bw.write(i + "\n");
			}
			bw.flush();
		}
	}
	
	public static int change(String number, int type) {
		int sum = 0;
		for(char ch : number.toCharArray()) {
			if(Character.isDigit(ch)) {
				sum += ch - '0';
			} else {
				int nch = ch - '0' - 39;
				sum += nch;
			}
		}
		return sum;
	}
}
