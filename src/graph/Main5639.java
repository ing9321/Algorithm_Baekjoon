package graph;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 5639 이진 검색 트리
 * https://www.acmicpc.net/problem/5639
 * 트리
 */
public class Main5639 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5639.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Tree5639 tree = new Tree5639();
		String str = br.readLine();
		while(str != null) {
			int n = Integer.parseInt(str);
			tree.add(n);
			str = br.readLine();
		}
		tree.postorder(tree.root);
	}
}
class Node5639 {
	int data;
	Node5639 left, right;
	public Node5639(int data) {
		this.data = data;
	}
}
class Tree5639 {
	Node5639 root;
	public void add(int data) {
		if(root == null) {
			root = new Node5639(data);
		} else {
			search(root, data);
		}
	}
	public void search(Node5639 root, int data) {
		if(root != null) {
			if(root.data > data) {
				if(root.left != null) {
					search(root.left, data);
				} else {
					root.left = new Node5639(data);
				}
			} else if(root.data < data) {
				if(root.right != null) {
					search(root.right, data);
				} else {
					root.right = new Node5639(data);
				}
			}
		}
	}
	public void postorder(Node5639 root) {
		if(root.left != null) {
			postorder(root.left);
		}
		if(root.right != null) {
			postorder(root.right);
		}
		System.out.println(root.data);
	}
}