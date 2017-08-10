import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.in;

public class JollyJumpers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);

		List<List<Integer>> nn = new ArrayList<>();

		while (sc.hasNextLine()) {
			int j = sc.nextInt();
			if (j == 0) break;
			List mm = new ArrayList(3000);
			for (int i = 0; i < j; i++) {
				mm.add(sc.nextInt());
			}
			nn.add(mm);
		}

		for (int i = 0; i < nn.size(); i++) {
			jolly(nn.get(i).size(), nn.get(i));
		}
	}

	private static void jolly(Integer n, List<Integer> nn) {
		List<Integer> l = new ArrayList<>();
		nn.stream().reduce((a, b) -> {
			l.add(Math.abs(a - b));
			return b;
		});
		System.out.println(IntStream.range(1, n).allMatch(i -> l.contains(i)) ? "Jolly" : "Not jolly");
	}
}