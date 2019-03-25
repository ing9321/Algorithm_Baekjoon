package simulation;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 5543 상근날드
 * https://www.acmicpc.net/problem/5543
 * 구현
 */
public class Main5543 {
	static int[] Burger, Drink;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5543.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Burger = new int[3];
		Drink = new int[2];
		
		int minB = 2000;
		int minD = 2000;
		for(int i=0; i<3; i++) {
			Burger[i] = Integer.parseInt(br.readLine().trim());
			minB = Math.min(minB, Burger[i]);
		}
		for(int i=0; i<2; i++) {
			Drink[i] = Integer.parseInt(br.readLine().trim());
			minD = Math.min(minD, Drink[i]);
		}
		
		System.out.println(minB + minD - 50);
	}
}
