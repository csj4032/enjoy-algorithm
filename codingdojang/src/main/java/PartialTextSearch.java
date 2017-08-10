import java.util.Scanner;

import static java.lang.System.in;

public class PartialTextSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		String text = sc.next();
		String pattern = sc.next();
		int p = pattern.length();
		int max = 0;
		String result = "";
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < p; j++) {
				if (i < j) {
					String pp = pattern.substring(i, j + 1);
					if (text.indexOf(pp) != -1 && max < pp.length()) {
						max = pp.length();
						result = pp;
					}
				}
			}
		}
		System.out.println(max);
		System.out.println(result);
	}
}