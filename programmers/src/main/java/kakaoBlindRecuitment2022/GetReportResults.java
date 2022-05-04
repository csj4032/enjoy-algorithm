package kakaoBlindRecuitment2022;

import java.util.*;
import java.util.stream.Collectors;

public class GetReportResults {

	public int[] solution(String[] id_list, String[] report, int k) {
		Map<String, Set<String>> reports = new LinkedHashMap<>();
		Map<String, Set<String>> reportedCounts = new HashMap<>();
		Integer idListLength = id_list.length;
		Integer reportLength = report.length;
		for (int i = 0; i < idListLength; i++) {
			reports.put(id_list[i], new HashSet<>());
			reportedCounts.put(id_list[i], new HashSet<>());
		}
		for (int i = 0; i < reportLength; i++) {
			String id = report[i].split(" ")[0];
			String reported = report[i].split(" ")[1];
			Set<String> reportedIds = reports.get(id);
			reportedIds.add(reported);
			Set<String> uniqueReportedCounts = reportedCounts.getOrDefault(reported, new HashSet<>());
			uniqueReportedCounts.add(id);
		}
		for (int i = 0; i < idListLength; i++) {
			String id = id_list[i];
			Set<String> reportIds = reports.get(id);
			Set<String> filterIds = reportIds.stream().filter(e -> reportedCounts.get(e).size() >= k).collect(Collectors.toSet());
			reports.put(id, filterIds);
		}
		int[] answer = new int[idListLength];
		for (int i = 0; i < idListLength; i++) {
			String id = id_list[i];
			answer[i] = reports.get(id).size();
		}
		return answer;
	}
}
