package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CacheTest {

	@Test
	public void test() {
		Cache cache = new Cache();
		Assertions.assertEquals(50, cache.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		Assertions.assertEquals(16, cache.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
		Assertions.assertEquals(5, cache.solution(1, new String[]{"newyork"}));
	}
}