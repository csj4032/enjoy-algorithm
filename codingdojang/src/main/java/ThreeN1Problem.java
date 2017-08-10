import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThreeN1Problem {
	public static void main(String[] args) throws FileNotFoundException {

		String path = ThreeN1Problem.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path + "ThreeN1Problem.txt"));
		Integer numbers[][] = new Integer[10][2];

		int i = 0;
		while (sc.hasNext()) {
			numbers[i][0] = sc.nextInt();
			numbers[i][1] = sc.nextInt();
			i++;
		}

		for (int j = 0; j < i; j++) {
			int max = 0;
			for (int k = numbers[j][0]; k <= numbers[j][1]; k++) {
				int count = 1;
				int n = k;
				while (n > 1) {
					if (n % 2 == 0) {
						n = n / 2;
					} else {
						n = n * 3 + 1;
					}
					count++;
				}
				if (max < count) max = count;
			}
			System.out.printf("%d\t\t%d\t\t%d\n", numbers[j][0], numbers[j][1], max);
		}
	}
}
