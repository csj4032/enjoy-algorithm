public class Question10 {

	public static void main(String[] args) {
		solve("");
		solve("a");
		solve("ab");
		solve("aabcbcbc");
		solve("aaaaaaaa");
		solve("abbbcedd");
		solve("abcdefghijk");
		solve("aaaabbbfffadakdef");
	}

	private static void solve(String str) {
		int length = str.length();
		var max = "";
		var temp = "";

		for (int j = 0; j < length; j++) {
			boolean overlap = false;
			int t = 0;
			for (int k = 0; k < temp.length(); k++) {
				if (temp.substring(k, k + 1).equals(str.substring(j, j + 1))) {
					overlap = true;
					t = k;
				}
			}
			if (!overlap) {
				temp += str.substring(j, j + 1);
				if (max.length() < temp.length()) max = temp;
			} else {
				if (max.length() < temp.length()) max = temp;
				j = j - temp.length() + t + 1;
				temp = str.substring(j, j + 1);
			}
		}
		System.out.println(max);
	}
}