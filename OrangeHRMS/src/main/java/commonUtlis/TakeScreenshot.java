package commonUtlis;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	
	private WebDriver driver;

    public TakeScreenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void captureScreenshot(String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().toString().replace(':', '-');

            File destDir = new File("./Screenshots/");            

            File destFile = new File(destDir, screenshotName + "_" + timestamp + ".png");
            FileUtils.copyFile(source, destFile);

            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (Throwable e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}
