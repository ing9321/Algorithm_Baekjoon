package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Dron {
	int n, r, c, d;
	ArrayList<Integer> list;
	public Dron(int n, int r, int c, int d) {
		this.n = n;
		this.r = r;
		this.c = c;
		this.d = d;
		clearList();
	}
	public void clearList() {
		list = new ArrayList<Integer>();
		list.add(n);
	}
}
public class Main17780 {

	public static int N, K;
	public static int[][] board, map; // 0 : 흰색, 1: 빨간색, 2: 파란색
	public static Dron[] drons;
	public static int[][] dir = {{0,0}, {0,1}, {0,-1}, {-1,0}, {1,0}}; // 우, 좌, 상, 하
	public static LinkedList<Integer> queue;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17780.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken().trim());
		K = Integer.parseInt(st.nextToken().trim());
		
		board = new int[N+1][N+1];
		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}

		drons = new Dron[K+1];
		queue = new LinkedList<Integer>();
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken().trim());
			int c = Integer.parseInt(st.nextToken().trim());
			int d = Integer.parseInt(st.nextToken().trim());
			drons[i] = new Dron(i, r, c, d);
			map[r][c] = i;
			queue.offer(i);
		}
		
		
		
		
	}

	public static void toWhite(int n, int r, int c) {
		if(map[r][c] > 0) { // 이미 드론 존재
			
		} else {
			map[drons[n].r][drons[n].c] = 0;
			drons[n].r = r;
			drons[n].c = c;
			map[r][c] = n;
			queue.offer(n);
		}
	}
	
	public static void toRed(int n, int r, int c) {
		if(map[r][c] > 0) {
			
		} else {
			map[drons[n].r][drons[n].c] = 0;
			ArrayList<Integer> origin = drons[n].list;
			ArrayList<Integer> replace = new ArrayList<Integer>();
			int size = origin.size();
			for (int i = 0; i < size; i++) {
				replace.add(0, origin.get(i));
			}
			int nn = replace.get(0);
			drons[nn].r = r;
			drons[nn].c = c;
			drons[nn].list = replace;
			drons[n].clearList();
			map[r][c] = nn;
			queue.offer(nn);
		}
	}
	
	public static void toBlue(int n) {
		if(drons[n].d == 1) {
			drons[n].d = 2;
		} else if(drons[n].d == 2) {
			drons[n].d = 1;
		} else if(drons[n].d == 3) {
			drons[n].d = 4;
		} else if(drons[n].d == 4) {
			drons[n].d = 3;
		}
		
		int nr = drons[n].r + dir[drons[n].d][0];
		int nc = drons[n].c + dir[drons[n].d][1];
		if(nr < 1 || nr > N || nc < 1 || nc > N || board[nr][nc] == 2) {
			queue.offer(n);
			return;
		}
		if(board[nr][nc] == 0) {
			toWhite(n, nr, nc);
		} else if(board[nr][nc] == 1) {
			toRed(n, nr, nc);
		}
	}
}
