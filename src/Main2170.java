import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2170 선긋기
 * https://www.acmicpc.net/problem/2170
 * 라인스위핑
 * 
 * ** 주어진 선분의 시작점이 작은 순으로 정렬 후, 겹치는 부분에 대해 연산
 */
public class Main2170 {
	public static int N;
	public static Line2170[] lines;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2170.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		lines = new Line2170[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			lines[i] = new Line2170(Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim()));
		}
		Arrays.sort(lines); // x축 기준으로 정렬
		
		int s = Integer.MIN_VALUE;
		int e = Integer.MIN_VALUE;
		long sum = 0;
		for (int i = 0; i < N; i++) {
			int ns = lines[i].x;
			int ne = lines[i].y;
			
			if(s <= ns && e >= ne) {
				// 이전 선분에 포함된 경우
				continue;
			} else if(s <= ns && e >= ns && e < ne) {
				// 선분이 부분적으로 포함되어 있을 경우
				sum += (ne - e);
				e = ne;
			} else if(e < ns) {
				// 선분이 겹치지 않을 경우
				sum += (ne - ns);
				s = ns;
				e = ne;
			}
		}
		System.out.println(sum);
	}
}
class Line2170 implements Comparable<Line2170> {
	int x;
	int y;
	public Line2170(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Line2170 o) {
		// TODO Auto-generated method stub
		return this.x - o.x;
	}
}