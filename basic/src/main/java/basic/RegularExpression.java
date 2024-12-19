package basic;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class RegularExpression {
    public static void main(String[] args) {
        Integer[] d = new Integer[]{0, 1};
        String s = "";
        nonnull(s);
        Pattern p = Pattern.compile("^(\\S)(?=.*\\d)(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]).{4,16}$");
        Matcher m = p.matcher("aaaa#dd1>1");
        while (m.find()) System.out.println(m.group(0));
        System.out.println(Arrays.stream(new Integer[]{1, 23, 4, 9, 62}).map(String::valueOf).collect(joining()));
    }


    public static String nonnull(@Nonnull String s) {
        return s;
    }

    private static int solution3(String S) {
        return Arrays.stream(S.split("[0-9]+")).filter(s -> s.matches(".*[A-Z].*")).map(String::length).max(Comparator.comparing(Integer::valueOf)).orElse(-1);
    }
}