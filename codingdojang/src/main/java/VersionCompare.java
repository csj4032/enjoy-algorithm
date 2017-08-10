import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class VersionCompare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		String i = sc.next();
		String ii = sc.next();
		String[] a = i.split("\\.");
		String[] b = ii.split("\\.");

		int len = a.length > b.length ? a.length : b.length;

		String[] aa = Arrays.copyOf(a, len);
		String[] bb = Arrays.copyOf(b, len);

		for (int j = 0; j < len; j++) {
			int k = aa[j] == null ? 0 : Integer.valueOf(aa[j]);
			int l = bb[j] == null ? 0 : Integer.valueOf(bb[j]);

			if (k < l) {
				System.out.println(i + " < " + ii);
				break;
			} else if (k > l) {
				System.out.println(i + " > " + ii);
				break;
			}
		}
	}
}