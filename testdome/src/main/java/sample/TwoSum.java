package dbfs;

import java.util.*;

public class TwoSum {

	public static int[] findTwoSum(int[] list, int sum) {
		int[] indices = new int[2];
		boolean flag = false;
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < list.length; i++) {
			if(map.containsKey(list[i])) continue;
			map.put(list[i],i);
		}
		for (int i = 0; i < list.length - 1; i++) {
			int target = sum - list[i];
			if (map.containsKey(target)){
				indices[0] = map.get(target);
				indices[1] = i;
				flag = true;
			}
		}

		if (flag) {
			return indices;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		int[] indices = findTwoSum(new int[]{3, 1, 5, 7, 5, 9}, 10);
		if (indices != null) {
			System.out.println(indices[0] + " " + indices[1]);
		}
	}
}
