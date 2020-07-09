package p11319;

import java.util.Scanner;

public class Main {

	static String vowels = "AEIOUaeiou";

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			var s = sc.nextLine().replaceAll(" ", "");
			var a = 0;
			var b = 0;
			for (int j = 0; j < s.length(); j++) {
				if (vowels.contains(String.valueOf(s.charAt(j)))) {
					a++;
				} else {
					b++;
				}
			}
			System.out.println(b + " " + a);
		}
	}
}
