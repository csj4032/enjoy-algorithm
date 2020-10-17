package p10934;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		MessageDigest sh = MessageDigest.getInstance("SHA1");//SHA-256방식으로 암호화
		sh.update(n.getBytes()); //갱신
		byte byteData[] = sh.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {//입력
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		System.out.println(sb.toString());
	}
}
//a25cdb0b8ead2861a3ef2c48cdc15517994ab278