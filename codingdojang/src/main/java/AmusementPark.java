import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmusementPark {

	public static void main(String[] args) throws FileNotFoundException {
		String path = AmusementPark.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path + "AmusementPark.txt"));

		int size = sc.nextInt();
		int target = sc.nextInt();
		int[] dolls = new int[size];

		for (int i = 0; i < size; i++) {
			dolls[i] = sc.nextInt();
		}

		for (int i = 1; i < 1 << size; i++) {
			int k = i;
			int d = 0;
			List<Integer> t = new ArrayList<>();
			while (k > 0) {
				if (k % 2 == 1) t.add(dolls[d]);
				k = k / 2;
				d++;
			}
			System.out.println(t);
			if (t.stream().mapToInt(Integer::intValue).sum() == target) {
				System.out.println(t);
				break;
			}
		}
	}
}