package kakaoBlindRecuitment2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetReportResultsTest {

	public int[] solution(String[] id_list, String[] report, int k) {
		GetReportResults getReportResults = new GetReportResults();
		return getReportResults.report(id_list, report, k);
	}

	@Test
	public void test() {
		Assertions.assertEquals(7, solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2));
	}
}