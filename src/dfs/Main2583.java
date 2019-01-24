package dfs;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2583 {
	static int[][] map;
	static int M, N, K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input2583.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().trim().split(" ");
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		map = new int[M][N];
		
		K = Integer.parseInt(str[2]);
		for(int i=0; i<K; i++) {
			String[] str2 = br.readLine().trim().split(" ");
			color(Integer.parseInt(str2[0]), Integer.parseInt(str2[1]), Integer.parseInt(str2[2]), Integer.parseInt(str2[3]));
		}
		System.out.println(Arrays.toString(map[0]));
		System.out.println(Arrays.toString(map[1]));
		System.out.println(Arrays.toString(map[2]));
		System.out.println(Arrays.toString(map[3]));
		System.out.println(Arrays.toString(map[4]));
	}
	public static void color(int x1, int y1, int x2, int y2) {
		for(int i=x1; i<x2; i++) {
			for(int j=y1; j<y2; j++) {
				map[j][i] = 1;
			}
		}
	}
}
