package tree;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1068 {
	static int N, D, R;
	static ArrayList<Node1068> tree;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1068.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		tree = new ArrayList<Node1068>(N);
		for(int i=0; i<N; i++) {
			tree.add(new Node1068());
		}
		
		String str = br.readLine().trim();
		StringTokenizer st = new StringTokenizer(str);
		R = 0;
		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken().trim());
			if(parent == -1) { // root node 설정
				R = i;
			} else {
				tree.get(parent).children.add(i);
				tree.get(parent).childcnt++;
			}
		}
		D = Integer.parseInt(br.readLine().trim());
		if(D == R) {
			System.out.println(0);
		} else {
			System.out.println(deleteNode(R));
		}
	}
	public static int deleteNode(int root) {
		int count = 0;
		Node1068 node = tree.get(root);
		for(int i=0, size=node.childcnt; i<size; i++) {
			int cnode = node.children.get(i);
			if(cnode != D) {
				count += deleteNode(cnode);
			} else {
				node.children.remove(i);
				i--;
				size--;
				node.childcnt--;
			}
		}
		if(node.childcnt == 0) {
			return 1;
		}
		return count;
	}
}

class Node1068 {
	ArrayList<Integer> children = new ArrayList<Integer>();
	int childcnt;
}