package leader;

/**
 * Dominator가 될 수 있는 숫자는 나머지 숫자들보다 많이 존재 해야함
 *
 * **/
public class Dominator {

	public static int solution(int[] A) {
		if (A.length == 0) return -1;
		int count = 0;
		int elem = A[0];

		for (int i : A) {
			if (elem == i) {
				count++;
			} else {
				if (count == 0) {
					elem = i;
					count++;
				} else {
					count--;
				}
			}
		}

		int ct = 0;
		int ind = -1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				ct++;
				ind = i;
			}
		}

		if (ct > A.length / 2) return ind;
		else return -1;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
		//solution(new int[]{1, 2, 3});
	}
}
