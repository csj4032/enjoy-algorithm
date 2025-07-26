package p10814;

/*
 * 백준 10814번: 나이순 정렬
 * https://www.acmicpc.net/problem/10814
 * 
 * [문제 분류] 정렬 (안정 정렬)
 * [난이도] Silver 5
 * 
 * [문제 요약]
 * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
 * 이때, 회원들을 나이가 증가하는 순으로 정렬하되, 나이가 같으면 먼저 가입한 사람이 앞에 오도록 하시오.
 * 
 * [제약 조건]
 * - 1 ≤ N ≤ 100,000
 * - 1 ≤ 나이 ≤ 200
 * - 이름은 알파벳 대소문자로만 이루어져 있고, 길이가 100 이하
 * 
 * [알고리즘 설명]
 * 1. 안정 정렬(Stable Sort)이 핵심인 문제
 * 2. 나이를 기준으로 오름차순 정렬하되, 나이가 같으면 원래 순서 유지
 * 3. Java의 Collections.sort()나 Stream의 sorted()는 기본적으로 안정 정렬 보장
 * 
 * [구현 방법]
 * - Member 클래스로 나이와 이름 정보를 묶어서 관리
 * - Comparator.comparing()을 사용하여 나이 기준 정렬
 * - Stream API의 sorted()는 내부적으로 TimSort 사용 (안정 정렬)
 * 
 * [핵심 개념: 안정 정렬(Stable Sort)]
 * - 동일한 키 값을 가진 원소들의 상대적 순서가 정렬 후에도 유지되는 정렬
 * - Merge Sort, Insertion Sort, Counting Sort 등이 안정 정렬
 * - Quick Sort, Heap Sort 등은 불안정 정렬
 * 
 * [다른 구현 방법]
 * 1. 입력 순서를 인덱스로 저장하여 2차 정렬 기준으로 사용
 * 2. 나이가 작은 범위(1~200)이므로 계수 정렬 + 큐 활용 가능
 * 
 * [시간복잡도] O(n log n)
 * [공간복잡도] O(n)
 */

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Member> members = new ArrayList();
		List<Member> orderMembers = new ArrayList();
		for (int i = 0; i < n; i++) {
			members.add(new Member(sc.nextInt(), sc.next()));
		}
		orderMembers = members.stream().sorted(Comparator.comparing(e -> e.age)).collect(Collectors.toList());
		orderMembers.stream().forEach(e -> System.out.println(e.age + " " + e.name));
	}
}

class Member {
	public Integer age;
	public String name;

	public Member(Integer age, String name) {
		this.age = age;
		this.name = name;
	}
}