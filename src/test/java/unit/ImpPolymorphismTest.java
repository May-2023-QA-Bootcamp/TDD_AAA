package unit;

import org.testng.annotations.Test;

public class ImpPolymorphismTest {

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		PolymorphTest parentToChild = new Child();
		System.out.println(parentToChild.getName());//child
		System.out.println(PolymorphTest.name); //parent
		System.out.println(parentToChild.name); //parent
		System.out.println(Child.name);
		PolymorphTest parent = new PolymorphTest();
		System.out.println(parent.getName());//parent
		
	}
}
