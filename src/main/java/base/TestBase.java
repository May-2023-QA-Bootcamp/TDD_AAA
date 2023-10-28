package base;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import common.CommonActions;
import constants.BS_Key;
import constants.BS_Mode;
import constants.KeyConfig;
import constants.Profile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import reports.ExtentManager;
import reports.ExtentTestManager;
import utils.ReadConfig;
import static constants.IBrowserConstant.*;
import static constants.IBrowserStack.*;
import static constants.BS_Key.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class TestBase {

	WebDriver driver;
	ReadConfig config;
	ExtentReports report;
	ExtentTest extentTest;
	
	// Object Pages
	protected HomePage homePage;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeSuite
	public void initialReporting() {
		report = ExtentManager.initialReports();
	}
	
	@BeforeClass
	public void beforeClassSetUp() {
		config = new ReadConfig(Profile.GENERAL);
	}
	
	// browser parameter will come from testng suite or runtime
	// @Optional("chrome") will take care in case we miss browser param value
	@Parameters(BROWSER)
	@BeforeMethod
	public void setUpDriver(@Optional(FIREFOX) String browserName) {
		driver = initializingBrowser(browserName);
		driver.manage().window().maximize();
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
		case REMOTE:
			return getRemoteDriver();
		default:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}
	}
	
	public void initObjectClass() {
		homePage = new HomePage(driver);
	}
	
	@BeforeMethod
	public void initialTest(Method method) {
		extentTest = ExtentTestManager.createTest(report, method.getName());
		extentTest.assignCategory(method.getDeclaringClass().getName());
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		for(String group: result.getMethod().getGroups()) {
			extentTest.assignCategory(group);
		}
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test PASSED");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.addScreenCaptureFromPath(CommonActions.getSreenShot(method.getName(), driver));
			extentTest.log(Status.FAIL, "Test FAILED");
		}else if(result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test SKIPPED");
		}
	}
	
	public WebDriver getRemoteDriver() {
		ReadConfig bsConfig = new ReadConfig(Profile.BROWSERSTACK);
		
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		
		if(bsConfig.getValue(BS_MODE).equalsIgnoreCase(BS_Mode.BROWSER.toString())) 
		{
			browserstackOptions.put(BS_OS, bsConfig.getValue(BS_OS_NAME));
			browserstackOptions.put(BS_OS_VER, bsConfig.getValue(BS_OS_VERSION));
		}
		else if(bsConfig.getValue(BS_MODE).equalsIgnoreCase(BS_Mode.DEVICE.toString())) 
		{
			browserstackOptions.put(BS_DEVICE_NAME, bsConfig.getValue(BS_DEVICE));
			browserstackOptions.put(BS_DEVICE_ORIENT, bsConfig.getValue(BS_DEVICE_ORIENTETION));
		}
		
		capabilities.setCapability(BS_BROWSER_NAME, bsConfig.getValue(BS_BROWSER));
		capabilities.setCapability(BS_BROWSER_VER, bsConfig.getValue(BS_Key.BS_BROWSER_VERSION));
		capabilities.setCapability(BS_OPT, browserstackOptions);
		
		String urlString = "https://" + bsConfig.getValue(BS_USER) + ":" + bsConfig.getValue(BS_ACCESS) + 
				bsConfig.getValue(BS_URL);
		
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
        return new RemoteWebDriver(url, capabilities);
	}
	
	@AfterSuite
	public void publishReport() {
		report.flush();
	}
}
