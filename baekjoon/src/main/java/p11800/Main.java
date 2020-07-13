package p11800;

import java.util.Scanner;

public class Main {

	static String[] alias = {"", "Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh", "Beesh"};
	static String[] alias2 = {"", "Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh"};

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			var a = sc.nextInt();
			var b = sc.nextInt();
			var max = Math.max(a, b);
			var min = Math.min(a, b);
			if (max != min) {
				if (max == 6 && min == 5) min += 2;
				sb.append("Case " + (i + 1) + ": " + alias[max] + " " + alias[min] + "\n");
			} else {
				sb.append("Case " + (i + 1) + ": " + alias2[max] + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
