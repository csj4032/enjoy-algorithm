package p2456;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var a = new Vote("1");
		var b = new Vote("2");
		var c = new Vote("3");
		var d = "0";
		for (int i = 0; i < n; i++) {
			a.setPoint(sc.nextInt());
			b.setPoint(sc.nextInt());
			c.setPoint(sc.nextInt());
		}
		List<Vote> votes = Arrays.asList(a, b, c);
		votes.sort(Vote::compareTo);
		var e = votes.get(0);
		var f = votes.get(1);
		if (!e.equals(f)) d = e.number;
		System.out.println(d + " " + e.sum);

		Collections.sort(votes, Comparator.comparing(Vote::getSum).thenComparing(Vote::getThree).thenComparing(Vote::getTwo).thenComparing(Vote::getOne));
		Collections.sort(votes);
	}
}

class Vote implements Comparable<Vote> {

	@Override
	public int compareTo(Vote o) {
		int c;
		c = o.sum.compareTo(this.sum);
		if (c == 0) c = o.three.compareTo(this.three);
		if (c == 0) c = o.two.compareTo(this.two);
		if (c == 0) c = o.one.compareTo(this.one);
		return c;
	}

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

	public String getNumber() {
		return number;
	}

	public Integer getOne() {
		return one;
	}

	public Integer getTwo() {
		return two;
	}

	public Integer getThree() {
		return three;
	}

	public Integer getSum() {
		return sum;
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