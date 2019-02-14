package divideconquer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main2263 {
	static int[] inorder, postorder, preorder;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		inorder = new int[N];
		postorder = new int[N];
		preorder = new int[N];
		
		String[] strin = br.readLine().split(" ");
		for(int n=0; n<N; n++) {
			inorder[n] = Integer.parseInt(strin[n]);
		}
		String[] strpost = br.readLine().split(" ");
		for(int n=0; n<N; n++) {
			postorder[n] = Integer.parseInt(strpost[n]);
		}
		
	}


	private static void setPreorder(int instart, int inend, int poststart, int postend) {
		int root = postorder[postend]; // 2
		
		// inorder에서 root값 찾아서 왼쪽 읽고 오른쪽 읽고
		
		
	}
}
