package levelOne;

import java.util.HashMap;
import java.util.Map;

public class AssessingPersonalityTypes {

    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        String[] personalityTypes = {"R", "T", "C", "F", "J", "M", "A", "N"};
        Map<String, Integer> typeMap = new HashMap<>();
        for (String type : personalityTypes) typeMap.put(type, 0);

        for (int i = 0; i < survey.length; i++) {
            String typeA = survey[i].substring(0, 1);
            String typeB = survey[i].substring(1, 2);
            int score = choices[i] - 4;
            if (score < 0) {
                typeMap.put(typeA, typeMap.get(typeA) + Math.abs(score));
            } else if (score > 0) {
                typeMap.put(typeB, typeMap.get(typeB) + score);
            }
        }

        String[] typePairs = {"RT", "CF", "JM", "AN"};
        for (String pair : typePairs) {
            char type1 = pair.charAt(0);
            char type2 = pair.charAt(1);
            answer.append((typeMap.get(String.valueOf(type1)) < typeMap.get(String.valueOf(type2))) ? type2 : type1);
        }
        return answer.toString();
    }
}
