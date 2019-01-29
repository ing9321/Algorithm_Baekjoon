package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2250 {
	static int N;
	static Tree2250 tree;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2250.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()); // 노드 갯수
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken().trim());
			
		}
	}
}

class Tree2250 {
	private class TreeNode {
		int data;
		TreeNode left, right;
		public TreeNode(int data) {
			this.data = data;
		}
	}
	TreeNode root = null;
	public TreeNode insert(int x, int y, int z) {
		return null;
	}
}