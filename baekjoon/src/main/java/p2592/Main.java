package p2592;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] m = new int[10];
		int[] l = new int[1000];
		int k = 0;
		for (int i = 0; i < 10; i++) {
			int n = sc.nextInt();
			m[i] = n;
			k = k + n;
			l[n] = l[n] + 1;
		}

		System.out.println(k / 10);
		System.out.println(Arrays.stream(m).mapToObj(Integer::new).collect(Collectors.groupingBy(Integer::intValue, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey());
	}
}