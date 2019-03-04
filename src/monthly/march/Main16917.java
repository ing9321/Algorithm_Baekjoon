package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 양념반 후라이드반
public class Main16917 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16917.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int MIN = Integer.MAX_VALUE;
		int A = Integer.parseInt(st.nextToken()); // 양념 가격
		int B = Integer.parseInt(st.nextToken()); // 후라이드 가격
		int C = Integer.parseInt(st.nextToken()); // 반반 가격
		int X = Integer.parseInt(st.nextToken()); // 최소 양념 치킨 수
		int Y = Integer.parseInt(st.nextToken()); // 최소 후라이드 치킨 수
		int H = Math.max(X, Y); // 최대 반반 치킨 수 가정
		for (int i = 0; i <= H; i++) {
			int a = (X-i) > 0 ? (X-i)*A : 0;
			int b = (Y-i) > 0 ? (Y-i)*B : 0;
			int c = i * 2 * C;
			
			MIN = Math.min(MIN, a+b+c);
		}
		System.out.println(MIN);
	}
}