package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

// 다음 다양한 단어
public class Main16923 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16923.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int[] chars = new int[26];
		for (int i = 0, size=str.length(); i < size; i++) {
			int tmp = str.charAt(i)- '0' - 49;
			chars[tmp]++;
		}
		char ch = '0';
		for (int i = 0; i < 26; i++) {
			if(chars[i] == 0) {
				ch = (char) (i+49+'0');
				break;
			}
		}
		if(ch == '0') {
			str = "-1";
		} else {
			str += ch;
		}
		System.out.println(str);
	}
}
