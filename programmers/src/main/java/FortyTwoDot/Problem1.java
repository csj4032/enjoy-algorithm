package FortyTwoDot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Problem1 {


    // card 배열을 2차원 배열로 분해 하고 word 배열에 있는 단어들과 비교하여 같은 단어가 있으면 해당 단어를 반환한다.
    // 같은 단어가 없으면 "-1"를 반환한다.
    public String[] solution(String[] card, String[] word) {
        List<String> answer = new ArrayList<>();
        String[][] cardArray = new String[card.length][];
        for (int i = 0; i < card.length; i++) cardArray[i] = card[i].split("");

        for (int i = 0; i < word.length; i++) {
            String[] wordArray = word[i].split("");
            boolean[] wordCheck = new boolean[wordArray.length];
            boolean[] cardCheck = new boolean[3];

            for (int j = 0; j < wordArray.length; j++) {
                for (int k = 0; k < cardArray.length; k++) {
                    for (int l = 0; l < cardArray[k].length; l++) {
                        if (wordArray[j].equals(cardArray[k][l])) {
                            cardArray[k][l] = "0";
                            wordCheck[j] = true;
                            cardCheck[k] = true;
                            break;
                        }
                    }

                }
            }

            System.out.println(Arrays.toString(wordCheck));
            System.out.println(Arrays.toString(cardCheck));

            boolean flag = true;
            for (int o = 0; o < wordCheck.length; o++) {
                for (int p = 0; p < cardCheck.length; p++) {
                    if (!wordCheck[o] || !cardCheck[p]) {
                        flag = false;
                        break;
                    }
                }
            }
            for (int q = 0; q < card.length; q++) cardArray[q] = card[q].split("");

            if (flag) {
                answer.add(word[i]);
            }

        }
        if (answer.isEmpty()) answer.add("-1");
        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Problem1 problemOne = new Problem1();
        String[] card = {"ABACDEFG", "NOPQRSTU", "HIJKLKMM"};
        String[] word = {"GPQM", "MMNA"};
//        String[] card = {"AABBCCDD", "KKKKJJJJ", "MOMOMOMO"};
//        String[] word = {"AAAKKKKKMMMMM", "ABCDKJ"};
        System.out.println(Arrays.toString(problemOne.solution(card, word)));
    }
}
