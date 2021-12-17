package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

	public long solution(int w, int h) {
		long area = w * h;
		long min = Math.min(w, h);
		if (w == 1 || h == 1) return 0;
		if (w == h) return area - h;
		if ((w % 2) != 0 && (h % 2) != 0) return (area - min * 2l) - 1l;
		return area - min * 2l;
	}

	@Test
	public void test() {
		solution(10,1);
	}
}