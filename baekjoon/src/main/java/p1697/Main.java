package p1697;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	private static LinkedList<Tuple2> queue = new LinkedList();
	private static boolean[] visitor;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var k = sc.nextInt();
		visitor = new boolean[200_000];
		queue.add(new Tuple2(n, 0));
		while (!queue.isEmpty()) {
			Tuple2 tuple2 = queue.poll();
			var v = tuple2.value;
			var t = tuple2.time + 1;
			if (v < 0 || v > 100_000) continue;
			if (visitor[v]) continue;
			visitor[v] = true;
			if (tuple2.value.equals(k)) {
				System.out.println(tuple2.time);
				break;
			}
			queue.add(new Tuple2(v - 1, t));
			queue.add(new Tuple2(v + 1, t));
			queue.add(new Tuple2(v * 2, t));
		}
	}
}

class Tuple2 implements Comparable<Tuple2> {

	Integer value;
	Integer time;

	public Tuple2(Integer value, Integer time) {
		this.value = value;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Tuple2{" + "value=" + value + ", time=" + time + '}';
	}

	@Override
	public int compareTo(Tuple2 o) {
		return this.time.compareTo(o.time);
	}
}
// 100000 1
// 1 100000