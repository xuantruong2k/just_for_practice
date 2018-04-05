package teddy.test;

public class Flag {

	private int _intValue;
	
	public void Flag() {
		_intValue = 0;
	}
	
	public boolean isOn(int flag) {
		return (_intValue & (1 << flag)) != 0;
	}
	
	public void set(int flag) {
		_intValue |= (1 << flag);
	}
	
	public void clear(int flag) {
		_intValue &= (~(1 << flag));
	}
	
	public void reset() {
		_intValue = 0;
	}
	
	public void runTest(int shiftLen) {
		_intValue = 1;		
		_intValue = _intValue << shiftLen;		
		System.out.println("binary format: " + Utils.displayInBinary(_intValue) + ", decimal: " + _intValue);
	}
	
	public void runTest2() {
		reset();
//		for (int i = 0; i < 32; i++) {
//			set(i);
//		}
		set(0);
		set(1);
		set(2);
		set(30);
		for (int i = 0; i < 32; i++) {
//			reset();
//			set(i);
			if (isOn(i)) {
				String tmp = String.format("%2s", i);
				System.out.println("index: " + tmp + ", binary format: " + Utils.displayInBinary(_intValue)
						+ ", decimal: " + _intValue + ", isOn? " + isOn(i));
			}
		}
		clear(30);
		for (int i = 0; i < 32; i++) {
//			reset();
//			set(i);
			if (isOn(i)) {
			String tmp = String.format("%2s", i);			
			System.out.println("index: " + i 
					+ ", binary format: " + Utils.displayInBinary(_intValue) 
					+ ", decimal: " + _intValue
					+ ", isOn? " + isOn(i)
					);
			}
		}
	}
}
