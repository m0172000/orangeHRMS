package commonUtlis;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerImp implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("INFO :- Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("PASS :- Test Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAIL :- Test Failed: " + result.getName());
		System.out.println("ERROR :- Reason: " + result.getThrowable());
		try {
			WebDriver driver = ((BaseClass) result.getInstance()).driver;

			TakeScreenshot ts = new TakeScreenshot(driver);
			ts.captureScreenshot(result.getName());

		} catch (Exception e) {
			System.out.println("Could not capture screenshot: " + e.getMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIP :- Test Skipped: " + result.getName());
	}
}
