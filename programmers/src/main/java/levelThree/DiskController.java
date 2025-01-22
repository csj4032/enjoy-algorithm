package levelThree;

import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
public class DiskController {

    public int solution(int[][] jobs) {
        PriorityQueue<Job> jobQueue = new PriorityQueue<>();
        for (int i = 0; i < jobs.length; i++) jobQueue.add(new Job(i, jobs[i][0], jobs[i][1]));
        int sum = 0;
        while (!jobQueue.isEmpty()) {
            PriorityQueue<Job> readyQueue = new PriorityQueue<>();
            Job job = jobQueue.poll();
            for (Job temp : jobQueue) {
                temp.setFlag(job.start + job.through);
                readyQueue.add(temp);
            }
            jobQueue = readyQueue;
            sum += job.end - job.request;
        }
        return sum / jobs.length;
    }

    static class Job implements Comparable<Job> {
        Integer index;
        Integer request;
        Integer start;
        Integer end;
        Integer through;

        public Job(Integer index, Integer request, Integer through) {
            this.index = index;
            this.request = request;
            this.through = through;
            this.start = request;
            this.end = request + through;
        }

        public void setFlag(int flag) {
            if (flag > start) {
                start = flag;
                end = flag + through;
            }
        }

        @Override
        public String toString() {
            return "Job{ index=" + index + ", request=" + request + ", start=" + start + ", end=" + end + ", through=" + through + '}';
        }

        @Override
        public int compareTo(Job o) {
            int result = this.start.compareTo(o.start);
            if (result == 0) result = this.through.compareTo(o.through);
            if (result == 0) result = this.index.compareTo(o.index);
            return result;
        }
    }
}
