package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RankSearchTest {

	@Test
	public void test() {
		RankSearch rankSearch = new RankSearch();
		Assertions.assertArrayEquals(new int[]{1, 1, 1, 1, 2, 4}, rankSearch.solution(
				new String[]{
						"java backend junior pizza 150",
						"python frontend senior chicken 210",
						"python frontend senior chicken 150",
						"cpp backend senior pizza 260",
						"java backend junior chicken 80",
						"python backend senior chicken 50"},
				new String[]{
						"java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200",
						"cpp and - and senior and pizza 250",
						"- and backend and senior and - 150",
						"- and - and - and chicken 100",
						"- and - and - and - 150"}));
	}
}