package leader;

import java.util.HashMap;
import java.util.Map;

/**
 * LEADER 는 전체 배열의 나머지 절반 보다 많아야 함
**/
public class EquiLeader {

	public static int solution(int[] A) {

		Integer result = 0;
		Integer max = 0;
		Integer key = 0;
		Integer length = A.length;
		Map<Integer, Integer> subLeaderMap = new HashMap<>();

		// 배열의 길이가 1 일 경우 0으로 리턴
		if (length == 1) return result;

		for (int i = 0; i < length; i++) {
			int subKey = A[i];
			if (subLeaderMap.containsKey(subKey)) {
				subLeaderMap.put(A[i], subLeaderMap.get(subKey) + 1);
			}

			subLeaderMap.putIfAbsent(subKey, 1);
			if (max < subLeaderMap.get(subKey)) {
				max = subLeaderMap.get(subKey);
				key = subKey;
			}
		}

		// LEADER 는 전체 배열의 나머지 절반 보다 많아야 함 (총 배열의 길이가 7일 경우 LEADER 4)
		if (max > length / 2) {
			int first = 0;

			for (int i = 0; i < length; i++) {
				int subKey = A[i];
				if (key.equals(subKey)) {
					first++;
					max--;
				}

				if (first >= (((i + 1) / 2) + 1) && (max > (length - i - 1) / 2)) {
					result++;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{4, 4, 2, 5, 3, 4, 4, 4})); // 3
		System.out.println(solution(new int[]{4, 3, 4, 4, 4, 2})); // 2
		System.out.println(solution(new int[]{1, 2, 1, 1, 2, 1})); // 3
		System.out.println(solution(new int[]{0})); // 0
		System.out.println(solution(new int[]{1, 2})); // 0
		System.out.println(solution(new int[]{1, 2, 2, 2})); // 1
		System.out.println(solution(new int[]{-1000000000, -1000000000})); // 1
	}
}