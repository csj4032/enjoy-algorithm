package p10814;

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