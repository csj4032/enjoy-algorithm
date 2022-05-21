package levelTwo;

public class JumpAndTeleport {

	public int solution(int n) {
		int ans = 0;
		while (n >= 1) {
			int m = n % 2;
			if (m == 1) {
				n = (n - 1) / 2;
				ans++;
			} else {
				n = n / 2;
			}
		}
		return ans;
	}
}