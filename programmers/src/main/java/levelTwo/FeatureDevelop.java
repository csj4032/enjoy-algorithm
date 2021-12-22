package levelTwo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FeatureDevelop {

	public int[] develop(int[] progresses, int[] speeds) {
		int length = progresses.length;
		Deque<Feature> features = IntStream.range(0, length).mapToObj(i -> new Feature(i, progresses[i], speeds[i])).collect(Collectors.toCollection(ArrayDeque::new));
		List<Integer> result = new ArrayList<>();
		while (true) {
			features.stream().forEach(Feature::increaseProgress);
			Iterator<Feature> iterable = features.iterator();
			int count = 0;
			while (iterable.hasNext()) {
				Feature feature = iterable.next();
				if (feature.getSeq() == 0) {
					if (feature.getProgress() >= 100) {
						features.pop();
						features.stream().forEach(Feature::decreaseSeq);
						count++;
					}
				}
			}
			if (count > 0) result.add(count);
			if (features.isEmpty()) break;
		}
		System.out.println(result);
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}

class Feature {
	private int seq;
	private int progress;
	private int speeds;

	public Feature(int seq, int progress, int speeds) {
		this.seq = seq;
		this.progress = progress;
		this.speeds = speeds;
	}

	public void increaseProgress() {
		progress = progress + speeds;
	}

	public void decreaseSeq() {
		seq = seq - 1;
	}

	public void setSeq(int set) {
		this.seq = seq;
	}

	public int getSeq() {
		return seq;
	}

	public int getProgress() {
		return progress;
	}

	public int getSpeeds() {
		return speeds;
	}

	@Override
	public String toString() {
		return "Feature{" +
				"progress=" + progress +
				", speeds=" + speeds +
				'}';
	}
}
