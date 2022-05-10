package levelTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthVisit {

	public int solution(String dirs) {

		Map<String, Integer[]> directionMap = new HashMap();
		List<String> visited = new ArrayList();
		Integer[] point = new Integer[]{5, 5};
		directionMap.put("U", new Integer[]{-1, 0});
		directionMap.put("R", new Integer[]{0, 1});
		directionMap.put("D", new Integer[]{1, 0});
		directionMap.put("L", new Integer[]{0, -1});
		String[] directions = dirs.split("");

		int answer = 0;
		for (int i = 0; i < directions.length; i++) {
			Integer[] dir = directionMap.get(directions[i]);
			Integer y = point[0] + dir[0];
			Integer x = point[1] + dir[1];
			if (y < 0 || y > 10 || x < 0 || x > 10) continue;
			String fromTo = point[0] + "" + point[1] + y + "" + x;
			String toFrom = y + "" + x + point[0] + "" + point[1];
			if (!visited.contains(fromTo) && !visited.contains(toFrom)) {
				answer++;
				visited.add(fromTo);
				visited.add(toFrom);
			}
			point[0] = y;
			point[1] = x;
		}
		return answer;
	}
}