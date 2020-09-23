package p11091;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var sb = new StringBuilder();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			var s = sc.nextLine();
			s = s.toLowerCase();
			var c = s.toCharArray();
			var m = new int[26];
			for (int j = 0; j < c.length; j++) {
				var k = c[j] - 97;
				if (0 <= k && k <= 26) m[k] = 1;
			}

			var t = 0;
			var ss = "";
			for (int j = 0; j < 26; j++) {
				t += m[j];
				if (m[j] == 0) ss += (char) (97 + j);
			}
			if (t == 26) {
				sb.append("pangram \n");
			} else {
				sb.append("missing " + ss + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
