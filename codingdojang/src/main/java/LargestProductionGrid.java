import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestProductionGrid {

	static int numbers[][] = new int[20][20];
	static List<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) throws FileNotFoundException {
		String path = InvestmentInStocks.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path + "LargestProductionGrid.txt"));

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				numbers[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 17; j++) {
				multiplication(i, j);
			}
		}

		System.out.println(result.stream().max(Integer::compare));
	}

	private static void multiplication(int x, int y) {
		Integer a = 1, b = 1, c = 1, d = 1, e = 1, f = 1, h = 1, i = 1;
		for (int k = 0; k < 4; k++) {
			a *= numbers[x + k][y];
			b *= numbers[x][y + k];
			c *= numbers[x + k][y + k];
			if (3 < x && 3 < y) {
				d *= numbers[x - k][y - k];
				e *= numbers[x][y - k];
				f *= numbers[x - k][y];
				h *= numbers[x + k][y - k];
				i *= numbers[x - k][y + k];
			}
			result.add(a);
			result.add(b);
			result.add(c);
			result.add(d);
			result.add(e);
			result.add(f);
			result.add(h);
			result.add(i);
		}
	}
}