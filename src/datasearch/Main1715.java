package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 카드 정렬하기
public class Main1715 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1715.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Queue<Integer> heap = new PriorityQueue<Integer>();
		int sum = 0;
		for(int n=0; n<N; n++) {
			heap.add(Integer.parseInt(br.readLine().trim()));
		}
		while(heap.size() > 1) {
			int x = heap.poll();
			int y = heap.poll();
			sum += x+y;
			heap.add(x+y);
		}
		System.out.println(sum);
	}
}
