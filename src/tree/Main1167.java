package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1167 {
	static int N, A;
	static ArrayList<ArrayList<Node1167>> nodes;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1167.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		visit = new boolean[N+1];
		nodes = new ArrayList<ArrayList<Node1167>>();
		for(int i=0; i<=N; i++) {
			nodes.add(new ArrayList<Node1167>());
		}
		
		for(int i=0; i<N; i++) {
			String str = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(str);
			int parent = Integer.parseInt(st.nextToken().trim());
			int ver = Integer.parseInt(st.nextToken().trim());
			while(ver != -1) {
				int edge = Integer.parseInt(st.nextToken().trim());
				nodes.get(parent).add(new Node1167(ver, edge));
				ver = Integer.parseInt(st.nextToken().trim());
			}
		}
		getDiameter(1);
		System.out.println(A);
	}
	
	public static int getDiameter(int root) {
		System.out.println(root);
		visit[root] = true;
		
		int size = nodes.get(root).size();
		int L1 = 0, L2 = 0, temp = 0;
		if(size == 0) {
			return 0;
		}
		
		for(int i=0; i<size; i++) {
			Node1167 node = nodes.get(root).get(i);
			if(!visit[node.vertex]) {
				temp = node.edge + getDiameter(node.vertex);
				if(temp > L1) {
					L2 = L1;
					L1 = temp;
				} else if(temp > L2) {
					L2 = temp;
				}
			}
		}
		
		A = Math.max(A, L1 + L2);
		return L1;
	}
}

class Node1167 {
	int vertex;
	int edge;
	public Node1167(int vertex, int edge) {
		this.vertex = vertex;
		this.edge = edge;
	}
}