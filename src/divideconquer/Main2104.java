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
	static int[] arrN, sumN;
	static int MAX;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2104.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		arrN = new int[N];
		sumN = new int[N];
		String[] arrS = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(arrS[i]);
			if(i > 0) {
				sumN[i] = arrN[i] + sumN[i-1];
			}
		}
		
		BigInteger MAX = BigInteger.ZERO;
		MAX = divcon(0, N-1);
		System.out.println(MAX);
	}

	private static BigInteger divcon(int start, int end) throws IOException {
		if(start == end) {
			return BigInteger.valueOf(arrN[start] * arrN[end]);
		}
		
		int left = (start + end) / 2;
		int right = left+1;
		bw.append(start + " to " + left + ", " + right + " to " + end + "\n");
		
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
		bw.append(" ret : " + ret + " \n");
		
		
		bw.append("\n" + start + " to " + left + ", " + right + " to " + end + "\n");
		int MIN = Math.min(arrN[left], arrN[right]);
		BigInteger retLR = BigInteger.valueOf((arrN[left] + arrN[right]) * MIN);
		bw.append("min : " + MIN + " retLR : " + retLR);
		if(ret.compareTo(retLR) == -1) {
			ret = retLR;
		}
		bw.append("\n retF : " + ret + " \n");
		bw.flush();
		
		return ret;
	}
}
