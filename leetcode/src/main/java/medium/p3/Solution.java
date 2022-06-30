package medium.p3;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		String[] ss = s.split("");
		int max = 0;
		int k = 0;
		Map<String, String> map = new HashMap();
		for (int i = 0; i < length; i++) {
			String sss = ss[i];
			if (map.containsKey(sss)) {
				i = i - map.size();
				map = new HashMap<>();
			} else {
				map.put(sss, sss);
				if (max < map.size()) max = map.size();
			}
		}
		return max;
	}
}
