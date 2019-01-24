package recursive;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암호만들기
public class Main1759 {
	static int L, C, collection, consonant;
	static char[] result, data;
	static char[] collections = {'a', 'e', 'i', 'o', 'u'};
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input1759.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		StringTokenizer st = new StringTokenizer(str);
		L = Integer.parseInt(st.nextToken().trim()); // 암호 자릿수
		C = Integer.parseInt(st.nextToken().trim()); // 가능성 알파벳 수
		data = new char[C];
		result = new char[L];
		str = br.readLine().trim();
		st = new StringTokenizer(str);
		for(int i=0; i<C; i++){
			data[i] = st.nextToken().trim().charAt(0);
		}
		br.close();
		
		System.out.println(Arrays.toString(data));
		Arrays.sort(data);
		System.out.println(Arrays.toString(data));
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		combination(0, 0);
		bw.flush();
		bw.close();
	}
	// 최소 1개의 모음, 최소 2개의 자음
	public static void combination(int cnt, int idx) throws IOException {
		if(cnt == L) {
			for(int i=0; i<L; i++) {
				if(Arrays.binarySearch(collections, result[i]) >= 0) {
					collection++;
				} else {
					consonant++;
				}
			}
			if(collection > 0 && consonant > 1) {
				for(int i=0; i<L; i++) {
					bw.write(result[i]);
				}
				bw.write('\n');
			}
			collection = 0;
			consonant = 0;
			return;
		}
		for(int i=idx; i<C; i++) {
			result[cnt] = data[i];
			combination(cnt+1, i+1);
		}
	}
}
