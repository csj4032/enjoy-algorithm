import java.util.Scanner;

public class Steps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < sc.nextInt(); i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(recursive(b - a, 1));
		}
	}

	private static int recursive(int gap, int i) {
		if (gap > i * 2) {
			return 2 + recursive(gap - i * 2, i + 1);
		} else {
			return gap > i ? 2 : 1;
		}
	}
}