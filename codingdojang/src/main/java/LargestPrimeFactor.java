public class LargestPrimeFactor {

	public static void main(String[] args) {
		Long n = 600851475143L;
		for (Long i = 2L; i < n; i++) {
			if (n % i == 0) {
				n = n / i;
			}
		}
		System.out.println(n);
	}
}

//13195
//600851475143L