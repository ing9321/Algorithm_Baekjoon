package recursive;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 안녕
public class Main1535 {
	static int N;
	static int[] HP, MP;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input1535.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()); // 인사할 사람 수
		HP = new int[N];
		MP = new int[N];
		String str1 = br.readLine().trim();
		String str2 = br.readLine().trim();
		StringTokenizer st1 = new StringTokenizer(str1);
		StringTokenizer st2 = new StringTokenizer(str2);
		for(int i=0; i<N; i++) {
			HP[i] = Integer.parseInt(st1.nextToken().trim());
			MP[i] = Integer.parseInt(st2.nextToken().trim());
		}
		
		System.out.println(Arrays.toString(HP));
		System.out.println(Arrays.toString(MP));
		
		int maxIdx = 0;
		int maxMP = 0;
		for(int i=1, size = 1<<N; i<size; i++) {
			int hp = 0;
			int mp = 0;
			System.out.print("[");
			for(int j=0; j<N; j++) {
				if((i & 1<<j) != 0) {
					System.out.print(HP[j] + "/" + MP[j] + " ");
					hp += HP[j];
					mp += MP[j];
				}
			}
			System.out.println("]");
			if(hp < 100 && mp > maxMP) {
				maxMP = mp;
				System.out.println("****************" + maxMP + "S");
			}
			hp = 0;
			mp = 0;
		}
		System.out.println(maxMP);
	}
}
