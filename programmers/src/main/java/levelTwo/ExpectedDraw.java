package levelTwo;

public class ExpectedDraw {

	public int solution(int n, int a, int b) {
		if (n == 2) return 1;
		int answer = 0;
		int k = 1;
		int l = n;
		int m = n / 2;
		while (l > 2) {
			k++;
			if (a > m && b > m) {
				m += n / (int) Math.pow(2, k);
			} else if (a <= m && b <= m) {
				m -= n / (int) Math.pow(2, k);
			} else {
				int o = n / (int) Math.pow(2, k - 2);
				return (int) (Math.log(o) / Math.log(2));
			}
			l = n / (int) Math.pow(2, k - 1);
			answer = (int) (Math.log(l) / Math.log(2));
		}
		return answer;
	}
}