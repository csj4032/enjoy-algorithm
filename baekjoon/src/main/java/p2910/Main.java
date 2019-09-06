package p2910;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            map.putIfAbsent(t, 0);
            map.put(t, map.get(t) + 1);
        }

        map.entrySet().stream().collect(toMap((k) -> k, (e) -> e));

        map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue(Integer::compareTo)))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (k1, k2) -> k1, LinkedHashMap::new))
                .entrySet()
                .forEach(e -> append(sb, e));

        System.out.println(sb.toString().trim());
    }

    private static void append(StringBuilder sb, Map.Entry<Integer, Integer> e) {
        for (int i = 0; i < e.getValue(); i++) {
            sb.append(e.getKey() + " ");
        }
    }
}
