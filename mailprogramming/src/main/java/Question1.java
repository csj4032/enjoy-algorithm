import java.util.Arrays;

public class Question1 {

	public static void main(String[] args) {
		//int[] n = new int[]{-1, 3, -1, 5};
		//int[] n = new int[]{-5, -3, -1};
		int[] n = new int[]{2, 4, -2, -3, 8};

		int[] dp = new int[n.length];

		dp[0] = n[0];

		for (int i = 1; i < n.length; i++) {
			dp[i] = Math.max(dp[i - 1] + n[i], n[i]);
		}

		System.out.println(Arrays.stream(dp).max().orElse(0));
	}
}
