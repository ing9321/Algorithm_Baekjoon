package monthly;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

// 최소비용 구하기
public class Main1916 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1916.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim()); // 도시
		int M = Integer.parseInt(br.readLine().trim()); // 버스
		int[][] matrix = new int[N+1][N+1]; // 인접행렬
		int min = 100000000;
		for(int i=0; i<=N; i++) {
			Arrays.fill(matrix[i], min);
		}

		int[] distance = new int[N+1];
		boolean[] visit = new boolean[N+1];
		for(int i=0; i<M; i++) {
			String[] strarr = br.readLine().split(" ");
			int s = Integer.parseInt(strarr[0]);
			int d = Integer.parseInt(strarr[1]);
			int p = Integer.parseInt(strarr[2]);
			if(matrix[s][d] > p) {
				matrix[s][d] = p;
			}
		}
		String[] strarr = br.readLine().split(" ");
		int A = Integer.parseInt(strarr[0]); // 출발 도시
		int B = Integer.parseInt(strarr[1]); // 도착 도시

		visit[A] = true;
		distance = matrix[A];
		int nextNode = A;
		for(int i=0; i<N-1; i++) {
			min = 100000000;
			for(int j=1; j<=N; j++) {
				if(min > distance[j] && !visit[j]) {
					min = distance[j];
					nextNode = j;
				}
			}
			visit[nextNode] = true;
			for(int j=1; j<=N; j++) {
				if(!visit[j]) {
					if(min + matrix[nextNode][j] < distance[j]) {
						distance[j] = min + matrix[nextNode][j];
					}
				}
			}
		}
		
		System.out.println(distance[B]);	
	}
}
