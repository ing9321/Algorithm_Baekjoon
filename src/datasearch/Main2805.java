package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

// 나무 자르기
public class Main2805 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]); // 나무수
		int M = Integer.parseInt(NM[1]); // 자르려는 길이
		int[] tree = new int[N];
		String[] H = br.readLine().split(" ");
		for(int n=0; n<N; n++) {
			tree[n] = Integer.parseInt(H[n]);
		}
		Arrays.sort(tree);
		
		int maxH = tree[tree.length-1]; // 톱날 최대 높이
		int minH = 0; // 톱날 최소 높이
		while(minH <= maxH) {
			int middle = (maxH + minH) / 2;
			long cutSum = 0;
			for(int h : tree) {
				int cut = h - middle;
				if(cut > 0) {
					cutSum += cut;
				}
			}
			
			System.out.println(cutSum + " " + minH + " " + maxH + " " + middle);
			
			if(cutSum >= M) {
				minH = middle + 1;
			} else if(cutSum < M){
				maxH = middle -1;
			}
		}
		System.out.println(maxH);
	}
}
