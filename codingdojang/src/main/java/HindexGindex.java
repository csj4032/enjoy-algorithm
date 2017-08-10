import java.util.Arrays;

public class HindexGindex {

	public static void main(String[] args) {
		Integer[] i = new Integer[]{0, 15, 4, 0, 7, 10, 0};
		long c = Arrays.asList(i).stream().filter(j -> j != 0).count();
		long h = Arrays.asList(i).stream().filter(k -> k >= c).count();
		double g = Math.sqrt(Arrays.asList(i).stream().mapToInt(Integer::intValue).sum());
		System.out.printf("h-index : %s , g-index : %s", h, g);
	}
}