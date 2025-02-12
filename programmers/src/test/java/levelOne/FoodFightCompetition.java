package levelOne;

public class FoodFightCompetition {

    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int repeat = food[i] / 2;
            for (int j = 0; j < repeat; j++) answer.append(i);
        }
        String result = answer.toString();
        return result + "0" + answer.reverse();
    }
}
