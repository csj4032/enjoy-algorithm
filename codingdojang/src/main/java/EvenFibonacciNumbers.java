import java.math.BigInteger;
import java.util.stream.Stream;

public class EvenFibonacciNumbers {

	public static void main(String[] args) {
		System.out.println(
				Stream.iterate(new BigInteger[]{BigInteger.ONE, BigInteger.ONE}, p -> new BigInteger[]{p[1], p[0].add(p[1])})
				.limit(100)
				.filter(p -> p[1].mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0)
				.filter(p -> p[1].compareTo(BigInteger.valueOf(4000000L)) < 0)
				.map(p -> p[1].intValue()).reduce((a, b) -> a + b).get()
		);
	}
}