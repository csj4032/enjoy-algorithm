import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class TheKnightsOfTheRoundTable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		List<Double> n = new ArrayList<>();
		n.add(sc.nextDouble());
		n.add(sc.nextDouble());
		n.add(sc.nextDouble());

		Double t = n.stream().reduce((a, b) -> a + b).get();
		Double a = n.stream().max(Double::compareTo).get();
		Double b = n.stream().min(Double::compareTo).get();
		Double c = t - a - b;
		Double d;
		Double r;

		if (a <= t / 2) {
			if (a.equals(c) || b.equals(c)) {
				d = (Math.sqrt(Math.pow(a, 2) - Math.pow(b / 2, 2)) * b) / 2;
				System.out.println(d);
				r = (2 * d) / t;
			} else {
				r = (a - b - c) / 2;
			}
			System.out.printf("The radius of the round table is: %.3f", Math.abs(r));
		} else {
			System.out.println("잘못된 길이");
		}
	}
}