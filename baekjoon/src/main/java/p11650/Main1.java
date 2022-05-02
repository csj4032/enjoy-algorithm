package p11650;

import java.util.*;
import java.util.stream.Collectors;

public class Main1 {

	static List<Point> points = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Point point = new Point(x, y);
			points.add(point);
		}
		Collections.sort(points);
		for (int i = 0 ; i < n; i++) {
			System.out.println(points.get(i).getX() +" " + points.get(i).getY());
		}
	}
}

class Point implements Comparable<Point> {
	private Integer x;
	private Integer y;

	public Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	@Override
	public int compareTo(Point o) {
		int a = this.getX().compareTo(o.getX());
		if (a == 0) return this.getY().compareTo(o.getY());
		return a;
	}
}