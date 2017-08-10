import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class LightMoreLight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		List<Long> l = new ArrayList();
		while (sc.hasNext()) {
			Long i = sc.nextLong();
			if (i == 0L) break;
			l.add(i);
		}

		for (Long i : l) {
			System.out.println(solved(i) % 2 == 1 ? "yes" : "no");
		}
	}

	private static int solved(Long i) {
		List<Long> l = new ArrayList();
		Long len = i;
		l.add(1L);
		l.add(i);
		for (Long j = 2L; j < len; j++) {
			if (i % j == 0L) {
				l.add(j);
				Long x = i / j;
				if(x != j) l.add(x);
				len = x - 1;
			}
		}
		return l.size();
	}
}