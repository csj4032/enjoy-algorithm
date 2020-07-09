package p10812;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var l = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) l.add(i);
		for (int i = 0; i < m; i++) {
			var begin = sc.nextInt();
			var end = sc.nextInt();
			var mid = sc.nextInt();
			var t = new ArrayList(l.subList(mid - 1, end));
			for (int j = 0; j < t.size(); j++) l.remove(t.get(j));
			l.addAll(begin - 1, t);
		}
		System.out.println(l.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}