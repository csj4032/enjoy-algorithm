public class Question7 {

	public static void main(String[] args) {
		solve("abc 123 apple");
	}

	private static void solve(String string) {
		if (string.equals("")) {
			return;
		} else {
			solve(string.substring(1));
			System.out.print(string.charAt(0));
		}
	}
}