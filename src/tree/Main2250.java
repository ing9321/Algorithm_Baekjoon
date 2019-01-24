package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2250 {
	static int N, maxL;
	static ArrayList<Node2250> tree;
	static int[] levels, lefts, rights;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2250.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()); // 노드 갯수
		
	}
}

class Node2250 {
	int data;
	int left, right;
}