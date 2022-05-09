package levelTwo;

import java.util.Collections;
import java.util.LinkedList;

public class Printer {

	public int solution(int[] priorities, int location) {
		int answer = 0;
		int length = priorities.length;
		LinkedList<Report> reports = new LinkedList();
		LinkedList<Integer> priorityStack = new LinkedList<>();

		for (int i = 0; i < length; i++) {
			reports.add(new Report(i, priorities[i], location == i ? true : false));
			priorityStack.add(priorities[i]);
		}

		Collections.sort(priorityStack);

		while (!reports.isEmpty()) {
			Report report = reports.peek();
			if (report.priority.equals(priorityStack.peekLast())) {
				answer++;
				reports.poll();
				priorityStack.pollLast();
				if (report.target) {
					break;
				}
			} else {
				reports.addLast(reports.poll());
			}
		}
		return answer;
	}
}

class Report implements Comparable<Report> {
	Integer index;
	Integer priority;
	Boolean target;

	public Report(Integer index, Integer priority, Boolean target) {
		this.index = index;
		this.priority = priority;
		this.target = target;
	}

	@Override
	public String toString() {
		return "Report{" +
				"index=" + index +
				", priority=" + priority +
				", target=" + target +
				'}';
	}

	@Override
	public int compareTo(Report o) {
		return o.priority.compareTo(this.priority);
	}
}