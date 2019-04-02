package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 16000 섬
 * https://www.acmicpc.net/problem/16000
 * simulation, bfs (섬을 dfs로 재귀호출할 경우 시간초과!)
 */
public class Main16000 {
	static int N, M, C;
	static int[][] matrix;
	static boolean[][] visit;
	static int[][] pos = {{-1,0}, {0,1}, {1,0}, {0,-1}, {1,1}, {1,-1}, {-1,-1}, {-1,1}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16000.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] charr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(charr[j] == '.') {
					matrix[i][j] = -1;
				}
			}
		}

//		bfs(0, 0);
		
		LinkedList<int[]> sea = new LinkedList<int[]>();
		LinkedList<int[]> safe = new LinkedList<int[]>();
		sea.offer(new int[] {0, 0});
		visit[0][0] = true;
		while(!sea.isEmpty()) {
			int[] current = sea.poll();
			int cx = current[0];
			int cy = current[1];
			for (int i = 0; i < 8; i++) {
				int nx = cx + pos[i][0];
				int ny = cy + pos[i][1];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) continue;
				if(matrix[nx][ny] == -1) { // 바다일 때
					if((i == 4 && matrix[nx-1][ny] >= 0 && matrix[nx][ny-1] >= 0 && matrix[nx-1][ny] == matrix[nx][ny-1])
							|| (i == 5 && matrix[nx-1][ny] >= 0 && matrix[nx][ny+1] >= 0 && matrix[nx-1][ny] == matrix[nx][ny+1])
							|| (i == 6 && matrix[nx+1][ny] >= 0 && matrix[nx][ny+1] >= 0 && matrix[nx+1][ny] == matrix[nx][ny+1])
							|| (i == 7 && matrix[nx+1][ny] >= 0 && matrix[nx][ny-1] >= 0 && matrix[nx+1][ny] == matrix[nx][ny-1])) {
						continue;
					}
					visit[nx][ny] = true;
					sea.offer(new int[] {nx, ny});
				} else if(matrix[nx][ny] == 0) { // 섬일 때
					C++;
					safe.offer(new int[] {nx, ny});
					matrix[nx][ny] = C;
					visit[nx][ny] = true;
					while(!safe.isEmpty()) {
						int[] sp = safe.poll();
						for (int j = 0; j < 4; j++) {
							int sx = sp[0] + pos[j][0];
							int sy = sp[1] + pos[j][1];
							if(sx < 0 || sy < 0 || sx >= N || sy >= M || visit[sx][sy]) continue;
							if(matrix[sx][sy] == 0) {
								matrix[sx][sy] = C;
								visit[sx][sy] = true;
								safe.offer(new int[] {sx, sy});
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(matrix[i][j] < 0) {
					sb.append('.');
				} else if(matrix[i][j] == 0) {
					sb.append('X');
				} else {
					sb.append('O');
//					sb.append(matrix[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x, y});
		visit[x][y] = true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];
			for (int i = 0; i < 8; i++) {
				int nx = cx + pos[i][0];
				int ny = cy + pos[i][1];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(!visit[nx][ny]) {
					if(matrix[nx][ny] < 0) { // 바다일 때
						if((i == 4 && matrix[cx+1][cy] >= 0 && matrix[cx][cy+1] >= 0 && matrix[cx+1][cy] == matrix[cx][cy+1])
								|| (i == 5 && matrix[cx+1][cy] >= 0 && matrix[cx][cy-1] >= 0 && matrix[cx+1][cy] == matrix[cx][cy-1])
								|| (i == 6 && matrix[cx-1][cy] >= 0 && matrix[cx][cy-1] >= 0 && matrix[cx-1][cy] == matrix[cx][cy-1])
								|| (i == 7 && matrix[cx-1][cy] >= 0 && matrix[cx][cy+1] >= 0 && matrix[cx-1][cy] == matrix[cx][cy+1])) {
							continue;
						}
						visit[nx][ny] = true;
						queue.offer(new int[] {nx, ny});
					} else if(matrix[nx][ny] == 0) { // 섬일 때
						C++;
						dfs(nx, ny);
					}
				}
			}
		}
	}
	
	private static void dfs(int x, int y) {
		if(!visit[x][y]) {
			visit[x][y] = true;
			matrix[x][y] = C;
			for (int i = 0; i < 4; i++) {
				int nx = x + pos[i][0];
				int ny = y + pos[i][1];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) continue;
				if(matrix[nx][ny] == 0) {
					dfs(nx, ny);
				}
			}
		}
	}
}
