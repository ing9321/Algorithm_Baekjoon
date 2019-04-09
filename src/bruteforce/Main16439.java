package bruteforce;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 16439 치킨치킨치킨
 * https://www.acmicpc.net/problem/16439
 * 조합 combination
 */
public class Main16439 {
	static int N, M, MAX;
	static int[] arr;
	static int[][] member;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16439.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		member = new int[N][M];
		arr = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				member[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0);
		System.out.println(MAX);
	}
	private static void combination(int idx, int cnt) {
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += Math.max(Math.max(member[i][arr[0]], member[i][arr[1]]), member[i][arr[2]]);
			}
			MAX = Math.max(MAX, sum);
			return;
		}
		for (int i = idx; i < M; i++) {
			arr[cnt] = i;
			combination(i + 1, cnt + 1);
		}
	}
}
