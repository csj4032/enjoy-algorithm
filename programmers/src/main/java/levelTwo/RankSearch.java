package levelTwo;

import java.util.*;

/*
Lower Bound, Upper Bound
 */
public class RankSearch {

	public int[] solution(String[] info, String[] query) {
		int m = info.length;
		int l = query.length;
		int[] answer = new int[l];
		Map<String, List<Integer>> informationMap = new LinkedHashMap<>();
		String[] language = new String[]{"cpp", "java", "python", "-"};
		String[] group = new String[]{"backend", "frontend", "-"};
		String[] career = new String[]{"junior", "senior", "-"};
		String[] food = new String[]{"chicken", "pizza", "-"};

		for (int i = 0; i < language.length; i++) {
			for (int j = 0; j < group.length; j++) {
				for (int k = 0; k < career.length; k++) {
					for (int n = 0; n < food.length; n++) {
						String key = language[i] + group[j] + career[k] + food[n];
						informationMap.put(key, new ArrayList<>());
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			String[] infos = info[i].split(" ");
			String[] infosLanguage = new String[]{infos[0], "-"};
			String[] infosGroup = new String[]{infos[1], "-"};
			String[] infosCareer = new String[]{infos[2], "-"};
			String[] infosFood = new String[]{infos[3], "-"};
			for (int j = 0; j < infosLanguage.length; j++) {
				for (int k = 0; k < infosGroup.length; k++) {
					for (int n = 0; n < infosCareer.length; n++) {
						for (int o = 0; o < infosFood.length; o++) {
							String key = infosLanguage[j] + infosGroup[k] + infosCareer[n] + infosFood[o];
							informationMap.get(key).add(Integer.valueOf(infos[4]));
						}
					}
				}
			}
		}

		informationMap.entrySet().stream().forEach(e -> Collections.sort(e.getValue(), Comparator.naturalOrder()));

		for (int i = 0; i < l; i++) {
			String[] queries = query[i].replaceAll(" and ", "").split(" ");
			String key = queries[0];
			Integer point = Integer.valueOf(queries[1]);
			List<Integer> points = informationMap.get(key);
			int lowBound = lowBound(points, point);
			answer[i] = points.size() - lowBound;
		}

		return answer;
	}

	private int lowBound(List<Integer> array, int target) {
		int start = 0;
		int end = array.size();
		while (start < end) {
			int mid = (start + end) / 2;
			if (array.get(mid) >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
}