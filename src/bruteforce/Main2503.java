package bruteforce;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * 2503 숫자 야구
 * https://www.acmicpc.net/problem/2503
 * Brute Force
 */
public class Main2503 {
	static int N;
	static ArrayList<int[]> numbers;
	public static void main(String[] args) throws Exception {
		numbers = new ArrayList<int[]>();
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				for(int k=1; k<10; k++) {
					if(i != j && j!= k && i != k) {
						int[] num = {i, j, k};
						numbers.add(num);
					}
				}
			}
		}
		
		System.setIn(new FileInputStream("res/input2503.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		for(int i=0; i<N; i++) {
			String str = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(str);
			String n = st.nextToken().trim();
			int strike = Integer.parseInt(st.nextToken().trim());
			int ball = Integer.parseInt(st.nextToken().trim());
			
			Iterator<int[]> it = numbers.iterator();
			while(it.hasNext()) {
				int[] number = it.next();
				int s=0;
				int b=0;
				for(int x=0; x<3; x++) {
					for(int y=0; y<3; y++) {
						if(n.charAt(x) - '0' == number[y]) {
							if(x == y) {
								s++;
							} else {
								b++;
							}
						}
					}
				}
				if(strike != s || ball != b) {
					it.remove();
				}
			}
		}
		System.out.println(numbers.size());
	}
}
