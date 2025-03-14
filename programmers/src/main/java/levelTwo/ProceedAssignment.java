package levelTwo;

import java.util.*;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/176962">과제 진행하기</a>
 * Category : 구현
 */
public class ProceedAssignment {

    public static class Work implements Comparable<Work> {
        public String subject;
        public String originalStartTime;
        public int startTime;
        public int endTime;
        public int duration;

        public Work(String subject, String startTime, String duration) {
            this.subject = subject;
            this.originalStartTime = startTime;
            this.startTime = Integer.parseInt(startTime.split(":")[0]) * 60 + Integer.parseInt(startTime.split(":")[1]);
            this.duration = Integer.parseInt(duration);
            this.endTime = this.startTime + this.duration;
        }

        @Override
        public String toString() {
            return "Work{" + "subject='" + subject + ", startTime=" + startTime + ", endTime=" + endTime + ", duration=" + duration + '}';
        }

        @Override
        public int compareTo(Work o) {
            return Integer.compare(this.startTime, o.startTime);
        }
    }

    public String[] solution(String[][] plans) {
        List<Work> answer = new ArrayList<>();
        LinkedList<Work> queue = new LinkedList<>();
        Stack<Work> stack = new Stack<>();
        for (String[] plan : plans) queue.offer(new Work(plan[0], plan[1], plan[2]));

        Collections.sort(queue);

        while (!queue.isEmpty()) {
            Work current = queue.poll();
            Work next = queue.peek();
            if (next == null) {
                answer.add(current);
                break;
            }
            if (current.endTime > next.startTime) {
                current.duration = current.duration - (next.startTime - current.startTime);
                stack.push(current);
            } else {
                answer.add(current);
                int breakTime = next.startTime - current.endTime;
                while (!stack.isEmpty() && breakTime > 0) {
                    Work work = stack.pop();
                    work.duration = work.duration - breakTime;
                    if (work.duration <= 0) {
                        answer.add(work);
                        breakTime = Math.abs(work.duration);
                    } else {
                        stack.push(work);
                        break;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            answer.add(stack.pop());
        }

        return answer.stream().map(work -> work.subject).toArray(String[]::new);
    }
}