package recursive;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1의 세 값 중 하나가 저장되어 있다.
(1)이 아닌 경우에는 종이를 같은 크기의 9개의 종이로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
첫째 줄에 N(1≤N≤3^7, N은 3^k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
-1	0	1
 *
 */
public class Main1780 {
	static int[][] map;
	static int M, N, a, b, c;
	static int[][] pos = {{0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1780.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(str);
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		
		papercut(0, 0, N);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
	public static void papercut(int x, int y, int len) {
		boolean isNotEqual = false;
		int origin = map[x][y];
		for(int i=x; i<x+len; i++) {
			for(int j=y; j<y+len; j++) {
				if(origin != map[i][j]) {
					isNotEqual = true;
				}
			}
		}
		if(!isNotEqual) {
			switch(origin) {
			case -1:
				a++;
				break;
			case 0:
				b++;
				break;
			case 1:
				c++;
				break;
			}
		} else {
			int nl = len/3;
			for(int i=0, size=pos.length; i<size; i++) {
				int nx = x + (nl * pos[i][0]);
				int ny = y + (nl * pos[i][1]);
				papercut(nx, ny, nl);
			}
		}
	}
}
