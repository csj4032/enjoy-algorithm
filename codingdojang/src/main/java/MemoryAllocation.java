import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.in;

public class MemoryAllocation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int n = sc.nextInt();

		List<Integer> l = new ArrayList();

		IntStream.range(0, n).forEach(i -> {
			l.add(sc.nextInt());
		});

		System.out.println("합 : " + l.stream().mapToInt(Integer::intValue).sum());
		System.out.println("평균 : " + l.stream().mapToInt(Integer::intValue).average().orElse(0));

		l.clear();
	}
}