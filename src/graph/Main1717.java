package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 1717 집합의 표현
 * https://www.acmicpc.net/problem/1717
 * Disjoint-set
 * 
 * {0}, {1}, ... , {n} 집합
 * 0 a b : 합집합 연산
 * 1 a b : 두 원소가 같은 집합인지 확인하는 연산
 * 
 * ** 합집합인지 확인할 때 부모 배열이 아닌 find-set 함수를 통해 리턴한 부모로 비교할 것!
 */
public class Main1717 {
	public static int n, m;
	public static int[] parents;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1717.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken().trim()); // 0 ~ n 집합
		m = Integer.parseInt(st.nextToken().trim()); // 연산의 개수
		
		parents = new int[n+1]; // index는 0~n까지의 수, 값은 합집합의 부모 노드
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		
		int c = 0, a = 0, b = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			c = Integer.parseInt(st.nextToken().trim());
			a = Integer.parseInt(st.nextToken().trim());
			b = Integer.parseInt(st.nextToken().trim());
			if(c != 0) {
				if(find(a) != find(b)) {
					bw.append("NO\n");
				} else {
					bw.append("YES\n");
				}
			} else {
				union(a, b);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void union(int v, int w) {
		v = find(v);
		w = find(w);
		
		if(v == w) return;
		
		parents[w] = v;
	}
	public static int find(int v) {
		if(parents[v] == v) {
			return v;
		}
		return parents[v] = find(parents[v]);
	}
}
