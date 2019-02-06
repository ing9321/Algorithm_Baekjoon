package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// 가운데를 말해요
public class Main1655 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1655.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Queue<Integer> min_heap = new PriorityQueue<Integer>();
		Queue<Integer> max_heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for(int n=0; n<N; n++) {
			if(min_heap.size() == max_heap.size()) {
				max_heap.add(Integer.parseInt(br.readLine().trim()));
			} else {
				min_heap.add(Integer.parseInt(br.readLine().trim()));
			}
			if(!min_heap.isEmpty() && min_heap.peek() < max_heap.peek()) {
				int temp = min_heap.poll();
				min_heap.add(max_heap.poll());
				max_heap.add(temp);
			}
			System.out.println(max_heap.peek());
		}
	}
}
