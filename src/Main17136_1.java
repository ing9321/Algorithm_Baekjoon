import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 미해결
 * 17136 색종이 붙이기
 * https://www.acmicpc.net/problem/17136
 * 
 * !! 1x1, 2x2, 3x3, 4x4, 5x5 각 색종이는  5장씩 존재
 */
public class Main17136_1 {
	static int[][] matrix;
	static int MIN;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17136.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		matrix = new int[10][10];
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 10; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		MIN = 25;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(matrix[i][j] == 1) {
					
				}
			}
		}

		System.out.println(MIN);
	}
	private static void dfs(int r, int c, int cnt) {
		boolean flag = true;
		for (int i = r; i < r+cnt; i++) {
			for (int j = c; j < c+cnt; j++) {
				if(matrix[i][j] == 0) {
					flag = false;
					break; 
				}
			}
		}
		if(flag) {
			dfs(r, c, cnt+1);
		}
	}
}
