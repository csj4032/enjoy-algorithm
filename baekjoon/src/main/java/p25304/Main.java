package p25304;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            int quantity = sc.nextInt();
            total -= price * quantity;
        }
        if (total == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
