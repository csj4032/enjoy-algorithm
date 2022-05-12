package levelTwo;

import java.util.Arrays;

public class LifeBoat {

	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int boat = people[0];
		for (int i = people.length - 1; i > 0; i++) {
			if (people[i] == 0) continue;
			if (people[i] + boat == limit) people[i] = 0;
			answer++;

		}
		return answer;
	}
}
