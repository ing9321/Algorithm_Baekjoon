package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main16923 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16923.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		char[] chars = new char[26];
		for (int i = 0, size=str.length(); i < size; i++) {
			System.out.println(str.charAt(i));
			int tmp = str.charAt(i)- '0' - 49;
			chars[tmp]++;
			System.out.println(tmp);
		}
		for (int i = 0; i < 26; i++) {
			if(chars[i] == 0)
				System.out.println(chars[i] + '0');
		}
	}

}
