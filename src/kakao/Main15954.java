package kakao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15954 {
	static int N, K;
	static double M;
	static int[] arr, numbers;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input15954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().trim().split(" ");
		N = Integer.parseInt(nk[0]);
		K = Integer.parseInt(nk[1]);
		M = 987654321;
		arr = new int[N];
		String str = br.readLine().trim();
		StringTokenizer st = new StringTokenizer(str);
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken().trim());
		}

		for(int i=K; i<=N; i++) { // 3, 4, 5개씩
			for(int j=0; j<=N-i; j++) { //0부터 N-i까지
				numbers = new int[i];
				for(int k=j; k<j+i; k++) {
					numbers[k-j] = arr[k];
				}
				
				double m = 0;
				for(int x=0; x<i; x++) {
					m += numbers[x];
				}
				m /= i;

				double b = 0;
				for(int x=0; x<i; x++) {
					b += Math.pow((numbers[x] - m), 2);
				}
				b /= i;

				double p = 0;
				if(b < 0) {
					b *= -1;
				}
				p = Math.sqrt(b);
				
				M = Math.min(M, p);
				System.out.println(i);
			}
		}
		
		System.out.printf("%.11f", M);
	}
}
