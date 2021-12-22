package levelTwo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ScovilleScale {

	private PriorityQueue<Integer> priorityQueue;

	public ScovilleScale(PriorityQueue priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

	public int mix(int k) {
		int count = 0;
		while (true) {
			if (priorityQueue.size() < 2) {
				count = -1;
				break;
			}
			Integer first = priorityQueue.poll();
			Integer second = priorityQueue.poll();
			Integer result = first + (second * 2);
			priorityQueue.add(result);
			System.out.println(priorityQueue);
			count++;
			if (priorityQueue.stream().allMatch(e -> e >= k)) break;
		}
		return count;
	}

	public static ScovilleScale of(int[] scoville) {
		return new ScovilleScale(Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new)));
	}
}
