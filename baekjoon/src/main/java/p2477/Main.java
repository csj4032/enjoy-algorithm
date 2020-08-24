package p2477;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	private static LinkedList<Tuple> direct = new LinkedList<>();
	private static String A = "4,2,3,1,3,1";
	private static String B = "4,2,3,1,4,1";
	private static String C = "4,2,4,2,3,1";
	private static String D = "4,2,3,2,3,1";

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var k = sc.nextInt();
		for (int i = 0; i < 6; i++) {
			var a = sc.nextInt();
			var b = sc.nextInt();
			direct.add(new Tuple(a, b));
		}
		for (int i = 0; i < 6; i++) {
			var d = direct.stream().map(e -> e.d.toString()).collect(Collectors.joining(","));
			if (A.equals(d)) {
				calculate("A", k);
				break;
			} else if (B.equals(d)) {
				calculate("B", k);
				break;
			} else if (C.equals(d)) {
				calculate("C", k);
				break;
			} else if (D.equals(d)) {
				calculate("D", k);
				break;
			}
			Tuple t = direct.poll();
			direct.add(t);
		}
	}

	private static void calculate(String t, int k) {
		var h = 0;
		var w = 0;
		var hh = 0;
		var ww = 0;
		if (t.equals("A")) {
			h = direct.get(0).v;
			w = direct.get(1).v;
			hh = direct.get(4).v;
			ww = direct.get(3).v;
			System.out.println(((h * w) - (hh * ww)) * k);
		} else if (t.equals("B")) {
			h = direct.get(2).v;
			w = direct.get(1).v;
			hh = direct.get(4).v;
			ww = direct.get(5).v;
			System.out.println(((h * w) - (hh * ww)) * k);
		} else if (t.equals("C")) {
			h = direct.get(4).v;
			w = direct.get(5).v;
			hh = direct.get(1).v;
			ww = direct.get(2).v;
			System.out.println(((h * w) - (hh * ww)) * k);
		} else {
			h = direct.get(0).v;
			w = direct.get(5).v;
			hh = direct.get(2).v;
			ww = direct.get(3).v;
			System.out.println(((h * w) - (hh * ww)) * k);
		}
	}
}

class Tuple {
	Integer d;
	Integer v;

	public Tuple(Integer d, Integer v) {
		this.d = d;
		this.v = v;
	}

	@Override
	public String toString() {
		return "Tuple{" + "d=" + d + ", v=" + v + '}';
	}
}