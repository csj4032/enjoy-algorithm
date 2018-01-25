package p10927;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(n.getBytes());
			byte[] digest = md.digest();
			String hash = DatatypeConverter.printHexBinary(digest).toLowerCase();
			System.out.println(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}