package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 교수가 된 현우
public class Main3474 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3474.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=T; t++) {
			int num = Integer.parseInt(br.readLine().trim());
			int cnt = 0;
			for(int i=5; i<=num; i*=5) {
				cnt += num/i;
			}
			System.out.println(cnt);
		}
	}

}
