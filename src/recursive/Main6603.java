package recursive;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {
	static int k;
	static int[] S;
	static boolean[] selected;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6603.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine().trim();
			if(str.equals("0")) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(str);
			k = Integer.parseInt(st.nextToken().trim());
			S = new int[k];
			selected = new boolean[k];
			for(int i=0; i<k; i++) {
				S[i] = Integer.parseInt(st.nextToken().trim());
			}

			lotto(0, 0);
			System.out.println();
		}
		
	}
	
	public static void lotto(int cnt, int start) {
		if(cnt == 6) {
			for(int i=0; i<k; i++) {
				if(selected[i]) {
					System.out.print(S[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		for(int i=start; i<k; i++) {
			selected[i] = true;
			lotto(cnt+1, i+1);
			selected[i] = false;
		}
	}
}
