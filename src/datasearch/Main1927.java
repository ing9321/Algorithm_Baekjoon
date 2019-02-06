package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 최소힙
public class Main1927 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1927.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Queue heap = new PriorityQueue();
		for(int n=0; n<N; n++) {
			int x = Integer.parseInt(br.readLine().trim());
			if(x == 0) {
				if(heap.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(heap.poll());
				}
			} else {
				heap.add(x);
			}
		}
	}
}
