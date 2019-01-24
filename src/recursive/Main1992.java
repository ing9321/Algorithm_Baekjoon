package recursive;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 쿼드트리
public class Main1992 {
	static int[][] map;
	static int M, N;
	static int[][] pos = {{0,0}, {0,1}, {1,0}, {1,1}};
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		System.setIn(new FileInputStream("res/input1992.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine().trim();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		quadTree(0, 0, N);
		
		long end = System.currentTimeMillis();
		System.out.printf("\n걸린시간 %dms\n", end-start);
	}
	public static void quadTree(int x, int y, int len) {
		boolean isQuad = false;
		int origin = map[x][y];
		for(int i=x; i<x+len; i++) {
			for(int j=y; j<y+len; j++) {
				if(origin != map[i][j]) {
					isQuad = true;
				}
			}
		}
		if(!isQuad) {
			System.out.print(origin);
		} else {
			int nl = len/2;
			System.out.print("(");
			for(int i=0, size = pos.length; i<size; i++) {
				int nx = x + (pos[i][0]*nl);
				int ny = y + (pos[i][1]*nl);
				quadTree(nx, ny, nl);
			}
//			quadTree(x, y, nl);
//			quadTree(x, y+nl, nl);
//			quadTree(x+nl, y, nl);
//			quadTree(x+nl, y+nl, nl);
			System.out.print(")");
		}
	}
}
