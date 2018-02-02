package config;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.pageObject.*;
import lib_methods.*;

public class Browserstack {
	public static WebDriver driver;
	public static final String USERNAME = "jignesh105";
	public static final String AUTOMATE_KEY = "c4SxKxJGQHzFPZtVHh26";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

	public Log log;
	public Browser_factory b;
	public Login loginpage;
	public Landing landingpage;
	public Screenshot s;

	public String filepath;
	public Implicit_timeout wait;
	public Worksheet_list worksheetlistpage;
	public Worksheet_start worksheetstartpage;
	public Explicit_timeout e;
	public Question_generation generationpage;
	public Score_page Scorepage;
	public Scroll sc;
	public Select_dropdown sd;
	public WebElement link;

	public Browserstack() throws MalformedURLException {
		loginpage = PageFactory.initElements(driver, Login.class);
		landingpage = PageFactory.initElements(driver, Landing.class);
		worksheetlistpage = PageFactory.initElements(driver, Worksheet_list.class);
		worksheetstartpage = PageFactory.initElements(driver, Worksheet_start.class);
		s = new Screenshot(driver);
		wait = new Implicit_timeout(driver);
		e = new Explicit_timeout(driver);
		generationpage = PageFactory.initElements(driver, Question_generation.class);
		Scorepage = PageFactory.initElements(driver, Score_page.class);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "11.2");
		caps.setCapability("device", "iPad Pro");
		caps.setCapability("real_mobile", "true");
		caps.setCapability("browserstack.selenium_version", "3.8.0");
		caps.setCapability("browserstack.debug", true);

		URL browserStackUrl = new URL(URL);
		driver = new RemoteWebDriver(browserStackUrl, caps);
	}

	@BeforeSuite
	public void Openbrowser() throws InterruptedException, MalformedURLException {

		
		driver.get("https://uatmath2shine.azurewebsites.net/preuatWorksheetalpha");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("UserName")).sendKeys("siddhartha.student");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();

	}

}