package p15740;

import java.math.BigInteger;
import java.util.Scanner;


/**
 * 제목 : A+B - 9
 * URL : https://www.acmicpc.net/problem/15740
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        System.out.println(a.add(b).toString());
    }
}