import java.util.Stack;

public class Stairs {

	static int k = 0;
	static Stack<Integer> l = new Stack();

	public static void main(String[] args) {
		recursive(5, 3);
		System.out.println("===================");
		System.out.println(k);
	}

	private static void recursive(int n, int m) {
		if (n == 0) {
			k = k + 1;
			System.out.println(l);
			return;
		}
		if (n < 0) {
			return;
		}
		for (int i = 1; i <= m; i++) {
			l.push(i);
			recursive(n - i, m);
			l.pop();
		}
	}
}