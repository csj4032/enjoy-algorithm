import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class OneEditApart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		String a = sc.next();
		String b = sc.next();
		out.println("" + oneEditApart(a, b));
	}

	private static boolean oneEditApart(final String a, final String b) {
		if (Math.abs(a.length() - b.length()) > 1) return false;

		String[] e = a.split("");
		String[] f = b.split("");

		int k = 0;
		int d = 0;

		for (int i = 0; i < f.length; i++) {
			for (int j = k; j < e.length; j++) {
				if (f[i].equals(e[j])) {
					out.println("Same " + f[i] + " " + e[j]);
					k = j + 1;
					break;
				} else {
					d = d + 1;
					out.println("Diff " + f[i] + " " + e[j]);
					if (e.length == f.length) {
						k = j + 1;
						break;
					}
				}
			}
		}
		return d > 1 ? false : true;
	}
}
