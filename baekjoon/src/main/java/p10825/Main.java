package p10825;

/*
 * 백준 10825번: 국영수
 * https://www.acmicpc.net/problem/10825
 * 
 * [문제 분류] 정렬 (다중 조건 정렬)
 * [난이도] Silver 4
 * 
 * [문제 요약]
 * 도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다.
 * 다음과 같은 조건으로 학생들을 정렬하는 프로그램을 작성하시오.
 * 
 * [정렬 조건]
 * 1. 국어 점수가 감소하는 순서로 (높은 점수 → 낮은 점수)
 * 2. 국어 점수가 같으면 영어 점수가 증가하는 순서로 (낮은 점수 → 높은 점수)
 * 3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
 * 4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
 * 
 * [제약 조건]
 * - 1 ≤ N ≤ 100,000
 * - 점수는 1 이상 100 이하의 자연수
 * - 이름은 알파벳 대소문자로만 이루어져 있고 길이가 10 이하
 * 
 * [알고리즘 설명]
 * 1. 다중 조건 정렬 문제로, 여러 기준을 순차적으로 적용해야 함
 * 2. Comparator를 사용하여 복합 정렬 조건 구현
 * 3. 각 조건마다 오름차순/내림차순이 다르므로 주의깊게 구현
 * 
 * [구현 방법]
 * - Lambda 표현식으로 Comparator 구현
 * - compareTo() 메서드를 활용하여 각 필드별 비교
 * - result가 0이면 다음 조건으로 넘어가는 방식으로 다중 조건 처리
 * 
 * [핵심 개념: 다중 조건 정렬]
 * - 첫 번째 조건이 같을 때만 두 번째 조건 적용
 * - compareTo() 반환값: 음수(작음), 0(같음), 양수(큼)
 * - 내림차순: e2.compareTo(e1), 오름차순: e1.compareTo(e2)
 * 
 * [구현 세부사항]
 * - 국어: 내림차순 (e2.kor - e1.kor)
 * - 영어: 오름차순 (e1.eng - e2.eng)  
 * - 수학: 내림차순 (e2.mat - e1.mat)
 * - 이름: 사전순 오름차순 (e1.name.compareTo(e2.name))
 * 
 * [시간복잡도] O(n log n)
 * [공간복잡도] O(n)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Student> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}

		list.stream().sorted((e1, e2) -> {
					int result = e2.getKor().compareTo(e1.getKor());  // 국어 내림차순
					if (result == 0) {
						result = e1.getEng().compareTo(e2.getEng());  // 영어 오름차순
					}
					if (result == 0) {
						result = e2.getMat().compareTo(e1.getMat());  // 수학 내림차순
					}
					if (result == 0) {
						result = e1.getName().compareTo(e2.getName());  // 이름 사전순
					}
					return result;
				}
		).forEach(e -> System.out.println(e.getName()));
	}
}

class Student {
	public String name;
	public Integer kor;
	public Integer eng;
	public Integer mat;

	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public Integer getKor() {
		return kor;
	}

	public Integer getEng() {
		return eng;
	}

	public Integer getMat() {
		return mat;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", kor=" + kor +
				", eng=" + eng +
				", mat=" + mat +
				'}';
	}
}