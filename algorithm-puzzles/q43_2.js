N = 12345;

function trit(n) {
	if (n == 0) return 1;
	let a = 0;
	while (Math.pow(3, a + 1) <= n) {
		a++;
	}
	return Math.pow(2, a) + trit(Math.min(n - Math.pow(3, a), Math.pow(3, a) - 1));
}

console.log(trit(N));