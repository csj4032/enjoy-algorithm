import java.util.ArrayList;
import java.util.List;

public class OutsideArea {
	public static void main(String[] args) {
		Integer n = 4;
		Integer[][] m = {{1, 4, 3, 4}, {2, 3, 4, 1}, {3, 4, 2, 1}, {9, 3, 2, 1}};
		List<List<Integer>> l = new ArrayList<>();
		List<Integer> s = new ArrayList<>();
		Integer d = n * n * 2;

		for (int i = 0; i < n; i++) {
			List h = new ArrayList(n);
			List v = new ArrayList(n);
			for (int j = 0; j < n; j++) {
				h.add(m[i][j]);
				v.add(m[j][i]);
			}
			l.add(h);
			l.add(v);
		}

		l.stream().filter(i -> i.add(0)).forEach(j -> j.stream().reduce(0, (a, b) -> {
			s.add(Math.abs(a - b));
			return b;
		}));

		System.out.println(s.stream().mapToInt(Integer::intValue).sum() + d);
	}
}