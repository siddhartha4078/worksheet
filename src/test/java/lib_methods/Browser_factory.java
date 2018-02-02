package lib_methods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser_factory {
	public WebDriver driver;
	public String Chromelocation = "E:\\Siddhartha\\Selenium\\Browser Drivers\\chromedriver_win32\\chromedriver.exe";
	private String IElocation = "E:\\Siddhartha\\Selenium\\Browser Drivers\\IEDriverServer_Win32_3.3.0\\IEDriverServer.exe";
	public String firefoxlocation = "E:\\Siddhartha\\Selenium\\Browser Drivers\\geckodriver-v0.19.1-win64.zip\\geckodriver.exe";
	public String node = "http://192.168.5.120//wd//hub";


	public WebDriver initiate_browser(String browser) throws MalformedURLException {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\Siddhartha\\Selenium\\Browser Drivers\\chrome\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);

		}

		else if (browser.equalsIgnoreCase("IE")) {
			
//			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//
//			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			System.setProperty("webdriver.ie.driver", IElocation);
			
			driver = new InternetExplorerDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\Siddhartha\\Selenium\\Browser Drivers\\geckodriver-v0.19.1-win64.zip\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("remote")) {

			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setBrowserName("Chrome");
			capability.setPlatform(Platform.VISTA);

			driver = new RemoteWebDriver(new URL(node), capability);

		}

		return driver;

	}
}
