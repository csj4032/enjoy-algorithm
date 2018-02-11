package p10930;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		StringBuilder sb = new StringBuilder();
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(n.getBytes());
		byte[] bytes = digest.digest();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		System.out.println(sb.toString());
	}
}
