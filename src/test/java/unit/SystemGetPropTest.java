package unit;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class SystemGetPropTest {

	@Test
	public void test(Method method) {
		System.out.println(System.getProperty("java.home"));
		System.out.println(method.getName());
		System.out.println(System.getProperty("user.dir"));
	}
	
	public String getMyMachineHost() {
		String hostName = System.getProperty("user.name");
		return hostName;
	}
	
	public String getMethodName(Method method) {
		return method.getName();
	}
}
