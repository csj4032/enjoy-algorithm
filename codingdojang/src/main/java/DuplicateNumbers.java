import java.util.*;

public class DuplicateNumbers {

	public static void main(String[] args) {
		List<String> list = Arrays.asList(new Scanner(System.in).next().split(""));
		System.out.println(list.size() == 10 && new HashSet<>(list).size() == 10);
	}
}