package configuration;

import java.time.LocalTime;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.pageObject.*;
import library.Browser_factory;
import library.DataConfig;
import library.Explicit_timeout;
import library.Implicit_timeout;
import library.Log;
import library.Screenshot;
import library.Scroll;
import library.Select_dropdown;
import library.Sikuli_c;
import library.Wait_for_pageload;

public class TestNg_Config {
	public static WebDriver driver;
	public Log log;
	public Browser_factory b;
	public Login loginpage;
	public Landing landingpage;
	// public ExtentReports r;
	public Screenshot s;
	// public ExtentTest logger;
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
	public dataset d;

	public DataConfig dt;

	public TestNg_Config() {
		b = new Browser_factory();
		driver = b.initiate_browser("chrome");
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
		dt = new DataConfig("C:\\Users\\Siddhartha\\Desktop\\Performance testing.xls");
		sik = new Sikuli_c(driver);
		d = new dataset();

	}

	@BeforeSuite
	public void Openbrowser() {
		driver.get("https://uatmath2shine.azurewebsites.net/uatWorksheetalpha");
		driver.manage().window().maximize();
		// logger = r.startTest("Test initiated");
		log.tracelog("Test started");

	}

	@AfterTest
	public void teardown() throws InterruptedException {

		log.tracelog("Test finished");
		// r.endTest(logger);
		// r.flush();

		// driver.get("E:\\Siddhartha\\Projects\\Automation-neon\\com.worksheet\\report\\report.html");

		try {

			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		driver.close();
	}

	@AfterMethod()
	public void tracerror(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			try {

				filepath = s.Capturescreenshot(driver, result.getName());

				System.out.println(filepath);

				// logger.log(LogStatus.FAIL, result.getName() + "-------Fail",
				// logger.addScreenCapture(filepath));

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}

		}

		else {

			// logger.log(LogStatus.PASS, result.getName() + "--------pass");

		}

	}
}
