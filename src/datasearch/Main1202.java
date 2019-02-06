package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 보석 도둑
public class Main1202 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1202.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		int[][] jwl = new int [N][2];
		Queue<Integer> bag_heap = new PriorityQueue<Integer>();
		int max = 0;
		for(int n=0; n<N; n++) {
			String[] MV = br.readLine().split(" ");
			int M = Integer.parseInt(MV[0]);
			int V = Integer.parseInt(MV[1]);
			jwl[n][0] = M;
			jwl[n][1] = V;
		}
		for(int k=0; k<K; k++) {
			int C = Integer.parseInt(br.readLine().trim());
			bag_heap.add(C);
		}
		for(int k=0; k<K; k++) {
			
		}
	}
}
