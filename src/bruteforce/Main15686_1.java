package bruteforce;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 15686 치킨 배달
 * 완탐말고 시도.. 해봤으나 맞지않는 TC 존재
 */
public class Main15686_1 {
	static int N, M, map[][];
	static ArrayList<House> house = new ArrayList<>();
	static ArrayList<Store> store = new ArrayList<>();
	static ArrayList<Store> remain = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input15686.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]); // map 크기
		M = Integer.parseInt(input[1]); // 고를 수 있는 최대 치킨집

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 1) {
					house.add(new House(i, j));
				} else if (map[i][j] == 2) {
					store.add(new Store(i, j));
				}
			}
		}

		int r1, c1, r2, c2;
		for (int i = 0, hc = house.size(); i < hc; i++) {
			r1 = house.get(i).row;
			c1 = house.get(i).col;
			for (int j = 0, sc = store.size(); j < sc; j++) {
				r2 = store.get(j).row;
				c2 = store.get(j).col;

				store.get(j).sum += Math.abs(r1 - r2) + Math.abs(c1 - c2);
			}
		}

		Collections.sort(store);

		for (int i = 0; i < M; i++) {
			remain.add(store.get(i));
		}

		int min, answer = 0;
		for (int i = 0, hc = house.size(); i < hc; i++) {
			r1 = house.get(i).row;
			c1 = house.get(i).col;
			min = Integer.MAX_VALUE;
			for (int j = 0, rc = remain.size(); j < rc; j++) {
				r2 = store.get(j).row;
				c2 = store.get(j).col;

				min = Math.min(min, Math.abs(r1 - r2) + Math.abs(c1 - c2));
			}
			answer += min;
		}
		
		System.out.println(answer);
	}
}

class House {
	int row, col;

	public House(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

class Store implements Comparable<Store> {
	int row, col, sum;

	public Store(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public int compareTo(Store o) {
		return this.sum - o.sum;
	}
}