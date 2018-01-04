package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser_factory {
	public WebDriver driver;
	public String Chromelocation = "E:\\Siddhartha\\Selenium\\Browser Drivers\\chromedriver_win32\\chromedriver.exe";
	private String IElocation = "E:\\Siddhartha\\Selenium\\Browser Drivers\\IEDriverServer_Win32_3.3.0\\IEDriverServer.exe";
	private String firefoxlocation = "E:\\Siddhartha\\Selenium\\Browser Drivers\\geckodriver-v0.19.1-win64\\geckodriver.exe";

	public WebDriver initiate_browser(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", Chromelocation);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);

		}

		else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",IElocation);
			driver = new InternetExplorerDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",firefoxlocation);
			driver = new FirefoxDriver();
		}

		return driver;

	}
}
