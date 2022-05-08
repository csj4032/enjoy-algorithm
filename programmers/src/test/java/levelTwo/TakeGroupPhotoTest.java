package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TakeGroupPhotoTest {

	@Test
	public void test() {
		TakeGroupPhoto takeGroupPhoto = new TakeGroupPhoto();
		Assertions.assertEquals(3648, takeGroupPhoto.solution(2, new String[]{"N~F=0", "R~T>2"}));
		Assertions.assertEquals(0, takeGroupPhoto.solution(2, new String[]{"M~C<2", "C~M>1"}));
	}
}