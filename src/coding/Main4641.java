package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// Double
public class Main4641 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4641.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] strarr = br.readLine().split(" ");
			if(strarr[0].equals("-1")) {
				break;
			}
			int size = strarr.length-1;
			int cnt = 0;
			int[] intarr = new int[size];
			for(int i=0; i<size; i++) {
				intarr[i] = Integer.parseInt(strarr[i]);
			}
			for(int i=0; i<size; i++) {
				int a = intarr[i] * 2;
				for(int j=0; j<size; j++) {
					if(intarr[j] == a) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
