package p10929;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-224");
		messageDigest.update(sc.next().getBytes());
		byte byteData[] = messageDigest.digest();
		System.out.println(bytesToHex(byteData));
	}

	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1) hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
