package monthly.march;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 스위치와 랩프
public class Main16960 {
	private static class Bulb {
		int number;
		int btnlen;
		ArrayList<Integer> buttons;
		Bulb(int number, int btnlen) {
			this.number = number;
			this.btnlen = btnlen;
			buttons = new ArrayList<Integer>();
		}
		private void addBtn(int btn) {
			buttons.add(btn);
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16960.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strarr = br.readLine().split(" ");
		int N = Integer.parseInt(strarr[0]);
		int M = Integer.parseInt(strarr[1]);
		Bulb[] bulbs = new Bulb[N];
		int[] switcher = new int[M+1];
		for (int i = 0; i < N; i++) {
			strarr = br.readLine().split(" ");
			bulbs[i] = new Bulb(i, Integer.parseInt(strarr[0]));
			for (int j = 0; j < bulbs[i].btnlen; j++) {
				bulbs[i].addBtn(Integer.parseInt(strarr[j+1]));
			}
		}
	}

}
