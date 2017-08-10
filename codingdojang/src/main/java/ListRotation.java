import java.util.*;

public class ListRotation {

	public static void main(String[] args) {
		List<String> ss = Arrays.asList(new Scanner(System.in).nextLine().split(" "));
		LinkedList<String> sss = new LinkedList<>(ss.subList(1, ss.size()));
		Integer r = Integer.valueOf(ss.get(0));

		while (r > 0) {
			sss.push(sss.pollLast());
			r--;
		}

		while (r < 0) {
			sss.addLast(sss.pollFirst());
			r++;
		}

		//sss.forEach(i -> System.out.print(i + " "));

		int[] a = {11, 12, 13, 14};
		int[] b = {0, 1, 2, 3};
		System.out.println(a[(a = b)[3]]);
	}
}