package divideconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 트리 순회
public class Main2263 {
	static int[] inorder, postorder;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		inorder = new int[N+1];
		postorder = new int[N];
		
		String[] strin = br.readLine().split(" ");
		for(int n=0; n<N; n++) {
			int p = Integer.parseInt(strin[n]);
			inorder[p] = n;
		}
		String[] strpost = br.readLine().split(" ");
		for(int n=0; n<N; n++) {
			postorder[n] = Integer.parseInt(strpost[n]);
		}
		
		setPreorder(0, N-1, 0, N-1);
		bw.close();
	}


	private static void setPreorder(int instart, int inend, int poststart, int postend) throws IOException {
		if(instart > inend || poststart > postend) {
			return;
		}
		int root = postorder[postend];
		bw.append(root + " ");
		
		setPreorder(instart, inorder[root]-1, poststart, poststart + inorder[root] - instart -1);
		setPreorder(inorder[root]+1, inend, poststart + inorder[root] - instart, postend-1);
	}
}
