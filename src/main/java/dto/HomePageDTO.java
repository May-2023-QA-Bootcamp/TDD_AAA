package dto;

public class HomePageDTO {

	String title;
	String zipCode;
	String homepageTitle;
	
	public HomePageDTO(String title, String zipCode, String homepageTitle) {
		this.title = title;
		this.zipCode = zipCode;
		this.homepageTitle = homepageTitle;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public String getHomepageTitle() {
		return homepageTitle;
	}

}
