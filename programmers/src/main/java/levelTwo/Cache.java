package levelTwo;

import java.util.LinkedList;

public class Cache {

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		int length = cities.length;
		LinkedList<String> queue = new LinkedList();
		for (int i = 0; i < length; i++) {
			String city = cities[i].toLowerCase();
			if (queue.contains(city)) {
				answer++;
				queue.remove(city);
				queue.addLast(city);
			} else {
				answer = answer + 5;
				queue.addLast(city);
			}
			if (queue.size() > cacheSize) queue.removeFirst();
		}
		return answer;
	}
}