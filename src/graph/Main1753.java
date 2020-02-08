package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 1753 최단경로
 * https://www.acmicpc.net/problem/1753
 * 다익스트라 알고리즘
 * 
 * 시작점에서 모든 정점으로의 최단 경로
 * 
 * ** 가중치인접행렬로 구현했을 때, 정점의 개수가 최대 20,000이라 메모리 초과
 * ** 인접리스트와 우선순위큐를 이용해서 구현할 것
 */

public class Main1753 {
	public static int V, E, K;
	public static ArrayList<ArrayList<Node1753>> weights;
	public static int[] dist; // 시작 정점부터의 최단거리 배열
	public static boolean[] visit; // 방문한 정점
	public static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1753.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		V = Integer.parseInt(st.nextToken().trim()); // 정점의 개수
		E = Integer.parseInt(st.nextToken().trim()); // 간선의 개수
		K = Integer.parseInt(br.readLine().trim()); // 시작 정점
		
		weights = new ArrayList<ArrayList<Node1753>>();
		for (int i = 0; i < V+1; i++) {
			weights.add(new ArrayList<Node1753>());
		}
		
		int u = 0, v = 0, w = 0; // u에서 v로 가는 간선의 가중치 w
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			u = Integer.parseInt(st.nextToken().trim());
			v = Integer.parseInt(st.nextToken().trim());
			w = Integer.parseInt(st.nextToken().trim());
			weights.get(u).add(new Node1753(v, w));
		}
		
		// 다익스트라 알고리즘 (우선순위큐 이용)
		dist = new int[V+1];
		visit = new boolean[V+1];
		// 최단거리배열 초기화, 자기자신은 0
		Arrays.fill(dist, INF);
		dist[K] = 0;

		PriorityQueue<Node1753> pq = new PriorityQueue<Node1753>();
		pq.add(new Node1753(K, 0));
		while(!pq.isEmpty()) {
			Node1753 cur = pq.poll();
			if(visit[cur.index]) continue;
			visit[cur.index] = true;
			
			// 현재 위치에서 갈 수 있는 노드 탐색
			for (Node1753 node : weights.get(cur.index)) {
				if(dist[node.index] > node.distance + dist[cur.index]) {
					dist[node.index] = node.distance + dist[cur.index];
					pq.add(new Node1753(node.index, dist[node.index]));
				}
			}
		}
		
		for (int i = 1; i < V+1; i++) {
			if(dist[i] < INF) {
				System.out.println(dist[i]);
			} else {
				System.out.println("INF");
			}
		}
	}
}
class Node1753 implements Comparable<Node1753> {
	int index, distance;
	Node1753(int i, int d) {
		this.index = i;
		this.distance = d;
	}
	@Override
	public int compareTo(Node1753 o) {
		// TODO Auto-generated method stub
		return this.distance - o.distance;
	}
}