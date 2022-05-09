package levelTwo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class TruckCrossingTheBridge {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 1;
		Deque<Truck> trucks = new LinkedList();
		int length = truck_weights.length;

		for (int i = 0; i < length; i++) trucks.add(new Truck(0, truck_weights[i]));
		Bridge bridge = new Bridge(bridge_length);

		while (true) {
			answer++;
			if (!trucks.isEmpty()) {
				Truck truck = trucks.peek();
				if (bridge.getWeight() + truck.weights <= weight) {
					bridge.trucks.add(trucks.poll());
				}
			}

			for (Truck bridgeTruck : bridge.trucks) {
				bridgeTruck.index++;
				if (bridgeTruck.index >= bridge_length) {
					bridge.trucks.poll();
				}
			}
			if (bridge.trucks.isEmpty() && trucks.isEmpty()) break;
		}
		return answer;
	}
}

class Bridge {
	Integer length;
	Deque<Truck> trucks;

	public Bridge(Integer length) {
		this.length = length;
		this.trucks = new LinkedBlockingDeque<>();
	}

	public Integer getWeight() {
		return trucks.stream().map(e -> e.weights).reduce((a, b) -> a + b).orElse(0);
	}
}

class Truck {
	Integer index;
	Integer weights;

	public Truck(Integer index, Integer weights) {
		this.index = index;
		this.weights = weights;
	}

	@Override
	public String toString() {
		return "Truck{" +
				"index=" + index +
				", weights=" + weights +
				'}';
	}
}