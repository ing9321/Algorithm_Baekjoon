package coding;

// 완전 세제곱
public class Main4690 {
	public static void main(String[] args) {
		for(int i=6; i<=100; i++) {
			for(int j=2; j<i; j++) {
				for(int k=j+1; k<i; k++) {
					for(int l=k+1; l<i; l++) {
						if(triple(i) == triple(j)+triple(k)+triple(l)) {
							System.out.printf("Cube = %d, Triple = (%d,%d,%d)\n", i, j, k, l);
						}
					}
				}
			}
		}
	}
	public static int triple(int n) {
		return n*n*n;
	}
}
