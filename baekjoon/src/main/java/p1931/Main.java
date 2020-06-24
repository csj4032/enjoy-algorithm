package p1931;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var stack = new Stack<Tuple>();
		for (int i = 0; i < n; i++) {
			var tuple = new Tuple(sc.nextLong(), sc.nextLong());
			stack.add(tuple);
		}
		Collections.sort(stack);
		var m = 0;
		var t1 = new Tuple(-1L, -1L);
		while (!stack.empty()) {
			var t2 = stack.pop();
			if (t1.e <= t2.s) {
				m++;
				t1 = t2;
			}
		}
		System.out.println(m);
	}
}

class Tuple implements Comparable {
	Long s;
	Long e;

	public Tuple(Long s, Long e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Object o) {
		Tuple t1 = (Tuple) o;
		return (t1.e.compareTo(this.e) == 0) ? t1.s.compareTo(this.s) : t1.e.compareTo(this.e);
	}

	@Override
	public String toString() {
		return "Tuple{" +
				"s=" + s +
				", e=" + e +
				'}';
	}
}

//
// 3/2

// 4 6 2 4
// 6 4 2 4

// 6 9 3 6

// 0 5 1 2