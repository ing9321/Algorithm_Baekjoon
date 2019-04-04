package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 2042 구간 합 구하기 : 시간초과
 * https://www.acmicpc.net/problem/2042 
 * 세그먼트 트리, 인덱스 트리
 */
public class Main2042 {
	static long[] tree;
	static int N, M, K, C, idxL, idxR;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2042.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken()); // 수의 개수
		M = Integer.parseInt(st.nextToken()); // 변경이 일어나는 횟수
		K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수
		C = 1 << (int) Math.ceil(Math.log(N) / Math.log(2)); // 리프 노드의 개수 : 2^C
		tree = new long[C<<1];
		
		
		
		// 리프노드 입력받기
		for(int n=0; n<N; n++) {
			long leaf = Long.parseLong(br.readLine().trim());
			tree[C+n] = leaf;
		}
		setTree();
		System.out.println(Arrays.toString(tree));
		
		
		for(long mk = 0, mksize = M+K; mk < mksize; mk++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			switch(a) {
			case 1: // b를 c로 바꾸기
				change(b, c);
				break;
			case 2: // b부터 c까지 구간 합
				idxL = b-1;
				idxR = c-1;
				System.out.println(b + " ~ " + c);
				System.out.println(nodeSum(1, 0, N-1));
				break;
			}
		}
	}
	private static void setTree() {
		for (int i = C-1; i > 0; i--) {
			tree[i] = tree[i<<1] + tree[(i<<1)+1];
		}
	}
	private static void change(int n, long value) {
		n += C - 1;
		tree[n] = value;
		while(n > 1) {
			n = n>>1;
			tree[n] = tree[n<<1] + tree[(n<<1)+1];
		}
	}
	private static long nodeSum(int nodeP, int nodeL, int nodeR) {
		System.out.println(nodeP + "," + nodeL + ", " + nodeR);
		if(nodeL > idxR || nodeR < idxL) return 0;
		if(nodeL >= idxL && nodeR <= idxR) return tree[nodeP];
		int mid = (idxL+idxR) >> 1;
		return nodeSum(nodeP<<1, nodeL, mid) + nodeSum((nodeP<<1)+1, mid+1, nodeR);
	}
}
