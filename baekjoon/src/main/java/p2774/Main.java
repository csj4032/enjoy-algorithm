package p2774;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			var s = new HashSet<String>();
			var x = sc.next();
			for (int j = 0; j < x.length(); j++) {
				s.add(String.valueOf(x.charAt(j)));
			}
			sb.append(s.size() + "\n");
		}
		System.out.println(sb.toString());
	}
}