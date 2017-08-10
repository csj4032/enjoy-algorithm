import java.util.Arrays;
import java.util.Scanner;

// 1, Y 기준...
public class ReverseSpiralArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		int n = 0;
		int m = 0;
		int[][] o = new int[j][i];
		for (int k = 0; k < j; k++) {
			for (int l = 0; l < i; l++) {
				o[k][l] = n++;
			}
		}
		System.out.println(Arrays.deepToString(o));
	}
}