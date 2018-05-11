#include <stdio.h>

int dp[42] = {1, 0, 1,};

int main() {

	int t, n, i;
	scanf("%d", &t);
	for (i = 2; i < 42; i++) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}

	while (t--) {
		scanf("%d", &n);
		printf("%d %d\n", dp[n], dp[n + 1]);
	}
	return 0;
}