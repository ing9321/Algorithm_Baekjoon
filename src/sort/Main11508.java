package sort;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

/*
 * 11508 2+1 세일
 * https://www.acmicpc.net/problem/11508
 */
public class Main11508 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input11508.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			queue.offer(Integer.parseInt(br.readLine().trim()));
		}
		Collections.sort(queue, Collections.reverseOrder());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int temp = queue.poll();
			if(i%3 < 2) {
				sum += temp;
			}
		}
		System.out.println(sum);
	}
}
