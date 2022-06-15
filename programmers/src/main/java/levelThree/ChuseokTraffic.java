package levelThree;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ChuseokTraffic {

	public int solution(String[] lines) {
		int length = lines.length;
		List<ProcessingTime> processingTimes = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			String[] line = lines[i].split("\\s");
			ProcessingTime processingTime = new ProcessingTime(line);
			processingTimes.add(processingTime);
		}

		int answer = 0;
		for (int i = 0; i < length; i++) {
			ProcessingTime target = processingTimes.get(i);
			int temp = 1;
			for (int j = 0; j < length; j++) {
				if (i == j) continue;
				ProcessingTime destination = processingTimes.get(j);
				if (target.overlap(destination)) {
					temp++;
				}
			}
			if (answer < temp) answer = temp;
		}
		return answer;
	}
}

class ProcessingTime {

	LocalDateTime fromLocalTime;
	LocalDateTime toLocalTime;
	LocalDateTime siblingTime;
	LocalTime processingTime;

	public ProcessingTime(String[] line) {
		this.toLocalTime = LocalDateTime.parse(line[0] + " " + line[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		String[] sSSS = line[2].replaceAll("s", "").split("\\.");
		int second = Integer.parseInt(sSSS[0]) * 1000;
		int millisOfSecond = 0;
		if (sSSS.length > 1) millisOfSecond = Integer.parseInt(sSSS[1]);
		this.fromLocalTime = toLocalTime.minus(second + millisOfSecond, ChronoUnit.MILLIS);
		this.siblingTime = toLocalTime.plus(999, ChronoUnit.MILLIS);
	}

	public boolean overlap(ProcessingTime destination) {
		long thisSiblingNano = siblingTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		long thisToNano = toLocalTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		long destFromNano = destination.fromLocalTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		long destToNano = destination.toLocalTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		if (thisSiblingNano > destFromNano && thisToNano <= destToNano) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "ProcessingTime{" +
				"fromLocalTime=" + fromLocalTime +
				", toLocalTime=" + toLocalTime +
				", processingTime=" + processingTime +
				", siblingTime=" + siblingTime +
				'}';
	}
}