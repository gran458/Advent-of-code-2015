import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day04 {
	
	public static boolean checkmd5 (String s) {
		for (int i = 0; i < 5; i++) {
			if (s.charAt(i) != '0') {
				return false;
			}
		}
		return true;
	}
	
	public static String md5 (String s) {
		try {
			byte[] bytesOfMessage = s.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(bytesOfMessage);
			BigInteger bigInt = new BigInteger(1, thedigest);
			String hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32 chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		
		String input = "ckczppom";
		int i = 0;
		String word = input + i;
		word = md5(word);
		
		while (!checkmd5(word)) {
			i++;
			word = input + i;
			word = md5(word);
		}
		
		System.out.println(i);
	}

}
