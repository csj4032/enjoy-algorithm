package p10384;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var sb = new StringBuilder();
		var n = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= n; i++) {
			var m = new int[26];
			var s = sc.nextLine().toLowerCase();
			for (int j = 0; j < s.length(); j++) {
				var c = s.charAt(j) - 0;
				if (97 <= c && c <= 127) {
					m[c - 97]++;
				}
			}
			var mm = Integer.MAX_VALUE;
			for (int j = 0; j < 26; j++) {
				mm = Math.min(m[j], mm);
			}
			if (mm == 0) {
				sb.append("Case " + i + ": Not a pangram\n");
			} else if (mm == 1) {
				sb.append("Case " + i + ": Pangram!\n");
			} else if (mm == 2) {
				sb.append("Case " + i + ": Double pangram!!\n");
			} else if (mm >= 3) {
				sb.append("Case " + i + ": Triple pangram!!!\n");
			}
		}
		System.out.println(sb.toString().trim());
	}
}