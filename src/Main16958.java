import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 안푼문제
 * 16958 텔레포트
 * https://www.acmicpc.net/problem/16958
 */
public class Main16958 {
	static int N, T;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16958.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
	}

}
