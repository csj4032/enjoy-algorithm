public class Question5 {

	static int arrayLength = 200000001;
	static int arrayHaftLength = 100000000;

	public static void main(String[] args) {
		solve(new int[]{2, 5, 6, 1, 10}, 8);
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
				//result[i][0] = i;
				//result[i][1] = idx[target - array[i] + arrayHaftLength];
			}
		}
		return result;
	}
}