import java.util.*;

public class Daum {
	public static void main(String[] args) {
		Integer[] s = {1, 3, 4, 8, 13, 17, 20};
		Map<Integer, String> r = new HashMap();
		Arrays.asList(s).stream().reduce((a, b) -> {
			if (r.get(b - a) == null) {
				r.put(b - a, "(" + a + ", " + b + ")");
			} else {
				r.put(b - a, r.get(b - a).concat(", (" + a + ", " + b + ")"));
			}
			return b;
		});
		System.out.println(r.entrySet().stream().min(Map.Entry.comparingByKey()).orElse(null).getValue());
	}
}