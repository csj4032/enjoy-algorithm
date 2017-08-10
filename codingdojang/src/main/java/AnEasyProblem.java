import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class AnEasyProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		List<Integer> l = new ArrayList<>();

		while (sc.hasNext()) {
			int s1 = sc.nextInt();
			if (s1 == 0) {
				break;
			}
			l.add(s1);
		}

		for (int k = 0; k < l.size(); k++) {
			int a = l.get(k);
			int b = Integer.bitCount(a);
			for (int j = a + 1; j <= 1000000; j++) {
				if (Integer.bitCount(j) == b) {
					System.out.println(j);
					break;
				}
			}
		}
	}
}