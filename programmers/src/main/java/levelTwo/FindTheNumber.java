package levelTwo;

public class FindTheNumber {

	public int solution(int n, int k) {
		int answer = 0;
		String[] str = Integer.toString(n, k).split("0");
		int length = str.length;
		for (int i = 0; i < length; i++) {
			String number = str[i];
			if (number.equals("") || number.equals("1")) continue;
			if (isPrime(Double.parseDouble(number))) {
				answer++;
			}
		}
		return answer;
	}

	public static boolean isPrime(double number) {
		for (double i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) return false;
		}
		return true;
	}
}