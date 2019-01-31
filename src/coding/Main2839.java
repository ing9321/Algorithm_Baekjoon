package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 설탕 배달
public class Main2839 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input2839.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sugar = Integer.parseInt(br.readLine().trim());
        int cnt = 0;
		while(sugar > 2) {
			if(sugar % 15 == 0) {
				sugar -= 15;
				cnt += 3;
			} else if(sugar % 3 == 0) {
				sugar -= 3;
				cnt++;
			} else {
				sugar -= 5;
				cnt++;
			}
		}
		if(sugar != 0) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
	}
}
