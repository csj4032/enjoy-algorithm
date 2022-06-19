package levelThree;

import java.util.PriorityQueue;

public class DiskController {

	public int solution(int[][] jobs) {
		PriorityQueue<Job> jobQueue = new PriorityQueue<>();
		for (int i = 0; i < jobs.length; i++) {
			Job job = new Job(jobs[i][0], jobs[i][1]);
			jobQueue.add(job);
		}
		System.out.println(jobQueue);

		int flag = 0;
		int sum = 0;
		Job job;
		while (!jobQueue.isEmpty()) {
			int gap = 0;
			job = jobQueue.poll();
			System.out.println(job);
			if (flag <= job.start) {
				flag = job.start + job.through;
				sum += job.through;
			} else {
				flag = flag + job.through;
				gap = flag - job.start;
				sum += gap;
			}

			for (Job temp : jobQueue) {
				temp.setFlag(flag);
			}
			System.out.println(sum + " " + gap + " " + flag);
		}
		return sum / jobs.length;
	}
}

class Job implements Comparable<Job> {
	Integer start;
	Integer end;
	Integer through;

	public Job(Integer start, Integer through) {
		this.start = start;
		this.end = start + through;
		this.through = through;
	}

	public void setFlag(int flag) {
		if (flag >= start) {
			end = flag - start + through;
		}
	}

	@Override
	public String toString() {
		return "Job{" +
				"start=" + start +
				", end=" + end +
				", through=" + through +
				'}';
	}

	@Override
	public int compareTo(Job o) {
		int result = this.start.compareTo(o.start);
		if (result == 0) {
			result = this.end.compareTo(o.end);
		}
		return result;
	}
}
