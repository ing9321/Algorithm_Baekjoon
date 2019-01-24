package recursive;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074 {
	static int N, r, c, M, count;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1074.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		M = (int) Math.pow(2, N);
		count = 0;
		Z(0, 0, M);
	}
	
	public static void Z(int x, int y, int len) {
		if(len == 1) {
//			System.out.println("map[" + x + "][" + y + "] " + count);
			if(x == r && y == c) {
				System.out.println(count);
				System.exit(0);
			}
			count++;
			return;
		}
		
		Z(x, y, len/2);
		Z(x, y + len/2, len/2);
		Z(x + len/2, y, len/2);
		Z(x + len/2, y + len/2, len/2);
	}
}
