package winterCoding2018;

public class SkillTree {

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			String tree = skill_trees[i];
			String after = "";
			int some = 0;
			for (int j = 0; j < tree.length(); j++) {
				for (int k = 0; k < skill.length(); k++) {
					if (skill.charAt(k) == tree.charAt(j)) {
						after = after + tree.charAt(j);
						some++;
					}
				}
			}

			boolean flag = true;
			for (int j = 0; j < after.length(); j++) {
				if (skill.charAt(j) != after.charAt(j)) {
					flag = false;
				}
			}

			if (some == 0 || flag) answer++;
		}

		return answer;
	}
}
