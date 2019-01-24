import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 적록색약
public class Main10026 {
	static String[][] map;
	static int M, N;
	static int pos[][] = {{1,0}, {0,1}};
	static String S = "";
	static int O;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new String[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) + "";
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<pos.length; k++) {
					int ni = i+pos[k][0];
					int nj = j+pos[k][1];
					
					if(ni >= 0 && nj >= 0 && ni < N && nj < N) {
						System.out.println(i + " " + j + " " + map[i][j] + " " + map[ni][nj]);
						if(map[i][j].equals(map[ni][nj])) {
							System.out.println("same");
							if(!S.equals(map[i][j])) {
								System.out.println("new 구역");
								S = map[i][j];
								O++;
							}
						}
					}
				}
			}
		}
		System.out.println(O);
	}
	
}
