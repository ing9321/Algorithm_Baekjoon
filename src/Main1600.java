import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1600 말이 되고픈 원숭이
 */
public class Main1600 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1600.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < H; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		// bfs로 풀어야 시간초과 안남~!
		// visit
	}
}
