package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 1967 트리의 지름
 * https://www.acmicpc.net/problem/1967
 * (트리, BFS)
 */
public class Main1967 {
	static int N, A;
	static ArrayList<ArrayList<Node1967>> nodes;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1967.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		nodes = new ArrayList<ArrayList<Node1967>>();
		for(int i=0; i<=N; i++) {
			nodes.add(new ArrayList<Node1967>());
		}
		
		for(int i=0; i<N-1; i++) {
			String[] line = br.readLine().trim().split(" ");
			int parent = Integer.parseInt(line[0]);
			int child = Integer.parseInt(line[1]);
			int cost = Integer.parseInt(line[2]);
			// get(i) : ArrayList<Node1967>
			nodes.get(parent).add(new Node1967(child, cost));
		}
	
		getDiameter(1);
		System.out.println(A);
	}
	
	public static int getDiameter(int root) {
		int size = nodes.get(root).size();
		int L1 = 0, L2 = 0, temp = 0;
		if(size == 0) { // child가 없으면
			return 0;
		}
		
		for(int i=0; i<size; i++) {
			int node = nodes.get(root).get(i).child;
			temp = nodes.get(root).get(i).cost + getDiameter(node); // 현재 자식 가중치 + 그 자식의 자식들 가중치
			
			if(temp > L1) {
				L2 = L1;
				L1 = temp;
			} else if(temp > L2) {
				L2 = temp;
			}
		}
		A = Math.max(A, L1+L2);
		
		return L1;
	}
}

class Node1967 {
	int child;
	int cost;
	public Node1967(int child, int cost) {
		this.child = child;
		this.cost = cost;
	}
}