package monthly.february;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 방학숙제
public class Main5532 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5532.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine().trim()); // 방학
		int A = Integer.parseInt(br.readLine().trim()); // 국어
		int B = Integer.parseInt(br.readLine().trim()); // 수학
		int C = Integer.parseInt(br.readLine().trim()); // 하루 국어 최대
		int D = Integer.parseInt(br.readLine().trim()); // 하루 수학 최대
		
		int kor = A/C;
		if(A%C > 0) {
			kor++;
		}
		int math = B/D;
		if(B%D > 0) {
			math++;
		}
		int result = L - Math.max(kor, math);
		System.out.println(result);
	}

}
