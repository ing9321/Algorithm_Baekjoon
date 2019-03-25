package graph;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 1991 트리 순회
 * https://www.acmicpc.net/problem/1991
 * 트리
 */
public class Main1991 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1991.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Tree1991 tree = new Tree1991();
		for(int i=0; i<N; i++) {
			char[] arr = br.readLine().replaceAll(" ", "").toCharArray();
			tree.add(arr[0], arr[1], arr[2]);
		}
		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
		System.out.println();
	}
}
class Node1991 {
	char data;
	Node1991 left, right;
	public Node1991(char data) {
		this.data = data;
	}
}
class Tree1991 {
	Node1991 root;
	public void add(char data, char left, char right) {
		if(root == null) {
			root = new Node1991(data);
			if(left != '.') {
				root.left = new Node1991(left);
			}
			if(right != '.') {
				root.right = new Node1991(right);
			}
		} else {
			search(root, data, left, right);
		}
	}
	public void search(Node1991 root, char data, char left, char right) {
		if(root != null) {
			if(root.data == data) {
				if(left != '.') {
					root.left = new Node1991(left);
				}
				if(right != '.') {
					root.right = new Node1991(right);
				}
			} else {
				search(root.left, data, left, right);
				search(root.right, data, left, right);
			}
		}
	}
	public void preorder(Node1991 root) {
		System.out.print(root.data);
		if(root.left != null) {
			preorder(root.left);
		}
		if(root.right != null) {
			preorder(root.right);
		}
	}
	public void inorder(Node1991 root) {
		if(root.left != null) {
			inorder(root.left);
		}
		System.out.print(root.data);
		if(root.right != null) {
			inorder(root.right);
		}
	}
	public void postorder(Node1991 root) {
		if(root.left != null) {
			postorder(root.left);
		}
		if(root.right != null) {
			postorder(root.right);
		}
		System.out.print(root.data);
	}
}