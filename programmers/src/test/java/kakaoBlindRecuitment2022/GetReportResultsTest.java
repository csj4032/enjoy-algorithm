package kakaoBlindRecuitment2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetReportResultsTest {

	public int[] solution(String[] id_list, String[] report, int k) {
		GetReportResults getReportResults = new GetReportResults();
		return getReportResults.solution(id_list, report, k);
	}

	@Test
	public void test() {
		Assertions.assertArrayEquals(new int[]{2,1,1,0},
				solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2));

		Assertions.assertArrayEquals(new int[]{0,0},
				solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3));
	}
}