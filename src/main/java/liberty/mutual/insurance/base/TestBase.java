package liberty.mutual.insurance.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import liberty.mutual.insurance.constants.KeyConfig;
import liberty.mutual.insurance.pages.HomePage;
import liberty.mutual.insurance.utils.ReadConfig;
import static liberty.mutual.insurance.constants.IBrowserConstant.*;
import java.time.Duration;

public class TestBase {

	public static WebDriver driver;
	ReadConfig config;
	protected HomePage homePage;
	
	@BeforeSuite
	public void beforeSuiteSetUp() {
		config = new ReadConfig();
	}
	
	@Parameters(BROWSER)
	@BeforeMethod
	public void setUpDriver(@Optional(CHROME) String browserName) {
		driver = initializingBrowser(browserName);
		int pageLoadTime = Integer.parseInt(config.getValue(KeyConfig.pageLoadTime));
		int implicitWaitTime = Integer.parseInt(config.getValue(KeyConfig.impliciteWaitLoad));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
		driver.get(config.getValue(KeyConfig.url));
		initObjectClass();
	}
	
	public WebDriver initializingBrowser(String browserName) {
		switch (browserName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		case EDGE:
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			return new SafariDriver();
		default:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}
	}
	
	public void initObjectClass() {
		homePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
}
