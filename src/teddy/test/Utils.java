package teddy.test;

public class Utils {
	
	// display integer value in binary character (1 integer = 4 bytes = 32 bits)
	public static String displayInBinary(int value) {
		String str = String.format("%32s", Integer.toBinaryString(value)).replace(' ', '0');		
		return str;
	}

	// display long value in binary character (1 long = 8 bytes = 64 bits)
	public static String displayInBinary(long value) {
		String str = String.format("%64s", Long.toBinaryString(value)).replace(' ', '0');		
		return str;
	}
	
	public static String formatInt2Str(int value, int numOfChar) {
		String f = "%" + numOfChar + "s";
		return String.format(f, value);
	}
}
