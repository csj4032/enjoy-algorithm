package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NextBigNumberTest {

	public int solution(int n) {
		String bitString = Integer.toBinaryString(n);
		int bitCount = 0;
		for (int i = 0; i < bitString.length(); i++) {
			if (bitString.charAt(i) == '1') bitCount++;
		}

		int answer = 0;
		for (int i = n + 1; i <= 1_000_000; i++) {
			String bit = Integer.toBinaryString(i);
			int count = 0;
			for (int j = 0; j < bit.length(); j++) {
				if (bit.charAt(j) == '1') count++;
			}
			if (count == bitCount) {
				answer = i;
				break;
			}
		}
		return answer;
	}

	@Test
	public void test() {
		Assertions.assertEquals(83, solution(78));
		Assertions.assertEquals(23, solution(15));
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(1));
		System.out.println(1 & 1);
	}
}