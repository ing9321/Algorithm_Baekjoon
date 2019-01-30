package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2250 {
	static int N;
	static ArrayList<Node> tree;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2250.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()); // 노드 갯수
		tree = new ArrayList<Node>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int data = Integer.parseInt(st.nextToken().trim());
			int left = Integer.parseInt(st.nextToken().trim());
			int right = Integer.parseInt(st.nextToken().trim());
			
		}
	}
	
	static class Node {
		int parent, data, left, right;
		public Node(int parent, int data, int left, int right) {
			this.parent = -1;
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}