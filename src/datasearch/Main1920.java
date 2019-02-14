package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 찾기
public class Main1920 {
	static int[] arr;
	static int key;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1920.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		arr = new int[N];
		String[] ns = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(ns[i]);
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine().trim());
		String[] ms = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			key = Integer.parseInt(ms[i]);
			binarySearch(0, arr.length-1);
		}
	}

	public static void binarySearch(int start, int end) {
		if(start > end) {
			System.out.println(0);
			return;
		}
		int middle = (start + end) / 2;
		if(arr[middle] == key) {
			System.out.println(1);
			return;
		} else if(arr[middle] > key) {
			binarySearch(start, middle-1);
		} else if(arr[middle] < key) {
			binarySearch(middle+1, end);
		}
	}
}
