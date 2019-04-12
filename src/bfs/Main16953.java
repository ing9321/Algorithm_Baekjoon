package bfs;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 16953 A->B
 * https://www.acmicpc.net/problem/16953
 * BFS
 */
public class Main16953 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = -1;
		
		LinkedList<long[]> queue = new LinkedList<long[]>();
		queue.offer(new long[] {A, 1});
		while(!queue.isEmpty()) {
			long[] cur = queue.poll();
			long tmp = cur[0] << 1;
			if(tmp == B) {
				C = cur[1] + 1;
				break;
			} else if(tmp < B) {
				queue.offer(new long[] {tmp, cur[1]+1});
			}
			tmp = cur[0] * 10 + 1;
			if(tmp == B) {
				C = cur[1] + 1;
				break;
			} else if(tmp < B) {
				queue.offer(new long[] {tmp, cur[1]+1});
			}
		}
		
		System.out.println(C);
	}

}
