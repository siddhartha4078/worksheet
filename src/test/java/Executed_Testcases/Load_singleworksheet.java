package Executed_Testcases;

import java.time.LocalTime;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;


import config.Configuration;


public class Load_singleworksheet extends Configuration {

	public WebDriver driver;
	public double iteration1, iteration2, iteration3, avgs, Starttime1, Starttime2, Starttime3, start, avg2,
			Questionloadtime1, Questionloadtime2, Questionloadtime3, avg1;
	public Stopwatch pageLoad;
	static String pageLoadStatus = null;

	@Test(priority = 1)
	public void Login() throws InterruptedException {

		loginpage.Enter_credentials("siddhartha.student", "123456");
		loginpage.Click_loginbutton();
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

	@Test(dependsOnMethods = { "click_on_chapter" })
	public void click_on_worksheet() throws InterruptedException, FindFailed {

		for (int i = 1; i < 4; i++) {

			worksheetlistpage.Click_on_worksheet("Order : ascending / descending ( worksheet 1 )");

			System.out.println("Attempt no is --" + i + " " + "Started at---" + LocalTime.now());
			System.out.println();

			// System.out.println("Attempt Started at---" + LocalTime.now());
			Thread.sleep(3000);

			if (i == 1) {
				worksheetstartpage.current_worksheetname();
			}

			worksheetstartpage.Start_worksheet();
			System.out.println();

			double qtime = wp.Loadtime();

			Thread.sleep(3000);
			generationpage.attempt_question(9);
			Thread.sleep(3000);
			generationpage.submit();
			double t = wp.scorepageLoadtime("Attempt Again");

			try {

				Scorepage.navigateback();

			} catch (StaleElementReferenceException e) {

				e.printStackTrace();
			}

			Thread.sleep(3000);

			while (i == 1) {

				Questionloadtime1 = qtime;
				iteration1 = t;

				System.out.println("Question start page load time is--" + "" + Questionloadtime1);
				System.out.println("pageload time is--" + "" + iteration1);
				System.out.println();

				break;
			}

			while (i == 2) {

				iteration2 = t;
				Questionloadtime2 = qtime;

				System.out.println("Question start page load time is--" + "" + Questionloadtime2);
				System.out.println("pageload time is--" + "" + iteration2);
				System.out.println();

				break;
			}

			while (i == 3) {

				iteration3 = t;
				Questionloadtime3 = qtime;

				System.out.println("Question start page load time is--" + "" + Questionloadtime3);
				System.out.println("pageload time is--" + "" + iteration3);
				System.out.println();

				sik.click_setM2Slogo();
				break;

			}

		}

	}

	@Test(dependsOnMethods = { "click_on_worksheet" })
	public void calculate_avg() throws FindFailed {

		avg1 = (Questionloadtime1 + Questionloadtime2 + Questionloadtime3) / 3;

		System.err.println("Average question load time is---" + "" + String.format("%.2f", avg1));

		avg2 = (iteration2 + iteration3 + iteration1) / 3;

		System.err.println("Average score time is---" + "" + String.format("%.2f", avg2));
	}
}
