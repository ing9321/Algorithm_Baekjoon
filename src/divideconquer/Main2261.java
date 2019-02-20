package divideconquer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 가장 가까운 두 점
public class Main2261 {
	static TreeSet<Point> points;
	static int MIN;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2261.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		points = new TreeSet<Point>();
		MIN = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x,y));
		}

		System.out.println(points);
	}

	static class Point implements Comparable<Point> {
		int x;
		int y;
//		Point minP;
//		int min = Integer.MAX_VALUE;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Point [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
//			builder.append(", min=");
//			builder.append(min);
			builder.append("]");
			return builder.toString();
		}

		@Override
		public int compareTo(Point o) {
//			System.out.println(this);
//			System.out.println(o);
//			System.out.println("=============");
//			int xx = (o.x - this.x);
//			int yy = (o.y - this.y);
//			int len = (xx * xx) + (yy * yy);
//			if(len < this.min) {
//				this.minP = o;
//				this.min = len;
//			}

			return this.x - o.x > 0 ? 1 : -1;
		}
	}
}
