import java.util.Arrays;

public class Question13 {

	public static void main(String[] args) {
		System.out.println(solve(new int[]{-1, 3, -1, 5, 4}, 2));
		System.out.println(solve(new int[]{2, 4, -2, -3, 8}, 1));
		System.out.println(solve(new int[]{-5, -3, 1}, 3));
	}

	private static int solve(int[] array, int target) {
		Arrays.parallelSort(array);
		return array[array.length - target];
	}
}