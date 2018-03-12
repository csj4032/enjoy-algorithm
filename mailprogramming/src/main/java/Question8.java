public class Question8 {

	public static void main(String[] args) {
		solve(new int[]{10, 5, 4, 3, -1});
		solve(new int[]{3, 1, 9, 7, 10, 5, 4, 3, -1, 6});
		solve(new int[]{3, 3, 3});
		solve(new int[]{3, 3, 0});
		solve(new int[]{0, 3, 0});
		solve(new int[]{-1, -10, 2, -2});
	}

	private static void solve(int[] array) {
		int first = array[0];
		int second = array[1];
		for (int i = 0; i < array.length; i++) {
			if (first < array[i]) {
				second = first;
				first = array[i];
			} else if (second < array[i] || second == first) {
				second = array[i];
			}
		}
		System.out.println(second == first ? "Does not exist" : second);
	}
}