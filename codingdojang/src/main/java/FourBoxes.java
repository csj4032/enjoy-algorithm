import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FourBoxes {
	public static void main(String[] args) throws FileNotFoundException {

		Integer[][] round = new Integer[1000][1000];
		Integer[][] points = new Integer[4][4];
		String path = FourBoxes.class.getResource("").getPath();

		try (Scanner sc = new Scanner(new File(path + "FourBoxes.txt"))) {
			IntStream.range(0, 1000).forEach(i -> Arrays.fill(round[i], 0));
			IntStream.range(0, 4).forEach(i -> IntStream.range(0, 4).forEach(j -> points[i][j] = sc.nextInt()));
		}
		IntStream.range(0, 4).forEach(i -> IntStream.range(points[i][0], points[i][2]).forEach(j -> IntStream.range(points[i][1], points[i][3]).forEach(k -> round[k][j] = 1)));

		System.out.println(Arrays.stream(round).flatMap(x -> Arrays.stream(x)).filter(i -> i == 1).count());
	}
}