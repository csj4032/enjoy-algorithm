import java.util.HashMap;
import java.util.Map;

public class Question11 {

	public static void main(String[] args) {
		System.out.println(solve("EGG", "FOO"));
		System.out.println(solve("ABBCD", "APPLE"));
		System.out.println(solve("AAB", "FOO"));
	}

	private static boolean solve(String target1, String target2) {
		Map map = new HashMap<String, String>();
		for (int i = 0; i < target1.length(); i++) {
			var subString1 = target1.substring(i, i + 1);
			var subString2 = target2.substring(i, i + 1);
			map.putIfAbsent(subString1, subString2);
			if (!map.get(subString1).equals(subString2)) {
				return false;
			}
		}
		return true;
	}
}