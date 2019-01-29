package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main11403 {
	static ArrayList<Node11403> tree;
	static int[][] ANSWER;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input11403.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		ANSWER = new int[N][N];
		tree = new ArrayList<Node11403>(N+1);
		for(int i=0; i<=N; i++) {
			tree.add(new Node11403());
		}
		
		for(int i=1; i<=N; i++) {
			String[] str = br.readLine().trim().split(" ");
			for(int j=1; j<=N; j++) {
				int edge = Integer.parseInt(str[j-1]);
				if(i != j && edge != 0) {
					tree.get(i).children.add(j);
					tree.get(i).childcnt++;
				}
			}
		}
		System.out.println(Arrays.toString(tree.toArray()));
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int r = getRoute(tree.get(j), i);
				System.out.print(r + " ");				
			}
			System.out.println();
		}
	}
	public static int getRoute(Node11403 node, int origin) {
		int temp = 0;
		if(node.childcnt == 0) {
			return temp;
		}
		for(int c : node.children) {
			if(origin == c) {
				temp = 1;
				return temp;
			} else {
				temp = getRoute(tree.get(c), origin);
			}
		}
		return temp;
	}
}
class Node11403 {
	ArrayList<Integer> children = new ArrayList<Integer>();
	int childcnt;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node11403 [children=");
		builder.append(children);
		builder.append(", childcnt=");
		builder.append(childcnt);
		builder.append("]");
		return builder.toString();
	}
	
}