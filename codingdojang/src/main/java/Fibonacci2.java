import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci2 {

	static Map<Long, Long> map = new HashMap<>();

	public static void main(String[] args) {
		long l = 4294967291L;
		long m = new Scanner(System.in).nextLong();
		for (long i = 0; i < m; i++) {
			map.put(i + 1, fibonacci(i) % l);
		}
		System.out.println(map.get(m));
	}

	private static long fibonacci(long n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (map.get(n + 1l) != null) return map.get(n + 1l);
		return fibonacci(n - 2) + fibonacci(n - 1);
	}
}