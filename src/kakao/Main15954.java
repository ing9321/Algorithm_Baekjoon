package kakao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15954 {
	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input15954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().trim().split(" ");
		N = Integer.parseInt(nk[0]);
		K = Integer.parseInt(nk[1]);
		arr = new int[N];
		String str = br.readLine().trim();
		StringTokenizer st = new StringTokenizer(str);
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken().trim());
		}
		for(int i=1, size = 1<<N; i<size; i++) {
			System.out.print("[");
			for(int j=0; j<N; j++) {
				if((i & 1<<j) != 0) {
					System.out.print(arr[j] + " ");
				}
			}

			System.out.println("]");
		}
	}
}
