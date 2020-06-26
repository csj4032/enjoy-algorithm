package p1021;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var k = 0;
		LinkedList<String> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) queue.add(String.valueOf(i));
		for (int i = 0; i < m; i++) {
			String t = sc.next();
			var idx = queue.indexOf(t);
			if (idx != 0) {
				var q = idx;
				var p = queue.size() - idx;
				if (q < p) {
					for (int j = 0; j < q; j++) {
						k++;
						queue.addLast(queue.pop());
					}
				} else {
					for (int j = 0; j < p; j++) {
						k++;
						queue.addFirst(queue.removeLast());
					}
				}
			}
			queue.pop();
		}
		System.out.println(k);
	}
}