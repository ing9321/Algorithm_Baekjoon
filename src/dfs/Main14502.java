package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14502 {
	static int N, M, S;
	static int[][] map, vmap;
	static int[][] pos = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input14502.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken().trim()); // row
		M = Integer.parseInt(st.nextToken().trim()); // column
		map = new int[N][M];
		vmap = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken().trim()); 
			}
		}
		
		for(int i=0, size=N*M; i<size; i++) {
			int r = i / M;
			int c = i % M;
			if(map[r][c] == 0) {
				wall(i, 0);
			}
		}
		System.out.println(S);
	}

	public static void wall(int position, int cnt) {
		int r = position / M;
		int c = position % M;
		map[r][c] = 1;
		cnt++;
		if(cnt == 3) {
			for(int i=0; i<N; i++) {
				System.arraycopy(map[i], 0, vmap[i], 0, M);
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(vmap[i][j] == 2) {
						virus(i, j);
					}
				}
			}
			int safe = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(vmap[i][j] == 0) {
						safe++;
					}
				}
			}
			S = Math.max(S, safe);
		} else {
			for(int i=position, size=M*N; i<size; i++) {
				int nr = i / M;
				int nc = i % M;
				if(map[nr][nc] == 0) {
					wall(i, cnt);
				}
			}
		}
		map[r][c] = 0;
		--cnt;
	}
	
	public static void virus(int i, int j) {
		for(int s=0, size=pos.length; s<size; s++) {
			int ni = i+pos[s][0];
			int nj = j+pos[s][1];
			if(ni>=0 && nj>=0 && ni<N && nj<M && vmap[ni][nj] == 0) {
				vmap[ni][nj] = 2;
				virus(ni, nj);
			}
		}
	}
}
