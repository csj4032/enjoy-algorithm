import java.util.Arrays;

public class Amazon {

	//static String[]l = new String[]{"a1", "b1"};
	//static String[] l = new String[]{"a1", "a2", "b1", "b2"};
	//static String[] l = new String[]{"a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "b5"};
	static String[] l = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8"};

	public static void main(String[] args) {
		int s = l.length;
		int c = s / 2;
		for (int i = c; i < s; i++) {
			int m = s - i;
			int t = i;
			while (m > 1) {
				String v = l[t];
				l[t] = l[t - 1];
				l[t - 1] = v;
				m--;
				t--;
			}
		}
		System.out.println(Arrays.toString(l));
	}
}