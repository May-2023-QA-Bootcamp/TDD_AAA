package constants;

public enum Attribute {

	MAX_LENGTH("maxlength");
	
	String attribute;
	
	private Attribute(String attribute) {
		this.attribute = attribute;
	}
	
	public String getAttribute() {
		return attribute;
	}
	
	@Override
	public String toString() {
		return attribute;
	}
}
