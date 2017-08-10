import java.util.Arrays;
import java.util.Scanner;

public class SlidingWindow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int e = n - k + 1;
		int nn[] = new int[n];
		int max[] = new int[e];
		int min[] = new int[e];
		for (int i = 0; i < n; i++) {
			nn[i] = sc.nextInt();
		}

		for (int i = 0; i < e; i++) {
			int temp[] = Arrays.copyOfRange(nn, i, i + k);
			max[i] = Arrays.stream(temp).max().getAsInt();
			min[i] = Arrays.stream(temp).min().getAsInt();
		}

		System.out.println(Arrays.toString(min));
		System.out.println(Arrays.toString(max));
	}
}