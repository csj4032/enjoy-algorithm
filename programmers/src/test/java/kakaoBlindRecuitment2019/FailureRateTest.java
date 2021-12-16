package kakaoBlindRecuitment2019;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class FailureRateTest {

	public int[] solution(int N, int[] stages) {
		Map<Integer, Stage> stageMap = new HashMap<>();
		int totalChallenger = stages.length;
		for (int i = 0; i < totalChallenger; i++) {
			Integer key = stages[i];
			if (stageMap.containsKey(key)) {
				stageMap.get(key).increaseChallenger();
			} else {
				stageMap.put(key, new Stage(key, 1));
			}
		}

		List<FailureRate> failureRateList = new ArrayList<>();
		int prevStageChallenger = 0;
		for (int i = 1; i <= N; i++) {
			FailureRate failureRate = new FailureRate(i, stageMap.get(i), totalChallenger - prevStageChallenger);
			prevStageChallenger += failureRate.getChallenger();
			failureRateList.add(failureRate);
		}
		System.out.println(failureRateList.stream().sorted().collect(Collectors.toList()));
		System.out.println(Arrays.toString(failureRateList.stream().sorted().mapToInt(e -> e.getNumber()).toArray()));
		return failureRateList.stream().sorted().mapToInt(e -> e.getNumber()).toArray();
	}

	@Test
	public void test() {
		Assertions.assertArrayEquals(new int[]{3, 4, 2, 1, 5}, solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
	}
}