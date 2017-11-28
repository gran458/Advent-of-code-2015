
public class Day07 {
	
	public static byte[] inttobyte (int x) {
		byte[] result = new byte[16];
		int i = 15;
		
		while (x > 0) {
			result[i] = (byte) (x % 2);
			x /= 2;
			i--;
		}
		
		return result;
	}
	
	public static int bytetoint (byte[] b) {
		int result = 0;
		int e = 1;
		
		for (int i = 15; i >= 0; i--) {
			result += (b[i] * e);
			e *= 2;
		}
		
		return result;
	}
	
	public static byte[] or (byte[] b1, byte[] b2) {
		byte[] result = new byte[16];
		
		for (int i = 0; i < 16; i++) {
			if (b1[i] == 0 && b2[i] == 0) {
				result[i] = 0;
			}
			else {
				result[i] = 1;
			}
		}
		
		return result;
	}
	
	public static byte[] and (byte[] b1, byte[] b2) {
		byte[] result = new byte[16];
		
		for (int i = 0; i < 16; i++) {
			if (b1[i] == 1 && b2[i] == 1) {
				result[i] = 1;
			}
			else {
				result[i] = 0;
			}
		}
		
		return result;
	}
	
	public static byte[] not (byte[] b) {
		byte[] result = new byte[16];
		
		for (int i = 0; i < 16; i++) {
			result[i] = (byte) ((b[i] + 1) % 2);
		}
		
		return result;
	}
	
	public static byte[] lshift (byte[] b, int x) {
		byte[] result = new byte[16];
		int j = 0;
		
		for (int i = x; i < 16; i++) {
			result[j] = b[i];
			j++;
		}
		
		return result;
	}
	
	public static byte[] rshift (byte[] b, int x) {
		byte[] result = new byte[16];
		int j = 0;
		
		for (int i = x; i < 16; i++) {
			result[i] = b[j];
			j++;
		}
		
		return result;
	}
	
	public static boolean allinstructionsdone (String[] s) {
		
		int sum = 0;
		
		for (int i = 0; i < s.length; i++) {
			sum += s[i].length();
		}
		
		if (sum == 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		// test
		byte[] b1 = inttobyte(123);
		byte[] b2 = inttobyte(456);
		int x = bytetoint(and(b1,b2));
		System.out.println(x);
		x = bytetoint(or(b1,b2));
		System.out.println(x);
		x = bytetoint(not(b1));
		System.out.println(x);
		x = bytetoint(not(b2));
		System.out.println(x);
		x = bytetoint(lshift(b1,2));
		System.out.println(x);
		x = bytetoint(rshift(b2,2));
		System.out.println(x);
	}

}
