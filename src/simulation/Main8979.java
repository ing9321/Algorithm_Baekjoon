package simulation;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 8979 올림픽
 * https://www.acmicpc.net/problem/8979
 * 구현
 */
public class Main8979 {
	static int N, K, C;
	static int[][] score;
	static int[] rank;
	static int ridx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input8979.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken().trim());
		K = Integer.parseInt(st.nextToken().trim());
		score = new int[N][4];
		rank = new int[N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			for(int j=0; j<4; j++) {
				score[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		
		Arrays.sort(score, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				int i = 1;
				if(o1[i] == o2[i]) {
					i++;
					if(o1[i] == o2[i]) {
						i++;
					}
				}
				return o2[i] - o1[i];
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(score[i]));
		}
		
		System.out.println();
		
		compare(0, 1, 1);
		
		for(int i=0; i<N; i++) {
			if(score[i][0] == K) {
				System.out.println(rank[i]);
				break;
			}
		}

	}
	
	public static void compare(int i, int j, int idx){
		System.out.println(Arrays.toString(rank));
		System.out.println(i + " " + j + " " + idx + "메달 비교");
		if(j >= N) {
//			rank[ridx] = ++C;
			System.out.println("검사중지");
			return;
		}
		if(idx == 4){
			rank[ridx] = ++C;
			ridx += 1;
			rank[ridx] = C;
			ridx += 1;
			C++;
			compare(i+2, j+2, 1);
		}

		if(score[i][idx] == score[j][idx]){
			compare(i, j, ++idx);
		} else {
			rank[ridx] = ++C;
			ridx += 1;
		}
		compare(++i, ++j, 1);

	}
}
