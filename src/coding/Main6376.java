package coding;

// e 계산
public class Main6376 {
	public static void main(String[] args) {
		System.out.println("n e\n- -----------");
		double e = 0.0;
		for(int i=0; i<10; i++) {
			e += 1/calce(i);
			if(i < 2) {
				System.out.printf("%d %.0f\n", i, e);
			} else if(i ==2){
				System.out.printf("%d %.1f\n", i, e);
			} else {
				System.out.printf("%d %.9f\n", i, e);
			}
		}
	}

	public static double calce(int n) {
		if(n < 1) {
			return 1;
		}
		return n * calce(n-1);
	}
}