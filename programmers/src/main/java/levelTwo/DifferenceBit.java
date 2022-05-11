package levelTwo;

import java.util.Arrays;
import java.util.BitSet;

public class DifferenceBit {

	public long[] solution(long[] numbers) {
		System.out.println((8 ^ 7) >>> 2);
		long[] answer = new long[numbers.length];
		int length = numbers.length;
		for (int i = 0; i < length; i++) {
			long number = numbers[i];
			String binaryString = Long.toBinaryString(number);
			int zeroIndex = binaryString.lastIndexOf("0");
			int oneIndex = binaryString.indexOf("1");
			if ((number % 2) == 0) {
				answer[i] = number + 1;
			} else {
				if (zeroIndex == -1) {
					binaryString = "10" + binaryString.substring(oneIndex + 1);
				} else {
					binaryString = binaryString.substring(0, zeroIndex) + "10" + binaryString.substring(zeroIndex + 2);
				}
				answer[i] = Long.parseLong(binaryString, 2);
			}
		}
		return answer;
	}

	public long[] solutionForBitSet(long[] numbers) {
		long[] answer = new long[numbers.length];
		int length = numbers.length;
		for (int i = 0; i < length; i++) {
			long min = Long.MIN_VALUE - 1;
			long number = numbers[i];
			String[] binaryOriginal = getBinary(number).split("");
			while (true) {
				number++;
				BitSet bitSetOriginal = new BitSet();
				BitSet bitSetTarget = new BitSet();
				String[] binaryTarget = getBinary(number).split("");

				for (int j = 0; j < binaryOriginal.length; j++) {
					if (binaryOriginal[j].equals("1")) bitSetOriginal.set(j);
					if (binaryTarget[j].equals("1")) bitSetTarget.set(j);
				}

				bitSetOriginal.xor(bitSetTarget);
				if (bitSetOriginal.cardinality() <= 2) {
					min = Math.min(min, number);
					answer[i] = min;
					break;
				}
			}
		}
		return answer;
	}

	private String getBinary(long number) {
		return String.format("%17s", Long.toBinaryString(number)).replace(" ", "0");
	}
}
