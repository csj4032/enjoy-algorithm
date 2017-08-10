import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.in;

/*
* 주어진 입력을 오름차순으로 정렬하고 2개의 데크를 이용 하면 가능 할 듯
* */
public class SafePassage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int n = sc.nextInt();

		List<Integer> d = new ArrayList<>();
		List<Integer> e = new ArrayList();

		for (int i = 0; i < n; i++) {
			d.add(sc.nextInt());
		}

		d = d.stream().sorted().collect(Collectors.toList());

		Integer k = 0;

		while (true) {
			Integer a, b, c;
			a = d.remove(0);
			b = d.remove(0);
			e.add(a);
			e.add(b);
			k = k + (a > b ? a : b);

			if (d.size() == 0) break;

			d = d.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			e = e.stream().sorted().collect(Collectors.toList());

			c = e.remove(0);
			d.add(c);
			k = k + c;
		}
		System.out.println(k);
	}
}