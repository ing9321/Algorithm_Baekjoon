package coding;

// 셀프넘버
public class Main4673 {
	static int size;
	static int[] selfnumber;
	public static void main(String[] args) {
		size = 10001;
		selfnumber = new int[size];
		for(int i=1; i<size; i++) {
			d(i);
			if(selfnumber[i] < 1) {
				System.out.println((i));
			}
		}
	}
	public static void d(int n) {
		String str = n + "";
		int temp = n;
		for(int i=0, size=str.length(); i<size; i++) {
			temp += str.charAt(i) - '0';
		}
		if(temp < size) {
			selfnumber[temp]++;			
		}
	}
}
