package p1431;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 제목 : 시리얼 번호
 * 링크 : https://www.acmicpc.net/problem/1431
 * 분류 : 정렬, 파싱
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Serial> serials = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			serials.add(new Serial(sc.next()));
		}
		serials.sort(Comparator.comparing(Serial::getLength).thenComparing(Serial::getTotal).thenComparing(Serial::getValue));
		serials.forEach(System.out::println);
	}
}

class Serial {
	Integer length;
	Integer total;
	String value;

	public Serial(String value) {
		this.value = value;
	}

	public Integer getLength() {
		return value.length();
	}

	public Integer getTotal() {
		int sum = 0;
		for (int i = 0; i < value.length(); i++) {
			if (Character.isDigit(value.charAt(i))) {
				sum += Character.getNumericValue(value.charAt(i));
			}
		}
		return sum;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
