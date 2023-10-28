package constants;

public enum BS_Key{

	BS_USER("user"), BS_ACCESS("access"), BS_URL("browserstack_url"), BS_OS_NAME("os"), BS_OS_VERSION("os_version"), BS_BROWSER("browser_name"),
	BS_BROWSER_VERSION("browser_version"), BS_DEVICE("device_name"), BS_DEVICE_ORIENTETION("device_orientation"), BS_MODE("mode");
	
	String key;
	
	private BS_Key(String key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		return key;
	}
}
