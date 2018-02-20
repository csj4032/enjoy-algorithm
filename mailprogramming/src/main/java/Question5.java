import java.util.Arrays;

public class Question5 {

	public static void main(String[] args) {
		solve(new int[]{2, 5, 6, 1, 10}, 8);
	}

	private static int[] solve(int[] array, int target) {
		boolean[] bool = new boolean[11];
		int[] idx = new int[11];

		for (int i = 0; i < array.length; i++) {
			bool[array[i]] = true;
			idx[array[i]] = i;
		}

		System.out.println(Arrays.toString(bool));
		System.out.println(Arrays.toString(idx));

		for (int i = 0; i < array.length; i++) {
			if (bool[array[i]] && bool[target - array[i]]) {
				System.out.println(i + " " + idx[target - array[i]]);
			}
		}
		return new int[]{};
	}
}