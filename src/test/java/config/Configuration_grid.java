package config;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalTime;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import com.pageObject.Landing;
import com.pageObject.Login;
import com.pageObject.Question_generation;
import com.pageObject.Score_page;
import com.pageObject.Worksheet_list;
import com.pageObject.Worksheet_start;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lib_methods.Browser_factory;
import lib_methods.Explicit_timeout;
import lib_methods.Implicit_timeout;
import lib_methods.Log;
import lib_methods.Screenshot;
import lib_methods.Scroll;
import lib_methods.Select_dropdown;
import lib_methods.Sikuli_c;
import lib_methods.Wait_for_pageload;

public class Configuration_grid {
	public static WebDriver driver;
	public Log log;
	public Browser_factory b;
	public Login loginpage;
	public Landing landingpage;
	public ExtentReports r;
	public ExtentTest logger;
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
	public LocalTime time;
	public Wait_for_pageload wp;
	public Sikuli_c sik;
	public Dataset d;
	public String node = "http://192.168.5.153:5566/wd/hub";

	public Configuration_grid() {

		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setVersion("63.0.3239.132");
		capability.setBrowserName("chrome");
		capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		try {
			driver = new RemoteWebDriver(new URL(node), capability);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		log = new Log();
		loginpage = PageFactory.initElements(driver, Login.class);
		landingpage = PageFactory.initElements(driver, Landing.class);
		worksheetlistpage = PageFactory.initElements(driver, Worksheet_list.class);
		worksheetstartpage = PageFactory.initElements(driver, Worksheet_start.class);
		s = new Screenshot(driver);
		wait = new Implicit_timeout(driver);
		e = new Explicit_timeout(driver);
		generationpage = PageFactory.initElements(driver, Question_generation.class);
		Scorepage = PageFactory.initElements(driver, Score_page.class);
		sc = new Scroll(driver);
		sd = new Select_dropdown(driver);
		wp = new Wait_for_pageload(driver);
		sik = new Sikuli_c(driver);
		d = new Dataset();
	}

	@AfterTest
	public void teardown() throws InterruptedException {

		log.tracelog("Test finished");
		r.endTest(logger);
		r.flush();

		try {

			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	// @AfterMethod()
	public void tracerror(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			try {

				filepath = s.Capturescreenshot(driver, result.getName());

				System.out.println(filepath);

				logger.log(LogStatus.FAIL, result.getInstanceName() + "-------Fail", logger.addScreenCapture(filepath));

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}

		else {

			logger.log(LogStatus.PASS, result.getName() + "--------pass");

		}
	}

}
