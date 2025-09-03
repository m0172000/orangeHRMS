package commonUtlis;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public static WebDriver driver;

	public CommonDataReader DataReader;
	public static WebDriverWait wait;

	@BeforeSuite
	public void setUp() throws MalformedURLException, Throwable {
		DataReader = new CommonDataReader();
		String browser = DataReader.getProperty("browser");
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equals("firfox")) {
			driver=new FirefoxDriver();
		}else {
            Assert.fail("The browser is not launched. Please check your config.");

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));

	}

	@AfterSuite
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
