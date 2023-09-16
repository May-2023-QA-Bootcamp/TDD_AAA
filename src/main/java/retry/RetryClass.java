package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}

}
