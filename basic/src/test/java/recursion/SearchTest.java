package recursion;

import org.junit.jupiter.api.Test;

public class SearchTest {

	@Test
	public void searchTest() {
		Search search = new Search();
		System.out.println(search.search(new int[]{1, 2, 3, 4, 5}, 0, 4, 3));
	}
}