package levelTwo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class RepresentationOfNumbers {

	public int numbers(int n) {
		AtomicInteger count = new AtomicInteger(1);
		int length = (n / 2) + 1;
		IntStream.rangeClosed(1, length).forEach(e -> loop(n, count, length, e));
		return count.intValue();
	}

	private void loop(int n, AtomicInteger count, int length, int e) {
		IntStream.rangeClosed(e, length).reduce(0, (a, b) -> counter(n, count, a, b));
	}

	private int counter(int n, AtomicInteger count, int a, int b) {
		int c = a + b;
		if (c == n) count.getAndIncrement();
		return c;
	}
}
