import java.util.Arrays;

public class Question9 {

	public static void main(String[] args) {
		solve(new int[]{0, 5, 0, 3, -1});
		solve(new int[]{3, 0, 3});
		solve(new int[]{0, 0, 3});
		solve(new int[]{0, 0, 0});
		solve(new int[]{0, 0, -1});
		solve(new int[]{0, 0, 3, 3, 3, 3, 4, 0, 0, 0, 0, 2, 3, 4, 5});
	}

	private static void solve(int[] array) {
		int toIndex = array.length;
		int fromIndex = 0;
		for (int i = 0; i < toIndex; i++) {
			if (array[i] != 0) {
				array[fromIndex] = array[i];
				fromIndex++;
			}
		}
		Arrays.fill(array, fromIndex, toIndex, 0);
		System.out.println(Arrays.toString(array));
	}
}