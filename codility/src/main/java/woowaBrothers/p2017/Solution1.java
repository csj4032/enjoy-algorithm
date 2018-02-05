package woowaBrothers.p2017;

public class Solution1 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1}));
	}

	private static int solution(int[] A) {
		int index = 0, count = 0;
		do {
			index = A[index];
			count++;
		} while (index != -1);
		return count;
//		int idx = A[0];
//		int count = 1;
//		while (true) {
//			if (A[idx] == -1) {
//				count++;
//				return count;
//			} else {
//				count++;
//				idx = A[idx];
//			}
//		}
	}
}