package medium.p22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		recursive(result, n * 2, n, n, "");
		return result;
	}

	private void recursive(List<String> result, int n, int n1, int n2, String str) {
		if (str.length() == n) {
			result.add(str);
			return;
		}
		if (n1 < n) recursive(result, n, n1 + 1, n2, str + "(");
		if (n2 < n1) recursive(result, n, n1, n2 + 1, str + ")");
	}
}
