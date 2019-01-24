package recursive;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main10872 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		
		int A = fac(N);
		System.out.println(A);
	}
	public static int fac(int n) {
		if(n == 1) {
			return 1;
		} else {
			return n * fac(n-1);
		}
	}
}
