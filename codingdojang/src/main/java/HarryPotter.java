import java.util.*;

public class HarryPotter {

	public static void main(String[] args) {
		Integer cart[] = {0, 0, 0, 1, 2, 3, 3, 4};
		LinkedList<Integer> ll = new LinkedList(Arrays.asList(cart));
		Set<Integer> u = new HashSet(Arrays.asList(cart));
		System.out.println(cart.length + " " + u.size());
		for (int i = u.size(); i > 1; i--) {
			placement(i, ll);
		}
	}

	private static void placement(int i, LinkedList<Integer> ll) {
		System.out.println(i);
	}
}