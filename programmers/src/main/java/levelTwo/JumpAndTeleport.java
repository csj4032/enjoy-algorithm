package levelTwo;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12980">점프와 순간 이동</a>
 * Category :
 */
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