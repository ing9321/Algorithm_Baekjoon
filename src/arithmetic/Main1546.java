package arithmetic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1546 평균
 * https://www.acmicpc.net/problem/1546
 * 점수/M*100
 * 새로운 평균을 구하는 프로그램
 * 첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 
 * 둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
 * .00까지
 */
public class Main1546 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1546.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		double[] subjects = new double[N];
		double M = 0;
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			subjects[i] = Double.parseDouble(st.nextToken().trim());
			if(M < subjects[i]) M = subjects[i];
		}
		
		int avg = 0;
		for (int i = 0; i < N; i++) {
			subjects[i] = subjects[i] / M * 100;
			avg += subjects[i];
		}
		
		System.out.println(Arrays.toString(subjects));
		System.out.printf("%.2f", avg / (double)N);
	}

}
