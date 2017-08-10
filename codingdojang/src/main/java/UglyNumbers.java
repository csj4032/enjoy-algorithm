import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class UglyNumbers {
	public static void main(String[] args) {
		List<Long> l = new ArrayList<>();
		Long i = 1L;
		l.add(1L);
		while (true) {
			Long s = l.remove(0);
			l.add(s * 2L);
			l.add(s * 3L);
			l.add(s * 5L);
			l = l.stream().distinct().sorted().collect(Collectors.toList());
			if (i == 1500) {
				System.out.printf("The 1500'th ugly number is %d \n", s);
				break;
			}
			i++;
		}

		LongStream.iterate(1L, x -> x < 15001, x -> x + 1).forEach(System.out::println);
	}
}