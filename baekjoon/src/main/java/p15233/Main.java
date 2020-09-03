package p15233;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a = sc.nextInt();
		var b = sc.nextInt();
		var g = sc.nextInt();
		var aaa = 0;
		var bbb = 0;

		List<String> aa = new ArrayList<>();
		List<String> bb = new ArrayList<>();

		for (int i = 0; i < a; i++) aa.add(sc.next());
		for (int i = 0; i < b; i++) bb.add(sc.next());

		for (int i = 0; i < g; i++) {
			var gg = sc.next();
			if (aa.contains(gg)) aaa++;
			if (bb.contains(gg)) bbb++;
		}

		if (aaa > bbb) {
			System.out.println("A");
		} else if (aaa < bbb) {
			System.out.println("B");
		} else {
			System.out.println("TIE");
		}
	}
}
