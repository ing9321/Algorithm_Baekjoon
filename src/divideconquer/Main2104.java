package divideconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

// 부분배열 고르기
public class Main2104 {
	static int[] arrN;
	static int MAX;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2104.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		arrN = new int[N];
		String[] arrS = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(arrS[i]);
		}
		
		BigInteger MAX = BigInteger.ZERO;
		
		for(int n=0; n<N; n++) {
			bw.append("******n : " + n + "\n");
			MAX = divcon(n, N-1);
		}
		System.out.println(MAX);
	}

	private static BigInteger divcon(int start, int end) throws IOException {
		if(start == end) {
			bw.append(" " + start + " = " + end + " ");
			return BigInteger.valueOf(arrN[start] * arrN[end]);
		}
		
		int left = (start + end) / 2;
		int right = left+1;
		
		BigInteger ret = BigInteger.ZERO;
		BigInteger retL = divcon(start, left);
		bw.append("retL : " + retL);
		BigInteger retR = divcon(right, end);
		bw.append("retR : " + retR);
		
		bw.append("\n" + start + " to " + end + "\n");
		
		if(retL.compareTo(retR) == 1) {
			ret = retL;
		} else {
			ret = retR;
		}
		bw.append(" ret : " + ret + " ");
		
		
		int MIN = Math.min(arrN[left], arrN[right]);
		BigInteger retLR = BigInteger.valueOf((arrN[left] + arrN[right]) * MIN);
		bw.append("retLR : " + retLR);
		if(ret.compareTo(retLR) == -1) {
			ret = retLR;
		}
		bw.append("\n ret : " + ret + " \n");
		bw.flush();
		
		return ret;
	}
}
