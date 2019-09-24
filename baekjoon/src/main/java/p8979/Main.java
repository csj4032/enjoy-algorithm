package p8979;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Country> countries = new LinkedList();
        for (int i = 0; i < n; i++) countries.add(new Country(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        countries.sort(Comparator.comparing(Country::getGold, Comparator.reverseOrder()).thenComparing(Country::getSilver, Comparator.reverseOrder()).thenComparing(Country::getBronze, Comparator.reverseOrder()));
        LinkedHashMap<String, List<Country>> map = countries.stream().collect(Collectors.groupingBy(Country::toString, LinkedHashMap::new, Collectors.toList()));

        AtomicInteger atomicInteger = new AtomicInteger(1);
        map.entrySet().stream().forEach(e -> {
            int r = atomicInteger.get();
            e.getValue().forEach(c -> {
                atomicInteger.getAndIncrement();
                c.rank = r;
            });
        });

        map.entrySet().stream().forEach(e -> {
            e.getValue().forEach(c -> {
                if (c.no == k) {
                    System.out.println(c.rank);
                }
            });
        });
    }
}

class Country {
    Integer no;
    Integer rank;
    Integer gold;
    Integer silver;
    Integer bronze;

    public Country(int no, int gold, int silver, int bronze) {
        this.no = no;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public int getGold() {
        return gold;
    }

    public int getSilver() {
        return silver;
    }

    public int getBronze() {
        return bronze;
    }

    @Override
    public String toString() {
        return gold + ":" + silver + ":" + bronze;
    }
}