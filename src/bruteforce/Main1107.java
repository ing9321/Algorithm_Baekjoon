package bruteforce;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 미해결
 * 1107 리모컨
 * https://www.acmicpc.net/problem/1107
 * Brute Force
 */
public class Main1107 {
	static String channel;
	static int M, N;
	static int[] broken;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input1107.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1; test_case<=T; test_case++) {
//			N = Integer.parseInt(br.readLine().trim()); // 원하는 채널
			channel = br.readLine().trim();
			M = Integer.parseInt(br.readLine().trim()); // 고장난 갯수
			broken = new int[M];
			
			String str = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(str);
			for(int i=0; i<M; i++) {
				broken[i] = Integer.parseInt(st.nextToken().trim());				
			}
			
			
			
			System.out.println(Arrays.toString(broken));
		}
	}
}
