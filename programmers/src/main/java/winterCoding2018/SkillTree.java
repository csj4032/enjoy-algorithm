package winterCoding2018;

public class SkillTree {

    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        for (int i = 0; i < skill_trees.length; i++) {
            String tree = skill_trees[i];
            String after = "";
            for (int j = 0; j < tree.length(); j++) {
                char c = tree.charAt(j);
                int idx = skill.indexOf(c);
                if (idx != -1) {
                    after = after + idx;
                }
            }

            if (after.length() == 0) answer--;
            System.out.println(after + " " + answer);

            for (int j = 0; j < after.length(); j++) {
                int k = after.charAt(j) + 0;
                int t = j + 48;
                if (k != t) {
                    answer--;
                    break;
                }
                if (j > 0) {
                    int f = after.charAt(j - 1) + 0;
                    if (f != t - 1) {
                        answer--;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
