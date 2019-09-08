package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 7562 나이트의 이동
 * https://www.acmicpc.net/problem/7562
 * 
 */
public class Main7562 {
	public static int I;
	public static int[][] dir = {{2,1}, {1,2}, {-1,2}, {-2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1}};
	public static LinkedList<int[]> queue;
	public static int[] dest;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7562.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < T; tc++) {
			I = Integer.parseInt(br.readLine().trim());
			queue = new LinkedList<int[]>();
			String[] str = br.readLine().trim().split(" ");
			queue.add(new int[] {Integer.parseInt(str[0]), Integer.parseInt(str[1])});
			str = br.readLine().trim().split(" ");
			dest = new int[] {Integer.parseInt(str[0]), Integer.parseInt(str[1])};
			
			int cnt = 0;
			if(queue.peek()[0] == dest[0] && queue.peek()[1] == dest[1]) {
				
			} else {
				start:while(!queue.isEmpty()) {
					int size = queue.size();
					cnt++;
					for (int i = 0; i < size; i++) {
						int[] cur = queue.poll();
						System.out.println(cur[0] + " " + cur[1]);
						for (int j = 0; j < 8; j++) {
							int nr = cur[0] + dir[j][0];
							int nc = cur[1] + dir[j][1];
							if(nr < 0 || nr >= I || nc < 0 || nc >= I) continue;
							if(nr == dest[0] && nc == dest[1]) {
								break start;
							} else {
								queue.add(new int[] {nr, nc});
							}
						}
					}
				}
			}
			
			System.out.println(cnt);
			
		}
	}
	
}
