package p2456;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var a = new Vote("1");
		var b = new Vote("2");
		var c = new Vote("3");
		var d = "";
		for (int i = 0; i < n; i++) {
			a.setPoint(sc.nextInt());
			b.setPoint(sc.nextInt());
			c.setPoint(sc.nextInt());
		}

		List<Vote> votes = Arrays.asList(a, b, c);
		votes.sort(Vote::compareTo);

		var e = votes.get(0);
		var f = votes.get(1);

		if (!e.equals(f)) {
			d = e.number;
		} else {
			d = "0";
		}

		System.out.println(d + " " + e.sum);
	}
}

class Vote implements Comparable<Vote> {
	String number;
	Integer one = 0;
	Integer two = 0;
	Integer three = 0;
	Integer sum = 0;

	public Vote(String number) {
		this.number = number;
	}

	void setPoint(int point) {
		sum += point;
		if (point == 3) {
			three++;
		} else if (point == 2) {
			two++;
		} else {
			one++;
		}
	}

	@Override
	public int compareTo(Vote o) {
		int e;
		int a = o.sum.compareTo(this.sum);
		if (a == 0) {
			int b = o.three.compareTo(this.three);
			if (b == 0) {
				int c = o.two.compareTo(this.two);
				if (c == 0) {
					return o.one.compareTo(this.one);
				} else {
					e = c;
				}
			} else {
				e = b;
			}
		} else {
			e = a;
		}
		return e;
	}

	@Override
	public String toString() {
		return "Vote{" +
				"number='" + number + '\'' +
				", one=" + one +
				", two=" + two +
				", three=" + three +
				", sum=" + sum +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vote vote = (Vote) o;
		return Objects.equals(one, vote.one) &&
				Objects.equals(two, vote.two) &&
				Objects.equals(three, vote.three) &&
				Objects.equals(sum, vote.sum);
	}

	@Override
	public int hashCode() {
		return Objects.hash(one, two, three, sum);
	}
}