package teddy.test;

public class Utils {
	
	/// display integer value in binary character (1 integer = 4 bytes = 32 bits)
	public static String displayInBinary(int value) {
		String str = String.format("%32s", Integer.toBinaryString(value)).replace(' ', '0');		
		return str;
	}
}
