package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 14891 톱니바퀴
 * https://www.acmicpc.net/problem/14891
 * Simulation
 */
public class Main14891 {
	static ArrayList<ArrayList<Integer>> wheels; 
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input14891.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wheels = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 4; i++) {
			char[] charr = br.readLine().toCharArray();
			wheels.add(new ArrayList<Integer>());
			for (int j = 0; j < 8; j++) {
				wheels.get(i).add(charr[j]-'0');
			}
		}
		
		int K = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			left(num, dir);
			run(num, dir*(-1));
			right(num, dir);
		}
		
		int sum = 0;
		for (int j = 0; j < 4; j++) {
			sum += wheels.get(j).get(0) * (1 << j);
		}
		System.out.println(sum);
	}
	private static void left(int num, int dir) {
		if((num - 1 >= 0) && (wheels.get(num-1).get(2) != wheels.get(num).get(6))) {
			left(num-1, dir*(-1));
		}
		run(num, dir);
	}
	private static void right(int num, int dir) {
		if((num + 1 < 4) && (wheels.get(num).get(2) != wheels.get(num+1).get(6))) {
			right(num+1, dir*(-1));
		}
		run(num, dir);
	}
	
	private static void run(int num, int dir) {
		if(dir > 0) {
			int last = wheels.get(num).size();
			int data = wheels.get(num).get(last-1);
			wheels.get(num).remove(last-1);
			wheels.get(num).add(0, data);
		} else {
			int data = wheels.get(num).get(0);
			wheels.get(num).remove(0);
			wheels.get(num).add(data);
		}
	}
}
