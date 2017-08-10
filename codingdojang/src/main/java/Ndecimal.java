import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ndecimal {

	static int t = 233;

	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		String k[] = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
		List<String> queue = new ArrayList();
		while (true) {
			int m = t / n;
			int l = t % n;
			t = m;
			queue.add(k[l]);
			if (m <= n) {
				queue.add(k[m]);
				break;
			}
		}
		Collections.reverse(queue);
		queue.stream().forEach(System.out::print);
	}
}