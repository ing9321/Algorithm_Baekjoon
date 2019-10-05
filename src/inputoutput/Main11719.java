package inputoutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 11719 그대로 출력하기2
 * https://www.acmicpc.net/problem/11719
 */

public class Main11719 {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("res/input11719.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = "";
		while(true) {
			try {
				System.out.println(br.readLine());
			} catch(Exception e) {
				System.out.println(e.getMessage());
				return;
			}
		}
	}

}
