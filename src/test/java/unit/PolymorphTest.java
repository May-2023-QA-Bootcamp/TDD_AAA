package unit;

public class PolymorphTest {

	static String name = "Parent";
	
	public String getName() {
		return name;
	}
}

class Child extends PolymorphTest{
	static String name = "Child";
	
	@Override
	public String getName() {
		return name;
	}
}
