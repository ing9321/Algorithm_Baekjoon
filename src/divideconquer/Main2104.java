package divideconquer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main2104 {
	static int[] arrN;
	static int MAX;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2104.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		arrN = new int[N];
		String[] arrS = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(arrS[i]);
		}
		
		BigInteger MAX = BigInteger.ZERO;
		for(int n=0; n<N; n++) {
			int min = arrN[n];
			for(int i=0; i<N-n; i++) {
				int MIN = 1000000;
				BigInteger tmp = BigInteger.ZERO;
				for(int j=i; j<n+i; j++) {
					tmp = tmp.add(BigInteger.valueOf(arrN[j]));
					MIN = Math.min(MIN, arrN[j]);
				}
				tmp = tmp.multiply(BigInteger.valueOf(MIN));
//				MAX = Math.max(MAX, tmp);
				if(MAX.compareTo(tmp) == -1) {
					MAX = tmp;
				}
			}
			
			MAX = divcon(n, N-n);
		}
		System.out.println(MAX);
	}

	private static BigInteger divcon(int start, int end) {
		if(start == end) {
			return BigInteger.valueOf(arrN[start] * arrN[end]);
		}
		
		int left = (start + end) / 2;
		int right = left+1;
		
		BigInteger ret = BigInteger.ZERO;
		BigInteger retL = divcon(start, left);
		BigInteger retR = divcon(right, end);
		if(retL.compareTo(retR) == 1) {
			ret = retL;
		} else {
			ret = retR;
		}
		
		int MIN = Math.min(left, right);
		BigInteger retLR = BigInteger.valueOf((arrN[left] + arrN[right]) * MIN);
		if(ret.compareTo(retLR) == -1) {
			ret = retLR;
		}
		
		return ret;
	}
}
