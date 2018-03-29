import java.util.HashMap;
import java.util.Map;

public class Question5 {

	static int arrayLength = 200000001;
	static int arrayHaftLength = 100000000;

	public static void main(String[] args) {
		solve2(new Integer[]{2, 5, 6, 1, 10}, 8);
	}

	private static void solve2(Integer[] array, int target) {
		int len = array.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			map.put(array[i], i);
			if (null != map.get(target - array[i])) {
				Integer a = target - array[i];
				System.out.println(map.get(a) + " " + i);
			}
		}
		System.out.println(map);
	}

	private static int[][] solve(int[] array, int target) {
		boolean[] bool = new boolean[arrayLength];
		int[] idx = new int[arrayLength];
		int[][] result = new int[array.length][2];

		for (int i = 0; i < array.length; i++) {
			bool[array[i] + arrayHaftLength] = true;
			idx[array[i] + arrayHaftLength] = i;
		}

		for (int i = 0; i < array.length; i++) {
			if (bool[array[i] + arrayHaftLength] && bool[target - array[i] + arrayHaftLength]) {
				bool[array[i] + arrayHaftLength] = false;
				System.out.println("[" + i + ", " + idx[target - array[i] + arrayHaftLength] + "]");
			}
		}
		return result;
	}
}