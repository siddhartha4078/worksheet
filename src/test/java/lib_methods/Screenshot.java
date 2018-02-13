package lib_methods;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import ru.yandex.qatools.ashot.AShot;

public class Screenshot {

	public WebDriver driver;

	public Screenshot(WebDriver drv) {
		this.driver = drv;

	}

	public String Capturescreenshot(WebDriver driver, String Screenshotname) throws IOException {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sc = ts.getScreenshotAs(OutputType.FILE);

			String dest = "E:\\Siddhartha\\Projects\\Automation-neon\\MMM.zip_expanded\\com.Makemymeal_\\"
					+ Screenshotname + ".jpeg";

			FileUtils.copyFile(sc, new File(dest));
			return dest;

		} catch (Exception e) {
			System.out.println("exception while taking screenshot" + e.getMessage());
			return e.getMessage();
		}

	}

	public void Element_screenshot(WebElement ele) {

		try {
			Thread.sleep(3000);
			ru.yandex.qatools.ashot.Screenshot screenshot = new AShot().takeScreenshot(driver, ele);

			ImageIO.write(screenshot.getImage(), "PNG",
					new File(System.getProperty("user.dir") + "/src/test/resources/TestData/ElementScreenshot.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
