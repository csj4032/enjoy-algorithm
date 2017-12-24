package iterations;

import java.util.Comparator;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class BinaryGap {

	public int solution(int N) {
		String binary = Integer.toBinaryString(N);
		return asList(binary.substring(0, binary.lastIndexOf("1")).split("1")).stream().mapToInt(e -> e.length()).max().orElse(0);
	}

	public static int solution2(int N) {
		return Stream.of(Integer.toBinaryString(N)
				.replaceAll("0+$", "")
				.split("1+")).filter(a -> a != null)
				.max(Comparator.comparing(String::length))
				.map(String::length).orElse(0);
	}

	public static void main(String[] args) {
		BinaryGap solution = new BinaryGap();
		System.out.println(solution.solution(51712));
	}
}