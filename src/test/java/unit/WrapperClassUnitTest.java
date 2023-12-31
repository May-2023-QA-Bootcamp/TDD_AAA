package unit;

import org.testng.annotations.Test;

public class WrapperClassUnitTest {

	@Test(enabled = false)
	public void wrapperClasssTests() {
		byte n = 121;
		Byte b = 121;
		System.out.println(n);
		System.out.println(b.byteValue());
	}
	
	static char c;
	static boolean b;
	@Test(enabled = false)
	public void defaultValue() {
		System.out.println("deafult value: " + c);
		System.out.println((int)c);
		System.out.println(b);
	}
	
	@Test(enabled = false)
	public void casting() {
		int i = 123;
		System.out.println((byte)i);
		long l = i;
		System.out.println(l);
		byte b = (byte)i;
		System.out.println(b);
	}
}
