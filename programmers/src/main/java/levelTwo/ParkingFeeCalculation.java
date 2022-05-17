package levelTwo;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class ParkingFeeCalculation {

	public int[] solution(int[] fees, String[] records) {
		int defaultTime = fees[0];
		int defaultFee = fees[1];
		int unitTime = fees[2];
		int unitFee = fees[3];

		Parking parking = new Parking();

		for (int i = 0; i < records.length; i++) {
			String[] record = records[i].split(" ");
			String[] times = record[0].split(":");
			LocalTime localTime = LocalTime.of(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
			if (record[2].equals("IN")) {
				parking.in(localTime, record[1]);
			} else {
				parking.out(localTime, record[1]);
			}
		}

		Map<String, Deque<Record>> parkingRecords = parking.getRecords();
		Map<String, Integer> result = new LinkedHashMap<>();
		for (String carNumber : parkingRecords.keySet()) {
			int elapsedTime = 0;
			int fee;
			for (Record record : parkingRecords.get(carNumber)) {
				elapsedTime += record.getElapsedTime() / 60;
			}
			if (elapsedTime > defaultTime) {
				int mod = (elapsedTime - defaultTime) % unitTime;
				int unit = ((elapsedTime - defaultTime) / unitTime);
				if (mod > 0) unit++;
				fee = defaultFee + (unit * unitFee);
			} else {
				fee = defaultFee;
			}
			result.put(carNumber, fee);
		}

		int[] answer = result.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()).stream().mapToInt(e -> e.getValue()).toArray();
		return answer;
	}
}

class Parking {

	private Map<String, Deque<Record>> records;

	public Parking() {
		this.records = new LinkedHashMap<>();
	}

	public void in(LocalTime localTime, String carNumber) {
		Record record = new Record(localTime, LocalTime.of(23, 59));
		if (records.containsKey(carNumber)) {
			records.get(carNumber).add(record);
		} else {
			Deque recordByCars = new LinkedList<>();
			recordByCars.add(record);
			records.put(carNumber, recordByCars);
		}
	}

	public void out(LocalTime localTime, String carNumber) {
		if (records.containsKey(carNumber)) {
			records.get(carNumber).getLast().setTo(localTime);
		}
	}

	public boolean contains(String carNumber) {
		return records.containsKey(carNumber);
	}

	public Map<String, Deque<Record>> getRecords() {
		return records;
	}

	@Override
	public String toString() {
		return "Parking{" +
				"records=" + records +
				'}';
	}
}

class Record {

	private LocalTime from;
	private LocalTime to;

	public Record(LocalTime from, LocalTime to) {
		this.from = from;
		this.to = to;
	}

	public LocalTime getFrom() {
		return from;
	}

	public LocalTime getTo() {
		return to;
	}

	public void setFrom(LocalTime from) {
		this.from = from;
	}

	public void setTo(LocalTime to) {
		this.to = to;
	}

	public long getElapsedTime() {
		return Duration.between(from, to).get(ChronoUnit.SECONDS);
	}

	public long getFee(int defaultTime, int defaultFee, int unitTime, int unitFee) {
		if (getElapsedTime() > defaultTime) {
			return defaultFee + (((getElapsedTime() / 60) / unitTime) * unitFee);
		} else {
			return defaultFee;
		}
	}

	@Override
	public String toString() {
		return "Record{" +
				"from=" + from +
				", to=" + to +
				'}';
	}
}