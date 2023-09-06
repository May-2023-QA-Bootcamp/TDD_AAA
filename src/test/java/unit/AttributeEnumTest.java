package unit;

import org.testng.annotations.Test;

import constants.Attribute;

public class AttributeEnumTest {

	@Test
	public void attribuyteEnumTests() {
		System.out.println(Attribute.MAX_LENGTH);
		System.out.println(Attribute.MAX_LENGTH.toString());
		System.out.println(Attribute.MAX_LENGTH.name());
		System.out.println(Attribute.MAX_LENGTH.getAttribute());
	}
}
