package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 구간 합 구하기 : 시간초과
public class Main2042 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2042.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMK = br.readLine().split(" ");
		long N = Long.parseLong(NMK[0]);
		long M = Long.parseLong(NMK[1]);
		long K = Long.parseLong(NMK[2]);
		List<Long> list = new ArrayList<Long>();
		for(long n=0; n<N; n++) {
			list.add(Long.parseLong(br.readLine().trim()));
		}
		for(long mk=0, mksize=M+K; mk<mksize; mk++) {
			String[] abc = br.readLine().split(" ");
			int a = Integer.parseInt(abc[0]);
			long b = Long.parseLong(abc[1]);
			long c = Long.parseLong(abc[2]);
			switch(a) {
			case 1:
				list.set((int)b-1, c);
				break;
			case 2:
				long result = 0;
				for(long i=b-1; i<c; i++) {
					result += list.get((int)i);
				}
				System.out.println(result);
				break;
			}
		}
	}
}
