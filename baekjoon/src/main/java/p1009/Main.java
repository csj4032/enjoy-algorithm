package p1009;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 제목 : 분산처리
 * 링크 : https://www.acmicpc.net/problem/1009
 * 메모 :
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String a = sc.next();
            String b = sc.next();
            BigInteger modPow = new BigInteger(a).modPow(new BigInteger(b), BigInteger.TEN);
            System.out.println(modPow.intValue() == 0 ? 10 : modPow.toString());
        }
    }
}