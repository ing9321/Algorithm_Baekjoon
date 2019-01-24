package recursive;
import java.math.BigInteger;
import java.util.Scanner;

// 하노이탑
public class Main1914 {
	static int N;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();

		//   count = 2^N-1;
		BigInteger big = BigInteger.valueOf(2);
		big = big.pow(N);
		big = big.subtract(BigInteger.ONE);
		System.out.println(big);
		if(N <= 20){
			hanoi(N, 1, 3, 2);	
		}
		
	}
	public static void hanoi(int n, int current, int target, int middle) {
		if(n == 1) {
			System.out.println(current + " " + target);
			return;
		}
		hanoi(n-1, current, middle, target);
		System.out.println(current + " " + target);
		hanoi(n-1, middle, target, current);
	}
}
