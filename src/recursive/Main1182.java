package recursive;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 부분집합의 합
public class Main1182 {
	static int N, S, C;
	static int[] data;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input1182.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken().trim()); // 정수의 갯수
		S = Integer.parseInt(st.nextToken().trim()); // 정수
		data = new int[N];
		str = br.readLine().trim();
		st = new StringTokenizer(str);
		for(int i=0; i<N; i++){
			data[i] = Integer.parseInt(st.nextToken().trim());
		}
		
		System.out.println(Arrays.toString(data));

		for(int i=1, size = 1<<N; i<size; i++) {
			int sum = 0;
			System.out.print("[");
			for(int j=0; j<N; j++) {
				if((i & 1<<j) != 0) {
					System.out.print(data[j] + " ");
					sum += data[j];
				}
			}

			System.out.println("]");
			if(sum == S) {
				C++;
				System.out.println("****************" + C + "S");
			}
			sum = 0;
		}
		System.out.println(C);
	}
}