package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 미해결
 * 5373 큐빙
 * https://www.acmicpc.net/problem/5373
 * Simulation, 루믹스 큐브
 */
public class Main5373 {
	static char[][] up;
	static char[][] cube;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5373.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			up = new char[][] {
					{'w', 'w', 'w'},
					{'w', 'w', 'w'},
					{'w', 'w', 'w'}
			};
			cube = new char[][] {
					{'b','b','b','r','r','r','g','g','g','o','o','o'}, // U
					{'b','b','b','o','o','o','g','g','g','r','r','r'}, // D
					{'b','b','b','y','y','y','g','g','g','w','w','w'}, // F
					{'g','g','g','y','y','y','b','b','b','w','w','w'}, // B
					{'r','r','r','y','y','y','o','o','o','w','w','w'}, // L
					{'o','o','o','y','y','y','r','r','r','w','w','w'} // R
			};
			
			int N = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				String str = st.nextToken().trim();
				char c = str.charAt(0);
				char d = str.charAt(1);
				
				switch(c) {
				case 'U': // 윗면
//					System.out.println("위 턴");
					if(d == '+') { // 시계 방향
						turn(0, 1);
					} else if(d == '-') { // 반시계방향
						turn(0, 3);
					}
					break;
				case 'D': // 아랫면
//					System.out.println("아래 턴");
					if(d == '+') { // 시계 방향
						turn(1, 1);
					} else if(d == '-') { // 반시계방향
						turn(1, 3);
					}
					break;
				case 'F': // 앞면
//					System.out.println("앞 턴");
					if(d == '+') { // 시계 방향
						turn(2, 1);
					} else if(d == '-') { // 반시계방향
						turn(2, 3);
					}
//					System.out.println(Arrays.toString(cube[2]));
					up[2][0] = cube[2][9];
					up[2][1] = cube[2][10];
					up[2][2] = cube[2][11];
					break;
				case 'B': // 뒷면
//					System.out.println("뒤 턴");
					if(d == '+') { // 시계 방향
						turn(3, 1);
					} else if(d == '-') { // 반시계방향
						turn(3, 3);
					}
					up[0][2] = cube[3][9];
					up[0][1] = cube[3][10];
					up[0][0] = cube[3][11];
					break;
				case 'L': // 왼쪽면
//					System.out.println("왼 턴");
					if(d == '+') { // 시계 방향
						turn(4, 1);
					} else if(d == '-') { // 반시계방향
						turn(4, 3);
					}
//					System.out.println(Arrays.toString(cube[4]));
					up[0][0] = cube[4][9];
					up[1][0] = cube[4][10];
					up[2][0] = cube[4][11];
					break;
				case 'R': // 오른면
//					System.out.println("오 턴");
					if(d == '+') { // 시계 방향
						turn(5, 1);
					} else if(d == '-') { // 반시계방향
						turn(5, 3);
					}
					up[2][2] = cube[5][9];
					up[1][2] = cube[5][10];
					up[0][2] = cube[5][11];
					break;
				}
				
				
				for (int k = 0; k < 3; k++) {
					System.out.println(Arrays.toString(up[k]));
				}
			}
			System.out.println(i+1);
			for (int k = 0; k < 3; k++) {
				for (int k2 = 0; k2 < 3; k2++) {
					System.out.print(up[k][k2]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	private static void turn(int face, int cnt) {
		while(cnt > 0) {
			LinkedList<Character> queue = new LinkedList<Character>();
			for (int i = 9; i < 12; i++) {
				queue.offer(cube[face][i]);
			}
			for (int i = 0; i < 9; i++) {
				queue.offer(cube[face][i]);
			}
			
			for (int i = 0; i < 12; i++) {
				cube[face][i] = queue.poll();
			}
			cnt--;
		}
	}
}
