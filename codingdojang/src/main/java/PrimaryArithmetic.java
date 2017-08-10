import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class PrimaryArithmetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		List<String[][]> l = new ArrayList();
		while (true) {
			String f = sc.next();
			String s = sc.next();

			if (f.equals("0") && s.equals("0")) break;

			String a[] = f.split("");
			String b[] = s.split("");

			String c[][] = new String[2][10];
			Arrays.fill(c[0], "0");
			Arrays.fill(c[1], "0");
			System.arraycopy(a, 0, c[0], 10 - a.length, a.length);
			System.arraycopy(b, 0, c[1], 10 - b.length, b.length);

			l.add(c);
		}

		for (String[][] s : l) {
			int c = 0;
			int d = 0;
			for (int i = 9; i >= 0; i--) {
				int a = Integer.valueOf(s[0][i]);
				int b = Integer.valueOf(s[1][i]);
				if (a + b + d >= 10) {
					d = 1;
					c++;
				}
			}
			if (c == 0)
				System.out.println("No carry operation.");
			else
				System.out.println(c + " carry operations.");
		}
	}
}