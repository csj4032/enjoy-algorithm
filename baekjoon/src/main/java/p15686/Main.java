package p15686;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int m;
	static int n;
	static int p;
	static boolean[] v;
	static int[] l;
	static List<Tuple> c = new ArrayList<>();
	static List<Tuple> h = new ArrayList<>();

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		p = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				var t = sc.nextInt();
				if (t == 2) {
					c.add(new Tuple(j + 1, i + 1, 0));
				} else if (t == 1) {
					h.add(new Tuple(j + 1, i + 1, Integer.MAX_VALUE));
				}
			}
		}
		v = new boolean[c.size()];
		l = new int[m];
		recursive(0, 0);
		System.out.println(p);
	}

	private static void recursive(int s, int d) {
		if (d == m) {
			p = Math.min(p, getDistance());
			return;
		}

		for (int i = s; i < c.size(); i++) {
			if (!v[i]) {
				v[i] = true;
				l[d] = i;
				recursive(i, d + 1);
			}
			v[i] = false;
		}
	}

	private static int getDistance() {
		var a = 0;
		for (int i = 0; i < h.size(); i++) h.get(i).setDistance(Integer.MAX_VALUE);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < h.size(); j++) {
				h.get(j).setDistance(c.get(l[i]));
			}
		}
		for (int i = 0; i < h.size(); i++) a += h.get(i).getDistance();
		return a;
	}
}


class Tuple {

	int x;
	int y;
	int distance;

	public Tuple(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	public void setDistance(Tuple o) {
		distance = Math.min(distance, Math.abs(this.x - o.x) + Math.abs(this.y - o.y));
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return "Tuple{" + "x=" + x + ", y=" + y + ", distance=" + distance + '}';
	}
}