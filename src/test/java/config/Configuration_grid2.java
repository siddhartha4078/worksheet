package config;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import com.pageObject.Landing;
import com.pageObject.Login;
import com.pageObject.Question_generation;
import com.pageObject.Score_page;
import com.pageObject.Worksheet_list;
import com.pageObject.Worksheet_start;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import lib_methods.Browser_factory;
import lib_methods.Explicit_timeout;
import lib_methods.Implicit_timeout;
import lib_methods.Log;
import lib_methods.Navigate;
import lib_methods.Screenshot;
import lib_methods.Scroll;
import lib_methods.Select_dropdown;
import lib_methods.Sikuli_c;
import lib_methods.Wait_for_pageload;
import lib_methods.pageLoad;

public class Configuration_grid2 {
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
	public String node = "http://192.168.5.68:5566/wd/hub";
	public Navigate Navigate;
	public pageLoad p;

	public Configuration_grid2() {

		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setVersion("63.0.3239.132");
		capability.setBrowserName("chrome");
		capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		try {
			driver = new RemoteWebDriver(new URL(node), capability);
			driver.get("https://uatmath2shine.azurewebsites.net/PreuatWorksheetAlpha/");
			driver.manage().window().maximize();
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
		Navigate = new Navigate(driver);
		p = new pageLoad(driver);
	}

	

}
