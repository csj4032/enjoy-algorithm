package p2457;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var l = new ArrayList<Between>();
		var s = LocalDate.of(2020, 3, 1);
		var e = LocalDate.of(2020, 11, 30);
		var m = new int[365];
		for (int i = 0; i < n; i++) {
			l.add(new Between(LocalDate.of(2020, sc.nextInt(), sc.nextInt()), LocalDate.of(2020, sc.nextInt(), sc.nextInt())));
		}
		Collections.sort(l);
		//System.out.println(l);

		var ss = 366;
		var ee = 0;
		for (int i = 1; i <= n; i++) {
			Between between = l.get(i - 1);
			var f = between.from;
			var t = between.to;
			//System.out.println(ss + " " + ee);
			if (ss <= f.getDayOfYear() && ee >= t.getDayOfYear()) {
				continue;
			}
			ss = Math.min(ss, f.getDayOfYear());
			ee = Math.max(ee, t.getDayOfYear());
			for (int j = ss; j < ee; j++) {
				m[j - 1] = i;
			}

		}
		var p = 0;
		var q = 0;
		//System.out.println(Arrays.toString(m));
		for (int i = s.getDayOfYear(); i < e.getDayOfYear(); i++) {
			if (m[i - 1] == 0) {
				p = 0;
				break;
			}
			if (m[i - 1] != q) {
				p++;
				q = m[i - 1];
			}
			//System.out.print(m[i - 1]);
		}
		//System.out.println();
		System.out.println(p);
	}
}

class Between implements Comparable<Between> {
	@Override
	public String toString() {
		return "Between{" +
				"from=" + from +
				", to=" + to +
				", gap=" + gap +
				'}';
	}

	LocalDate from;
	LocalDate to;
	Integer gap;

	public Between(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
		this.gap = to.getDayOfYear() - from.getDayOfYear();
	}

	@Override
	public int compareTo(Between o) {
		int c = o.gap.compareTo(this.gap);
		if (c == 0) c = this.from.compareTo(o.from);
		return c;
	}
}


//2
//2 28 3 2
//3 1 11 30

//1
//2 28 11 29


//2
//2 28 11 1
//11 3 11 30

//2
//2 28 11 1
//11 2 11 30

//2
//2 28 11 1
//11 1 11 30


//1
//3 1 11 30

//1
//3 2 11 30

//1
//3 1 11 29

//1
//3 1 11 28

//3
//1 1 11 30
//11 10 12 5
//3 1 12 1
