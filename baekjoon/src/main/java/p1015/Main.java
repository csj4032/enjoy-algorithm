package p1015;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		List<Tuple2> p = new ArrayList();
		var a = new int[n];
		var b = new int[n];
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			a[i] = k;
			p.add(new Tuple2(i, k));
		}

		Collections.sort(p, (o1, o2) -> {
			if (o1.t2 < o2.t2) {
				return -1;
			} else if (o1.t2 > o2.t2) {
				return 1;
			} else {
				if (o1.t1 < o2.t1) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		for (int i = 0; i < n; i++) {
			b[p.get(i).t1] = i;
		}

		var sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(b[i]);
			sb.append(" ");
		}

		System.out.println(sb.toString().trim());
	}

	public static class Tuple2 {
		Integer t1;
		Integer t2;

		Tuple2(Integer t1, Integer t2) {
			this.t1 = t1;
			this.t2 = t2;
		}

		@Override
		public String toString() {
			return "Tuple2{" +
					"t1=" + t1 +
					", t2=" + t2 +
					'}';
		}
	}
}