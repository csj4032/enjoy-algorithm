package futureTraining;

import java.util.*;

public class ArrayInversionCount {

	public int solution(int[] A) {
		int length = A.length;
		int count = 0;
		for (int j = 1; j < length; j++) {
			int a = A[j - 1];
			int b = A[j];
			if (a > b) {
				count++;
			}
		}
		return count;
	}
}