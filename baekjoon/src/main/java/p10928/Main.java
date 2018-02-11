package p10928;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String n = new Scanner(System.in).next();
		StringBuilder sb = new StringBuilder();
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		digest.update(n.getBytes());
		byte[] bytes = digest.digest();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		System.out.println(sb.toString());
	}
}
