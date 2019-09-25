package greedy;

import java.util.Arrays;

public class BigNumber {

    public String solution(String number, int k) {
        String answer = "";
        char[] numbers1 = new char[number.length()];
        char[] numbers2 = new char[number.length()];

        for (int i = 0; i < number.length(); i++) {
            numbers1[i] = number.charAt(i);
            numbers2[i] = number.charAt(i);
        }

        Arrays.sort(numbers1);

        System.out.println(Arrays.toString(numbers1));
        System.out.println(Arrays.toString(numbers2));

        int s = 0;
        outer:
        for (int i = 0; i < numbers1.length; i++) {
            char t = numbers1[i];
            for (int j = 0; j < numbers2.length; j++) {
                if (numbers2[j] == t) {
                    System.out.println(t + " " + numbers2[j]);
                    numbers2[j] = ' ' ;
                    s++;
                    if (k == s) break outer;
                }
            }
        }
        System.out.println(Arrays.toString(numbers2));

        for (int i = 0; i < numbers2.length; i++) if (numbers2[i] != ' ') answer += numbers2[i];

        return answer;
    }
}
