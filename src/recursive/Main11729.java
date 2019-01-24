package recursive;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 하노이탑I
public class Main11729 {
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		br.close();
		
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = (int)Math.pow(2, N) - 1;
		bw.write(count + "\n");
		hanoi(N, 1, 3, 2);
		bw.flush();
		bw.close();
	}
	public static void hanoi(int n, int current, int target, int middle) throws IOException {
		if(n == 1) {
			bw.write(current + " " + target + "\n");
			return;
		}
		hanoi(n-1, current, middle, target);
		bw.write(current + " " + target + "\n");
		hanoi(n-1, middle, target, current);
	}
}