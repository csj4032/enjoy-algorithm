package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortFileNamesTest {

	@Test
	public void test() {
		SortFileNames sortFileNames = new SortFileNames();
		Assertions.assertArrayEquals(new String[]{"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"},
				sortFileNames.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));
		Assertions.assertArrayEquals(new String[]{"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"},
				sortFileNames.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}));
		Assertions.assertArrayEquals(new String[]{"A-10", "B-50", "F0 -.", "F-14"},
				sortFileNames.solution(new String[]{"F0 -.", "B-50", "A-10", "F-14"}));
	}
}