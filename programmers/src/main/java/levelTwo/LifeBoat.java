package levelTwo;

import java.util.Arrays;

public class LifeBoat {

	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int i = 0;
		int j = people.length - 1;
		while (i <= j) {
			int from = people[i];
			int to = people[j];
			if (from + to <= limit) {
				answer++;
				people[i] = 0;
				people[j] = 0;
				i = i + 1;
				j = j - 1;
			} else {
				j = j - 1;
			}
			if (i > j) break;
		}
		for (int k = 0; k < people.length; k++) {
			if (people[k] > 0) answer++;
		}
		return answer;
	}
}
