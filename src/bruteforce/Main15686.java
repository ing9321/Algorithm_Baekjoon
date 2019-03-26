package bruteforce;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 15686 치킨 배달
 * https://www.acmicpc.net/problem/15686
 * Brute Force, Combination
 */
public class Main15686 {
	static int N, M, C;
	static int[][] map;
	static ArrayList<House> houses, chickens;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input15686.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		houses = new ArrayList<House>();
		chickens = new ArrayList<House>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					houses.add(new House(i, j));
				} else if(map[i][j] == 2) {
					chickens.add(new House(i, j));
				}
			}
		}
		
		for (int i = 0, hsize = houses.size(); i < hsize; i++) {
			House house = houses.get(i);
			for (int j = 0, csize = chickens.size(); j < csize; j++) {
				House chicken = chickens.get(j);
				int d = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
				house.distance.add(d);
			}
		}
		
		C = Integer.MAX_VALUE;
		arr = new int[M];
		select(0, 0);
		System.out.println(C);
	}

	private static void select(int n, int cnt) {
		if(cnt == M) {
			int city = 0;
			for (int i = 0; i < houses.size(); i++) {
				city += houses.get(i).getMinD(arr);
				if(city > C) break;
			}
			C = Math.min(C, city);
			return;
		}
		for (int i = n; i < chickens.size(); i++) {
			arr[cnt] = i;
			select(i+1, cnt+1);
		}
	}
	
	private static class House {
		int x, y;
		ArrayList<Integer> distance;
		public House(int x, int y) {
			this.x = x;
			this.y = y;
			distance = new ArrayList<Integer>();
		}
		public int getMinD(int[] arr) {
			int min = distance.get(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				min = Math.min(min, distance.get(arr[i]));
			}
			return min;
		}
	}
}
