import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Country{
	int num;
	int gold;
	int silver;
	int bronze;
	int rank;
	
	Country(int num, int gold, int silver, int bronze){
		this.num = num;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}

	@Override
	public String toString() {
		return "[num=" + num + ", rank=" + rank
				+ "]";
	}
	
}
// 올림픽
public class Main8979_1 {
	static int N, K;
	static Country[] countries;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input8979.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken().trim());
		K = Integer.parseInt(st.nextToken().trim());
		countries = new Country[N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			int num = Integer.parseInt(st.nextToken().trim());
			int gold = Integer.parseInt(st.nextToken().trim());
			int silver = Integer.parseInt(st.nextToken().trim());
			int bronze = Integer.parseInt(st.nextToken().trim());
			countries[i] = new Country(num, gold, silver, bronze);
		}
		
		// ========================================================

		Arrays.sort(countries, new Comparator<Country>(){
			@Override
			public int compare(Country o1, Country o2) {
				if(o1.gold == o2.gold) {
					if(o1.silver == o2.silver) {
						return o2.bronze - o1.bronze;
					}
					return o2.silver - o1.silver;
				}
				return o2.gold - o1.gold;
			}
		});


		int rank = 1;
		int flag = 0;
		countries[0].rank = rank;
		for(int i=0; i<N-1; i++) {
			Country country1 = countries[i];
			Country country2 = countries[i+1];
			if(country1.gold == country2.gold && country1.silver == country2.silver && country1.bronze == country2.bronze) {
				country2.rank = rank;
				flag++;
			} else {
				rank  = rank + 1 + (1*flag);
				country2.rank = rank;
				flag = 0;
			}
		}

		System.out.println(Arrays.toString(countries));
		
		for(int i=0; i<N; i++) {
			if(countries[i].num == K) {
				System.out.println(countries[i].rank);
				break;
			}
		}

	}
}
