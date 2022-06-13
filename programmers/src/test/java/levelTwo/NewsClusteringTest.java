package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NewsClusteringTest {

	@Test
	void test() {
		NewsClustering newsClustering = new NewsClustering();
		Assertions.assertEquals(16384, newsClustering.solution("FRANCE", "french"));
		Assertions.assertEquals(65536, newsClustering.solution("handshake", "shake hands"));
		Assertions.assertEquals(16384, newsClustering.solution("abc", "abbb"));
		Assertions.assertEquals(43690, newsClustering.solution("aa1+aa2", "AAAA12"));
		Assertions.assertEquals(65536, newsClustering.solution("E=M*C^2", "e=m*c^2"));
	}
}