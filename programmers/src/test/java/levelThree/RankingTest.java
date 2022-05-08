package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RankingTest {

	@Test
	public void test() {
		Ranking ranking = new Ranking();
		Assertions.assertEquals(2, ranking.solution(5, new int[][]{
				{4, 3},
				{4, 2},
				{3, 2},
				{1, 2},
				{2, 5}
		}));

//		Assertions.assertEquals(5, ranking.solution(5, new int[][]{
//				{1, 4},
//				{4, 2},
//				{2, 5},
//				{5, 3}
//		}));
	}
}