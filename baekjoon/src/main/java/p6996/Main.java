package p6996;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var sb = new StringBuilder();
		var n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			var m = new int[26];
			var a = sc.next();
			var b = sc.next();

			for (int j = 0; j < a.length(); j++) m[a.charAt(j) - 97]++;
			for (int j = 0; j < b.length(); j++) m[b.charAt(j) - 97]--;

			var s = true;
			for (int j = 0; j < 26; j++) {
				if (m[j] != 0) {
					s = false;
					break;
				}
			}
			if (s) {
				sb.append(a + " & " + b + " are anagrams.\n");
			} else {
				sb.append(a + " & " + b + " are NOT anagrams.\n");
			}
		}
		System.out.println(sb.toString());
	}
}
