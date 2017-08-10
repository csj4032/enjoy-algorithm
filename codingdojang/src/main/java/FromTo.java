import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FromTo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> numbers = new ArrayList<>();
		IntStream.range(sc.nextInt(), sc.nextInt()+1).forEach(
				i -> numbers.add(Arrays.asList(String.valueOf(i).split("")).stream().map(j -> (Integer.valueOf(j))).reduce(1, (a, b) -> a * b)));
		System.out.println(numbers.stream().mapToInt(Number::intValue).sum());
	}
}

// 10  >> 16
// 14  >> 14
// 20  >> 10

//20 - 10 = 10;
//14 - 10 = 4;

//14 - 20 = 6
//14 - 10 = 4