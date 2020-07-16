package p9081;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 제목 : 단어 맞추기
 * 링크 : https://www.acmicpc.net/problem/9081
 * 분류 : Next Permutation
 * 참고 : https://tttuer.tistory.com/212?category=776472
 *
 * 1. 앞에서 부터 배열을 보면서 arr[i] < arr[i+1]을 만족하는 가장 마지막 i를 찾는다.
 * 1.1 맨 뒤에서 부터 배열을 보면서 arr[i-1] >= arr[i] 인 마지막 i를 찾는다.
 * 2. 만약 그러한 i가 없다면 이미 마지막 순열이다.
 * 3. 뒤에서 부터 시작 arr[j] > arr[i] 인 첫번째 j를 찾는다.
 * 4. swap(i,j)한다.
 * 5. 그 이후에 i+1부터 끝까지 정렬을 해준다.
 *
 *
 * 출처: https://tttuer.tistory.com/212?category=776472
 */
public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var sb = new StringBuilder();
		var t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			sb.append(nextPermutation(sc.next()) + "\n");
		}
		System.out.println(sb.toString());
	}

	private static String nextPermutation(String word) {
		var i = word.length() - 1;
		while (i > 0 && word.charAt(i - 1) >= word.charAt(i)) {
			i--;
		}
		if (i <= 0) return word;

		var j = word.length() - 1;
		while (word.charAt(j) <= word.charAt(i - 1)) {
			j--;
		}
		var arr = word.split("");
		swap(i - 1, j, arr);

		j = word.length() - 1;
		while (i < j) {
			swap(i, j, arr);
			i++;
			j--;
		}

		return Arrays.stream(arr).collect(Collectors.joining());
	}

	private static void swap(int i, int m, String[] str) {
		var temp = str[i];
		str[i] = str[m];
		str[m] = temp;
	}
}
