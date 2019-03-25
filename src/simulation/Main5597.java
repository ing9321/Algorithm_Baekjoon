package simulation;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 5597 과제 안 내신 분..?
 * https://www.acmicpc.net/problem/5597
 * 구현
 */
public class Main5597 {
	static int[] students;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5597.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		students = new int[31];
		for(int i=0; i<28; i++) {
			int s = Integer.parseInt(br.readLine().trim());
			students[s] = 1;
		}
		for(int i=1; i<31; i++) {
			if(students[i] == 0) {
				System.out.println(i);
			}
		}
	}
}
