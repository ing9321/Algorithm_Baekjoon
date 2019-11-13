package bruteforce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 14500 테트로미노
 * https://www.acmicpc.net/problem/14500
 * 브루트포스
 */

public class Main14500 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input14500.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().trim().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			s = br.readLine().trim().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		ArrayList<int[][]> tetrominos = new ArrayList<int[][]>();
		// ㅡ : 0,0 0,1 0,2 0,3
		tetrominos.add(new int[][] {{0,0}, {0,1}, {0,2}, {0,3}});
		
		// ㄴ2 : 0,0 0,1 0,2 1,0
		tetrominos.add(new int[][] {{0,0}, {0,1}, {0,2}, {1,0}});
		// ㄴ4 : 1,0 1,1 1,2 0,2
		tetrominos.add(new int[][] {{1,0}, {1,1}, {1,2}, {0,2}});
		// ㄱ : 0,0 0,1 0,2 1,2
		tetrominos.add(new int[][] {{0,0}, {0,1}, {0,2}, {1,2}});
		// ㄱ4 : 0,0 1,0 1,1 1,2
		tetrominos.add(new int[][] {{0,0}, {1,0}, {1,1}, {1,2}});
		// ㄹ2 : 1,0 1,1 0,1 0,2
		tetrominos.add(new int[][] {{1,0}, {1,1}, {0,1}, {0,2}});
		// ㄹ4 : 0,0 0,1 1,1 1,2
		tetrominos.add(new int[][] {{0,0}, {0,1}, {1,1}, {1,2}});
		// ㅜ : 0,0 0,1 0,2 1,1
		tetrominos.add(new int[][] {{0,0}, {0,1}, {0,2}, {1,1}});
		// ㅜ3 : 0,1 1,0 1,1 1,2
		tetrominos.add(new int[][] {{0,1}, {1,0}, {1,1}, {1,2}});
		
		// ㅁ : 0,0 0,1 1,0 1,1
		tetrominos.add(new int[][] {{0,0}, {0,1}, {1,0}, {1,1}});
		
		// ㄴ : 0,0 1,0 2,0 2,1
		tetrominos.add(new int[][] {{0,0}, {1,0}, {2,0}, {2,1}});
		// ㄴ3 : 0,0 0,1 1,1 2,1
		tetrominos.add(new int[][] {{0,0}, {0,1}, {1,1}, {2,1}});
		// ㄱ2 : 0,0 1,0 2,0 0,1
		tetrominos.add(new int[][] {{0,0}, {1,0}, {2,0}, {0,1}});
		// ㄱ3 : 2,0 0,1 1,1 2,1
		tetrominos.add(new int[][] {{2,0}, {0,1}, {1,1}, {2,1}});
		// ㄹ : 0,0 1,0, 1,1 2,1
		tetrominos.add(new int[][] {{0,0}, {1,0}, {1,1}, {2,1}});
		// ㄹ3 : 0,1 1,1 1,0 2,0
		tetrominos.add(new int[][] {{0,1}, {1,1}, {1,0}, {2,0}});
		// ㅜ2 : 1,0 0,1 1,1 2,1
		tetrominos.add(new int[][] {{1,0}, {0,1}, {1,1}, {2,1}});
		// ㅜ4 : 0,0 1,0 2,0 1,1
		tetrominos.add(new int[][] {{0,0}, {1,0}, {2,0}, {1,1}});
		
		// ㅣ : 0,0 1,0 2,0 3,0
		tetrominos.add(new int[][] {{0,0}, {1,0}, {2,0}, {3,0}});
		
		int maxS = 0;
		for (int i = 0; i < N; i++) { // 세로
			for (int j = 0; j < M; j++) { // 가로
				for (int k = 0; k < 19; k++) {
					if(k == 0 && j+3 >= M) {
						continue;
					} else if((k > 0 && k < 9) && (i+1 >= N || j+2 >= M)) {
						continue;
					} else if(k == 9 && (i+1 >= N || j+1 >= M)) {
						continue;
					} else if((k > 9 && k < 18) && (i+2 >= N || j+1 >= M)) {
						continue;
					} else if(k == 18 && i+3 >= N) {
						continue;
					}
					int[][] tmp = tetrominos.get(k);
					int sum = map[i + tmp[0][0]][j + tmp[0][1]]
							+ map[i + tmp[1][0]][j + tmp[1][1]]
							+ map[i + tmp[2][0]][j + tmp[2][1]]
							+ map[i + tmp[3][0]][j + tmp[3][1]];
					maxS = Math.max(maxS, sum);
				}
				
			}
		}
		System.out.println(maxS);
	}

}
