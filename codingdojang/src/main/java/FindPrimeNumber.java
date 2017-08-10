import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;

public class FindPrimeNumber {

	public static void main(String[] args) {
		Long start = new Date().getTime();
		out.println(find1(2, 50000));
		out.println(new Date().getTime() - start);

		start = new Date().getTime();
		out.println(find2(2, 50000));
		out.println(new Date().getTime() - start);

		List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
		out.println(integers);

		integers.stream().forEach(out::print);
	}

	public static int find1(int s, int e) {
		int d = 0;
		for (int i = s; i <= e; i++) {
			int c = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					c = c + 1;
					break;
				}
			}
			if (c == 0) {
				d = d + 1;
			}
		}
		return d;
	}

	public static int find2(Integer s, Integer e) {
		List<Integer> prime = new ArrayList();
		prime.add(2);
		for (int i = s; i <= e; i++) {
			for (int j = 0; j < prime.size(); j++) {
				if (i % prime.get(j) == 0) break;
				if (j == prime.size() - 1) prime.add(i);
			}
		}
		return prime.size();
	}
}