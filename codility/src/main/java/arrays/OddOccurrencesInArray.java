package arrays;

public class OddOccurrencesInArray {

	public int solution(int[] N) {
		int temp = 0;
		for (int i = 0; i < N.length; i++) {
			temp = temp ^ N[i];
		}
		return temp;
	}
}