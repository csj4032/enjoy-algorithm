import java.util.Scanner;
import java.util.stream.Stream;

public class Question2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
				.limit(n)
				.mapToInt(t -> t[0])
				.filter(t -> t < n && (t & 1) == 0).sum();
		System.out.println(k);

		int a = 0;
		int b = 1;
		int c = 0;
		int d = 0;
		while (c <= n) {
			c = a + b;
			a = b;
			b = c;
			if ((c & 1) == 0) {
				d += c;
			}
		}
		System.out.println(d);
	}
}