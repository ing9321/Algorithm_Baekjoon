package bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1697 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 * bfs
 */
public class Main1697 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1697.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken().trim());
		int K = Integer.parseInt(st.nextToken().trim());
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] visit = new int[100001];
		visit[N] = 0;
		queue.add(N);
		
		while(!queue.isEmpty()){
			int x = queue.poll();
			if(x == K){
				System.out.println(visit[x]);
			} else {
				if(x-1 >= 0 && visit[x-1] == 0) {
					visit[x-1] = visit[x]+1;
					queue.add(x-1);
				}
				if(x+1 <= 100000 && visit[x+1] == 0) {
					visit[x+1] = visit[x]+1;
					queue.add(x+1);
				}
				if(x*2 <= 100000 && visit[x*2] == 0) {
					visit[x*2] = visit[x]+1;
					queue.add(x*2);
				}
			}
		}
	}
}