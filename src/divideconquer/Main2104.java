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
		
		long MAX = 0;
		MAX = divcon(0, N-1);
		System.out.println(MAX);
	}

	private static long divcon(int start, int end) throws IOException {
		if(start == end) {
			return arrN[start] * arrN[end];
		}
		
		int mid = (start + end) / 2;
		bw.append(start + " to " + mid + ", " + (mid+1) + " to " + end + "\n");
		
		long ret = 0;
		long retL = divcon(start, mid);
		bw.append("retL : " + retL);
		long retR = divcon(mid+1, end);
		bw.append("retR : " + retR);
		bw.append("\n" + start + " to " + mid + ", " + (mid+1) + " to " + end + "\n");
		
		ret = Math.max(retL, retR);
		bw.append(" ret : " + ret + " \n");
		
		int MIN = Math.min(arrN[mid], arrN[mid+1]);
		long retLR = (arrN[mid] + arrN[mid+1]) * MIN;
		bw.append("min : " + MIN + " retLR : " + retLR);
		
		ret = Math.max(ret, retLR);
		bw.append("\n retF : " + ret + " \n");
		bw.flush();
		
		return ret;
	}
}
