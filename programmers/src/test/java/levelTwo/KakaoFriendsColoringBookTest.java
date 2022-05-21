package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KakaoFriendsColoringBookTest {

	@Test
	public void test() {
		KakaoFriendsColoringBook kakaoFriendsColoringBook = new KakaoFriendsColoringBook();
		Assertions.assertArrayEquals(new int[]{4, 5}, kakaoFriendsColoringBook.solution(6, 4, new int[][]
				{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}}));
	}
}