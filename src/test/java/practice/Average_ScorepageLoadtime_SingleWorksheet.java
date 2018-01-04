package practice;

import java.time.LocalTime;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import configuration.TestNg_Config;

public class Average_ScorepageLoadtime_SingleWorksheet extends TestNg_Config {

	public WebDriver driver;
	public double iteration1, iteration2, iteration3, avgs, Starttime1, Starttime2, Starttime3, start, avg2;
	public StopWatch pageLoad;

	@Test(priority = 1)
	public void Login() throws InterruptedException {

		loginpage.Enter_credentials("performance.test", "123456");
		loginpage.Click_loginbutton();
		Thread.sleep(3000);

	}

	@Test(dependsOnMethods = { "Login" })
	public void select_class() throws InterruptedException {
		landingpage.checkofdeaultclass();

	}

	@Test(dependsOnMethods = { "select_class" })
	public void click_on_bookandworksheet_hidder() throws InterruptedException {
		landingpage.click_on_bookandworksheet_hidder();
		Thread.sleep(3000);

	}

	@Test(dependsOnMethods = { "click_on_bookandworksheet_hidder" })
	public void click_on_assignmenttype() throws InterruptedException {

		landingpage.Click_on_assignmenttype("Level 3");

		Thread.sleep(6000);
	}

	@Test(dependsOnMethods = { "click_on_assignmenttype" })
	public void click_on_book() throws InterruptedException {

		landingpage.Click_on_book("Math Skills L3");
		Thread.sleep(3000);

	}

	@Test(dependsOnMethods = { "click_on_book" })
	public void click_on_chapter() throws InterruptedException {

		landingpage.Click_on_chapter("Fractions");

	}

	@Test(invocationCount=3,dependsOnMethods = { "click_on_chapter" })
	public void click_on_worksheet() throws InterruptedException, FindFailed {

		worksheetlistpage.Click_on_worksheet("Order : ascending / descending ( worksheet 1 )");

		System.out.println("Attempt  Started at---" + LocalTime.now());

		Thread.sleep(3000);

		worksheetstartpage.current_worksheetname();
		worksheetstartpage.Start_worksheet();

		Thread.sleep(3000);
		generationpage.click_on_questionnumber(9);
		Thread.sleep(3000);
		generationpage.submit();
		double t = wp.scorepageLoadtime("Attempt Again");
		
		System.err.println("pageload time is--" + "" +t);
		Scorepage.navigateback();
	

	}

	@Test(dependsOnMethods = { "click_on_worksheet"})
	public void calculate_avg() throws FindFailed {
		sik.click_setM2Slogo();
	
	}
}
