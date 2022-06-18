package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CandidateKeyTest {

	@Test
	void test() {
		CandidateKey candidateKey = new CandidateKey();
		Assertions.assertEquals(2, candidateKey.solution(new String[][]{
				{"100", "ryan", "music", "2"},
				{"200", "apeach", "math", "2"},
				{"300", "tube", "computer", "3"},
				{"400", "con", "computer", "4"},
				{"500", "muzi", "music", "3"},
				{"600", "apeach", "music", "2"}
		}));
	}
}