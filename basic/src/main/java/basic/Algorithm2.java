package basic;

import java.util.*;
import java.util.stream.Collectors;

public class Algorithm2 {
	public static void main(String[] args) {
		//System.out.println(groupList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 3));
		//System.out.println(reverseString("ABCD"));
		//System.out.println(binary(20).stream().map(String::valueOf).collect(Collectors.joining()));
		//System.out.println(oddEven(9));
		System.out.println(Arrays.toString(intersect(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 1, 2, 3, 4})));
	}

	private static int[] intersect(int[] nums1, int[] nums2) {
		List list = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j] && !list.contains(nums1[i])) {
					list.add(nums1[i]);
				}
			}
		}

		int[] result = new int[list.size()];
		return result;
	}

	private static List<List<Integer>> groupList(List list, int n) {
		List<List<Integer>> group = new ArrayList<>();
		int size = list.size();
		int remainder = size % n;
		int loop = list.size() / n;
		if (remainder != 0) loop++;
		for (int i = 0; i < loop; i++) {
			int s = i * n;
			int e = s + n;
			if (e > size) {
				e = size;
			}
			group.add(list.subList(s, e));
		}
		return group;
	}

	private static String reverseString(String str) {
		int len = str.length();
		String ret = "";
		for (int i = len - 1; i >= 0; i--) {
			ret += str.charAt(i);
		}
		return ret;
	}

	private static List<Integer> binary(int n) {
		List<Integer> list = new ArrayList();
		while (n > 0) {
			int temp = n / 2;
			list.add(n % 2);
			n = temp;
		}
		Collections.reverse(list);
		return list;
	}

	public static int StringToInt(String str) {
		int i = 0, num = 0, sign = 1;
		char[] c = str.toCharArray();

		if (c[i] == '-') {
			i++;
			sign = -1;
		}

		while (i < c.length) {
			num *= 10;
			num += c[i] - '0';
			i++;
		}

		return num * sign;
	}

	public static boolean oddEven(int n) {
		return ((n & 1) == 0);
	}
}