package p5635;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Map<String, LocalDate> map = new HashMap();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			Integer dd = sc.nextInt();
			Integer mm = sc.nextInt();
			Integer yy = sc.nextInt();
			map.put(name, LocalDate.of(yy, mm, dd));
		}
		System.out.println(map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());
		System.out.println(map.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey());

		//map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(1).forEach(e-> System.out.println(e.getKey()));
		//map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).limit(1).forEach(e-> System.out.println(e.getKey()));
	}
}